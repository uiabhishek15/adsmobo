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
@FacesConverter(value="com.banana.spytutors.web.custom.converter.PriceRangePerHourConverter")
public class PriceRangePerHourConverter extends SelectItemsConverter {
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String priceRange = "";
		if (value != null) {
			try {
				priceRange = (String) PropertyUtils.getProperty(value, "priceRange");
			} catch (Exception e) {
				// Wont track exception as the effect will be minimal or nothing
			} 
		}

		return (StringUtils.isNotBlank(priceRange))? priceRange : StringUtils.EMPTY;
	}

}
