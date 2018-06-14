package com.banana.spytutors.web.custom.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.omnifaces.converter.SelectItemsConverter;

/**
 * 
 * @author ANKEM
 *
 */
@FacesConverter(value="com.banana.spytutors.web.custom.converter.MultiSelectObjectConverter")
public class MultiSelectObjectConverter extends SelectItemsConverter {

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String name = "";
		if (value != null) {
			try {
				name = (String) PropertyUtils.getProperty(value, "name");
			} catch (Exception e) {
				// Wont track exception as the effect will be minimal or nothing
			} 
		}

		return (StringUtils.isNotBlank(name))? name : StringUtils.EMPTY;
	}

}
