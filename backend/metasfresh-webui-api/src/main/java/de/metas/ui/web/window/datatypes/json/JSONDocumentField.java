package de.metas.ui.web.window.datatypes.json;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.adempiere.ad.expression.api.LogicExpressionResult;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;

import de.metas.ui.web.devices.JSONDeviceDescriptor;
import de.metas.ui.web.process.IProcessInstanceParameter;
import de.metas.ui.web.window.WindowConstants;
import de.metas.ui.web.window.datatypes.Password;
import de.metas.ui.web.window.descriptor.ViewEditorRenderMode;
import de.metas.ui.web.window.model.DocumentFieldChange;
import de.metas.ui.web.window.model.DocumentValidStatus;
import de.metas.ui.web.window.model.IDocumentChangesCollector.ReasonSupplier;
import de.metas.ui.web.window.model.IDocumentFieldView;
import io.swagger.annotations.ApiModel;

/*
 * #%L
 * metasfresh-webui-api
 * %%
 * Copyright (C) 2016 metas GmbH
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

@ApiModel("document-field")
@JsonPropertyOrder({
		"field",
		"value", "value-reason",
		"readonly", "readonly-reason",
		"mandatory", "mandatory-reason",
		"displayed", "displayed-reason",
		"lookupValuesStale", "lookupValuesStale-reason",
		"valid", "validReason"
})
@SuppressWarnings("serial")
public final class JSONDocumentField implements Serializable
{
	public static JSONDocumentField ofDocumentField(final IDocumentFieldView field, final JSONOptions jsonOpts)
	{
		final String name = field.getFieldName();
		final JSONLayoutWidgetType jsonWidgetType = JSONLayoutWidgetType.fromNullable(field.getWidgetType());
		final Object valueJSON = field.getValueAsJsonObject(jsonOpts);
		final String reason = null; // N/A

		final JSONDocumentField jsonField = new JSONDocumentField(name, jsonWidgetType)
				.setValue(valueJSON, reason)
				.setReadonly(field.getReadonly())
				.setMandatory(field.getMandatory())
				.setDisplayed(field.getDisplayed())
				.setValidStatus(field.getValidStatus());
		if (field.isLookupValuesStale())
		{
			jsonField.setLookupValuesStale(true, reason);
		}

		if (WindowConstants.isProtocolDebugging())
		{
			jsonField.putDebugProperty(DocumentFieldChange.DEBUGPROPERTY_FieldInfo, field.toString());
		}

		return jsonField;
	}

	public static JSONDocumentField ofProcessParameter(final IProcessInstanceParameter parameter, final JSONOptions jsonOpts)
	{
		final String name = parameter.getParameterName();
		final JSONLayoutWidgetType jsonWidgetType = JSONLayoutWidgetType.fromNullable(parameter.getWidgetType());
		final Object valueJSON = parameter.getValueAsJsonObject(jsonOpts);
		final String reason = null; // N/A

		final JSONDocumentField jsonField = new JSONDocumentField(name, jsonWidgetType)
				.setValue(valueJSON, reason)
				.setReadonly(parameter.getReadonly())
				.setMandatory(parameter.getMandatory())
				.setDisplayed(parameter.getDisplayed())
				.setValidStatus(parameter.getValidStatus())
				.setDevices(JSONDeviceDescriptor.ofList(parameter.getDevices(), jsonOpts.getAdLanguage()));
		if (WindowConstants.isProtocolDebugging())
		{
			jsonField.putDebugProperty(DocumentFieldChange.DEBUGPROPERTY_FieldInfo, parameter.toString());
		}

		return jsonField;
	}

	public static JSONDocumentField idField(final Object jsonValue)
	{
		final String reason = null; // N/A
		return new JSONDocumentField(FIELD_VALUE_ID, JSONLayoutWidgetType.Integer)
				.setValue(jsonValue, reason);
	}

	public static JSONDocumentField ofNameAndValue(final String fieldName, final Object jsonValue)
	{
		final String reason = null; // N/A
		final JSONLayoutWidgetType widgetType = null; // N/A
		return new JSONDocumentField(fieldName, widgetType)
				.setValue(jsonValue, reason);
	}

	public static JSONDocumentField ofDocumentFieldChangedEvent(final DocumentFieldChange event, final JSONOptions jsonOpts)
	{
		final JSONLayoutWidgetType widgetType = JSONLayoutWidgetType.fromNullable(event.getWidgetType());
		final JSONDocumentField jsonField = new JSONDocumentField(event.getFieldName(), widgetType);

		if (event.isValueSet())
		{
			jsonField.setValue(event.getValueAsJsonObject(jsonOpts), ReasonSupplier.toDebugString(event.getValueReason()));
		}

		final LogicExpressionResult readonly = event.getReadonly();
		if (readonly != null)
		{
			jsonField.setReadonly(readonly.booleanValue(), ReasonSupplier.toDebugString(event.getReadonlyReason()));
		}

		final LogicExpressionResult mandatory = event.getMandatory();
		if (mandatory != null)
		{
			jsonField.setMandatory(mandatory.booleanValue(), ReasonSupplier.toDebugString(event.getMandatoryReason()));
		}

		final LogicExpressionResult displayed = event.getDisplayed();
		if (displayed != null)
		{
			jsonField.setDisplayed(displayed.booleanValue(), ReasonSupplier.toDebugString(event.getDisplayedReason()));
		}

		final Boolean lookupValuesStale = event.getLookupValuesStale();
		if (lookupValuesStale != null)
		{
			jsonField.setLookupValuesStale(lookupValuesStale, ReasonSupplier.toDebugString(event.getLookupValuesStaleReason()));
		}

		final DocumentValidStatus validStatus = event.getValidStatus();
		if (validStatus != null)
		{
			jsonField.setValidStatus(validStatus);
		}

		jsonField.setFieldWarning(JSONDocumentFieldWarning.ofNullable(event.getFieldWarning(), jsonOpts.getAdLanguage()));

		jsonField.putDebugProperties(event.getDebugProperties());

		return jsonField;
	}

	@JsonProperty("field")
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private final String field;
	public static final String FIELD_VALUE_ID = "ID";

	@JsonProperty("widgetType")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private JSONLayoutWidgetType widgetType;

	@JsonProperty("value")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object value;

	@JsonProperty("value-reason")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String valueReason;

	@JsonProperty("readonly")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean readonly;

	@JsonProperty("readonly-reason")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String readonlyReason;

	@JsonProperty("mandatory")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean mandatory;

	@JsonProperty("mandatory-reason")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mandatoryReason;

	@JsonProperty("displayed")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean displayed;

	@JsonProperty("displayed-reason")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String displayedReason;

	@JsonProperty("lookupValuesStale")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean lookupValuesStale;

	@JsonProperty("lookupValuesStale-reason")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lookupValuesStaleReason;

	@JsonProperty("validStatus")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private DocumentValidStatus validStatus;

	@JsonProperty("viewEditorRenderMode")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String viewEditorRenderMode;

	@JsonProperty("warning")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private JSONDocumentFieldWarning fieldWarning;

	@JsonProperty("devices")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<JSONDeviceDescriptor> devices;

	/** Other properties */
	private final Map<String, Object> otherProperties = new LinkedHashMap<>();

	@JsonCreator
	/* package */ JSONDocumentField(
			@JsonProperty("field") final String field,
			@JsonProperty("widgetType") final JSONLayoutWidgetType widgetType)
	{
		this.field = field;
		this.widgetType = widgetType;
	}

	@Override
	public String toString()
	{
		return MoreObjects.toStringHelper(this)
				.omitNullValues()
				.add("field", field)
				.add("value", value)
				.add("value-reason", valueReason)
				.add("mandatory", mandatory)
				.add("mandatory-reason", mandatoryReason)
				.add("readonly", readonly)
				.add("readonly-reason", readonlyReason)
				.add("displayed", displayed)
				.add("displayed-reason", displayedReason)
				.add("lookupValuesStale", lookupValuesStale)
				.add("lookupValuesStale-reason", lookupValuesStaleReason)
				.add("validStatus", validStatus)
				.add("otherProperties", otherProperties)
				.toString();
	}

	/* package */ JSONDocumentField setValue(final Object jsonValue, final String reason)
	{
		value = JSONNullValue.wrapIfNull(jsonValue);
		valueReason = reason;
		return this;
	}

	/* package */ void unboxPasswordField()
	{
		final Object value = this.value;
		if (value instanceof Password)
		{
			this.value = ((Password)value).getAsString();
		}
	}

	public JSONDocumentField setWidgetType(final JSONLayoutWidgetType widgetType)
	{
		this.widgetType = widgetType;
		return this;
	}

	public boolean isReadonly()
	{
		return readonly != null && readonly;
	}

	public JSONDocumentField setReadonly(final boolean readonly, final String reason)
	{
		this.readonly = readonly;
		readonlyReason = reason;
		setViewEditorRenderMode(readonly ? ViewEditorRenderMode.NEVER : ViewEditorRenderMode.ALWAYS);
		return this;
	}

	public JSONDocumentField setReadonly(final LogicExpressionResult readonly)
	{
		setReadonly(readonly.booleanValue(), readonly.getName());
		return this;
	}

	public JSONDocumentField setReadonly(final boolean readonly)
	{
		final String reason = null; // N/A
		setReadonly(readonly, reason);
		return this;
	}

	private JSONDocumentField setMandatory(final boolean mandatory, final String reason)
	{
		this.mandatory = mandatory;
		mandatoryReason = reason;
		return this;
	}

	public JSONDocumentField setMandatory(final LogicExpressionResult mandatory)
	{
		setMandatory(mandatory.booleanValue(), mandatory.getName());
		return this;
	}

	public JSONDocumentField setMandatory(final boolean mandatory)
	{
		final String reason = null; // N/A
		setMandatory(mandatory, reason);
		return this;
	}

	public JSONDocumentField setDisplayed(final boolean displayed, final String reason)
	{
		this.displayed = displayed;
		displayedReason = reason;
		return this;
	}

	public JSONDocumentField setDisplayed(final LogicExpressionResult displayed)
	{
		setDisplayed(displayed.booleanValue(), displayed.getName());
		return this;
	}

	public JSONDocumentField setDisplayed(final boolean displayed)
	{
		final String reason = null; // N/A
		setDisplayed(displayed, reason);
		return this;
	}

	/* package */ JSONDocumentField setLookupValuesStale(final boolean lookupValuesStale, final String reason)
	{
		this.lookupValuesStale = lookupValuesStale;
		lookupValuesStaleReason = reason;
		return this;
	}

	/* package */ JSONDocumentField setValidStatus(final DocumentValidStatus validStatus)
	{
		this.validStatus = validStatus;
		return this;
	}

	public String getField()
	{
		return field;
	}

	public Object getValue()
	{
		return value;
	}

	public String getValueReason()
	{
		return valueReason;
	}

	public Boolean getReadonly()
	{
		return readonly;
	}

	public String getReadonlyReason()
	{
		return readonlyReason;
	}

	public Boolean getMandatory()
	{
		return mandatory;
	}

	public String getMandatoryReason()
	{
		return mandatoryReason;
	}

	public Boolean getDisplayed()
	{
		return displayed;
	}

	public String getDisplayedReason()
	{
		return displayedReason;
	}

	public Boolean getLookupValuesStale()
	{
		return lookupValuesStale;
	}

	public String getLookupValuesStaleReason()
	{
		return lookupValuesStaleReason;
	}

	@JsonAnyGetter
	public Map<String, Object> getOtherProperties()
	{
		return otherProperties;
	}

	@JsonAnySetter
	public void putOtherProperty(final String name, final Object jsonValue)
	{
		otherProperties.put(name, jsonValue);
	}

	public JSONDocumentField putDebugProperty(final String name, final Object jsonValue)
	{
		otherProperties.put("debug-" + name, jsonValue);
		return this;
	}

	public void putDebugProperties(final Map<String, Object> debugProperties)
	{
		if (debugProperties == null || debugProperties.isEmpty())
		{
			return;
		}

		for (final Map.Entry<String, Object> e : debugProperties.entrySet())
		{
			putDebugProperty(e.getKey(), e.getValue());
		}
	}

	public JSONDocumentField setViewEditorRenderMode(final ViewEditorRenderMode viewEditorRenderMode)
	{
		this.viewEditorRenderMode = viewEditorRenderMode != null ? viewEditorRenderMode.toJson() : null;
		return this;
	}

	public JSONDocumentField setFieldWarning(final JSONDocumentFieldWarning fieldWarning)
	{
		this.fieldWarning = fieldWarning;
		return this;
	}

	public JSONDocumentField setDevices(@Nullable final List<JSONDeviceDescriptor> devices)
	{
		this.devices = devices;
		return this;
	}
}
