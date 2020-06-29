package de.metas.inoutcandidate.spi.impl;

/*
 * #%L
 * de.metas.handlingunits.base
 * %%
 * Copyright (C) 2015 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.adempiere.mm.attributes.AttributeCode;
import org.adempiere.mm.attributes.api.IAttributeDAO;
import org.compiere.model.I_M_Attribute;

import com.google.common.annotations.VisibleForTesting;

import de.metas.handlingunits.IHUContext;
import de.metas.handlingunits.attribute.HUAttributeConstants;
import de.metas.handlingunits.attribute.IAttributeValue;
import de.metas.handlingunits.attribute.storage.IAttributeStorage;
import de.metas.handlingunits.attribute.storage.IAttributeStorageFactory;
import de.metas.handlingunits.attribute.weightable.IWeightable;
import de.metas.handlingunits.attribute.weightable.Weightables;
import de.metas.handlingunits.model.I_M_HU;
import de.metas.handlingunits.model.I_M_InOutLine;
import de.metas.inout.api.IQualityNoteDAO;
import de.metas.inout.model.I_M_QualityNote;
import de.metas.quantity.Quantity;
import de.metas.util.Check;
import de.metas.util.Services;
import lombok.NonNull;

/**
 * A wrapper for an {@link I_M_HU} (a TU to be more precise), to access those HU attributes that are relevant for receipt {@link I_M_InOutLine}s.<br>
 * Basically, these properties decide if two HUs can be mapped to the same receipt line or not.
 * <p>
 * Use {@link #newInstance(IHUContext, I_M_HU)} to get an instance for production use.
 *
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
/* package */class HUReceiptLinePartAttributes
{
	//
	// Services
	private final IAttributeDAO attributeDAO = Services.get(IAttributeDAO.class);

	//
	// Params
	private final IHUContext huContext;
	private final I_M_HU tuHU;
	private final String id;

	//
	// Attributes
	private final I_M_Attribute attr_QualityDiscountPercent;
	private final I_M_Attribute attr_QualityNotice;
	private final I_M_Attribute attr_SubProducerBPartner;

	public static HUReceiptLinePartAttributes newInstance(final IHUContext huContext, final I_M_HU tuHU)
	{
		return new HUReceiptLinePartAttributes(huContext, tuHU);
	}

	/**
	 * This constructor exist to that the class can be overridden by unit tests. If you override this class, please make sure to override all its public methods.<br>
	 * Also, make sure that huContext is set.
	 * <p>
	 * If you need a "real" instance, please use {@link #newInstance(IHUContext, I_M_HU)}.
	 */
	@VisibleForTesting
	HUReceiptLinePartAttributes()
	{
		this.id = "<NULL>";
		this.huContext = null;
		this.tuHU = null;
		this.attr_QualityDiscountPercent = null;
		this.attr_QualityNotice = null;
		this.attr_SubProducerBPartner = null;
	}

	private HUReceiptLinePartAttributes(@NonNull final IHUContext huContext, @NonNull final I_M_HU tuHU)
	{
		this.huContext = huContext;

		Check.assume(tuHU.getM_HU_ID() > 0, "tuHU exists");
		this.tuHU = tuHU;
		id = String.valueOf(tuHU.getM_HU_ID());

		//
		attr_QualityDiscountPercent = attributeDAO.retrieveAttributeByValue(HUAttributeConstants.ATTR_QualityDiscountPercent_Value);
		attr_QualityNotice = attributeDAO.retrieveAttributeByValue(HUAttributeConstants.ATTR_QualityNotice_Value);
		attr_SubProducerBPartner = attributeDAO.retrieveAttributeByValue(HUAttributeConstants.ATTR_SubProducerBPartner_Value);
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + " ["
				+ "tuHU=" + tuHU
				+ "]";
	}

	public String getId()
	{
		return id;
	}

	private final IAttributeStorage getAttributeStorage()
	{
		final IAttributeStorageFactory attributeStorageFactory = huContext.getHUAttributeStorageFactory();
		final IAttributeStorage attributeStorage = attributeStorageFactory.getAttributeStorage(tuHU);
		return attributeStorage;
	}

	public Object getAttributeStorageAggregationKey()
	{
		final Map<AttributeCode, Object> key = new TreeMap<>();

		final IAttributeStorage attributeStorage = getAttributeStorage();
		for (final IAttributeValue attributeValue : attributeStorage.getAttributeValues())
		{
			// Only consider attributes which are usable in ASI
			if (!attributeValue.isUseInASI())
			{
				continue;
			}

			final AttributeCode name = attributeValue.getAttributeCode();
			final Object value = attributeValue.getValue();
			key.put(name, value);
		}

		return key;
	}

	/**
	 * @return quality discount percent (between 0...100); never return null
	 */
	public BigDecimal getQualityDiscountPercent()
	{
		final IAttributeStorage attributeStorage = getAttributeStorage();

		if (!attributeStorage.hasAttribute(attr_QualityDiscountPercent))
		{
			return BigDecimal.ZERO;
		}

		final BigDecimal qualityDiscountPercent = attributeStorage.getValueAsBigDecimal(attr_QualityDiscountPercent);
		if (qualityDiscountPercent == null)
		{
			return BigDecimal.ZERO;
		}

		return qualityDiscountPercent;
	}

	public String getQualityNoticeDisplayName()
	{
		final IAttributeStorage attributeStorage = getAttributeStorage();

		if (!attributeStorage.hasAttribute(attr_QualityNotice))
		{
			return null;
		}

		// if the quality notice is set, then take it's name. It must have a qualityDiscount% to be set
		final Object qualityNoticeCode = attributeStorage.getValue(attr_QualityNotice);
		if (qualityNoticeCode == null)
		{
			return null;
		}

		final String qualityNoticeName = attributeStorage.getValueName(attr_QualityNotice);
		return qualityNoticeName;
	}

	public int getSubProducer_BPartner_ID()
	{
		final IAttributeStorage attributeStorage = getAttributeStorage();
		if (!attributeStorage.hasAttribute(attr_SubProducerBPartner))
		{
			return -1;
		}

		final int subProducerBPartnerId = attributeStorage.getValueAsInt(attr_SubProducerBPartner);
		return subProducerBPartnerId <= 0 ? -1 : subProducerBPartnerId; // make sure we use same value for N/A
	}

	public Optional<Quantity> getWeight()
	{
		final IWeightable weightable = Weightables.wrap(getAttributeStorage());
		if (weightable == null)
		{
			return Optional.empty();
		}
		final BigDecimal weightNetOrNull = weightable.getWeightNetOrNull();
		if (weightNetOrNull == null)
		{
			return Optional.empty();
		}
		return Optional.of(Quantity.of(weightNetOrNull, weightable.getWeightNetUOM()));
	}

	/**
	 * The M_QualityNote linked with the HUReceiptLine
	 *
	 * @return
	 */
	public I_M_QualityNote getQualityNote()
	{
		final IAttributeStorage attributeStorage = getAttributeStorage();

		if (!attributeStorage.hasAttribute(attr_QualityNotice))
		{
			return null;
		}

		// if the quality notice is set, then take it's name. It must have a qualityDiscount% to be set
		final Object qualityNoticeCode = attributeStorage.getValue(attr_QualityNotice);
		if (qualityNoticeCode == null)
		{
			return null;
		}

		return Services.get(IQualityNoteDAO.class).retrieveQualityNoteForValue(huContext.getCtx(), qualityNoticeCode.toString());
	}

}
