package de.metas.handlingunits.attribute;

import org.adempiere.mm.attributes.AttributeCode;
import org.adempiere.mm.attributes.api.AttributeConstants;
import org.adempiere.mm.attributes.api.impl.LotNumberDateAttributeDAO;

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

import org.compiere.model.I_M_Attribute;

import de.metas.util.Check;
import lombok.experimental.UtilityClass;

/**
 * HU Attributes constants.
 * IMPORTANT: before adding a constant here, please check if it was already added to {@link AttributeConstants}.
 */
@UtilityClass
public final class HUAttributeConstants
{
	/**
	 * Context name used to identify the map of initial default values to be used when creating HU attributes.
	 *
	 * Type: Map of {@link I_M_Attribute} to value({@link Object}).
	 */
	public static String CTXATTR_DefaultAttributesValue = HUAttributeConstants.class.getName() + "#DefaultAttributesValue";

	public static final String ATTR_QualityDiscountPercent_Value = "QualityDiscountPercent";
	public static final String ATTR_QualityNotice_Value = "QualityNotice";
	public static final AttributeCode ATTR_SSCC18_Value = AttributeCode.ofString("SSCC18");
	public static final AttributeCode ATTR_SubProducerBPartner_Value = AttributeConstants.ATTR_SubProducerBPartner_Value;

	/**
	 * @see http://dewiki908/mediawiki/index.php/07759_Stockvalue_by_FiFo_%28100951729256%29
	 */
	public static final AttributeCode ATTR_CostPrice = AttributeCode.ofString("HU_CostPrice");

	/**
	 * @see http://dewiki908/mediawiki/index.php/09670_Tageslot_Einlagerung_%28100236982974%29
	 */
	public static final AttributeCode ATTR_LotNumberDate = LotNumberDateAttributeDAO.ATTR_LotNumberDate;

	/**
	 * The <code>M_Attribute.Value</code> for the HU-attribute referencing the purchase C_OrderLine_ID on which the given HU was ordered.
	 *
	 * @task 09741
	 */
	public static final AttributeCode ATTR_PurchaseOrderLine_ID = AttributeCode.ofString("HU_PurchaseOrderLine_ID");

	/**
	 * The <code>M_Attribute.Value</code> for the HU-attribute referencing the receipt M_InOutLine_ID on which the given HU was received.
	 *
	 * @task 09741
	 */
	public static final AttributeCode ATTR_ReceiptInOutLine_ID = AttributeCode.ofString("HU_ReceiptInOutLine_ID");

	public static final AttributeCode ATTR_Expired = AttributeCode.ofString("HU_Expired");
	public static final String ATTR_Expired_Value_Expired = "expired";

	public static final AttributeCode ATTR_Age = AttributeCode.ofString("Age");
	public static final AttributeCode ATTR_ProductionDate = AttributeCode.ofString("ProductionDate");

	public static final AttributeCode ATTR_Quarantine = AttributeCode.ofString("HU_Quarantine");
	public static final String ATTR_Quarantine_Value_Quarantine = "quarantine";

	public static String sqlBestBeforeDate(final String huIdColumnName)
	{
		Check.assumeNotEmpty(huIdColumnName, "huIdColumnName is not empty");
		return "\"de.metas.handlingunits\".huBestBeforeDate(" + huIdColumnName + ")";
	}
}
