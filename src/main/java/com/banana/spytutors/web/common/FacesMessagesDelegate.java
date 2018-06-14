package com.banana.spytutors.web.common;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ANKEM
 *
 */
@Named
@Component
public class FacesMessagesDelegate implements Serializable {

	private static final long serialVersionUID = 3147053224722135353L;

	private static final Logger LOG = Logger.getLogger(FacesMessagesDelegate.class);
	
	private static final String STRING_FACES_RESOURCE = "exceptionMessages";
	
	
	/*
	 * This is a convenience method to allow for a collection of ERROR messages to be passed in and placed in the FacesContext.  
	 * This will just call the method with the key string and the passed in var args. This will pass the same var args for each 
	 * message.  If you require varying var args you should probably call the method individually.
	 */
	public void addErrorFacesMessageByKeyCollection(Collection<String> messageKeys, Object... stringArgs){
		if(CollectionUtils.isNotEmpty(messageKeys)){
			for(String key : messageKeys){
				addErrorFacesMessageByKey(key, stringArgs);
			}
		}
	}
	
	/*
	 * This is a convenience method to allow for a collection of INFO messages to be passed in and placed in the FacesContext.  
	 * This will just call the method with the key string and the passed in var args. This will pass the same var args for each 
	 * message.  If you require varying var args you should probably call the method individually.
	 */
	public void addInfoFacesMessageByKeyCollection(Collection<String> messageKeys, Object... stringArgs){
		if(CollectionUtils.isNotEmpty(messageKeys)){
			for(String key : messageKeys){
				addInfoFacesMessageByKey(key, stringArgs);
			}
		}
	}
	
	/*
	 * This method is used to add localized messages by the client id.  This is used with the "p:message" tag. (Note: No "s" at the end of message)
	 */
	public void addLocalErrorFacesMessageByKey(String messageKey, String clientId, Object... stringArguments){
		addFacesMessage(FacesMessage.SEVERITY_ERROR, messageKey, clientId, stringArguments);
	}
	
	/*
	 * This method is used to add localized messages by the client id.  This is used with the "p:message" tag. (Note: No "s" at the end of message)
	 */
	public void addLocalInfoFacesMessageByKey(String messageKey, String clientId, Object... stringArguments){
		addFacesMessage(FacesMessage.SEVERITY_INFO, messageKey, clientId, stringArguments);
	}

	/*
	 * This method is used to add global messages to the messages panel.  This is used with the "p:messages" tag.  (Note: There is an "s" at the end of messages)
	 */
    public void addInfoFacesMessageByKey(String key, Object... arguments){
    	addFacesMessage(FacesMessage.SEVERITY_INFO, key, null, arguments);
    }
    
	/*
	 * This method is used to add global messages to the messages panel.  This is used with the "p:messages" tag.  (Note: There is an "s" at the end of messages)
	 */
    public void addErrorFacesMessageByKey(String key, Object... arguments){
    	addFacesMessage(FacesMessage.SEVERITY_ERROR, key, null, arguments);
    }
    
    public void throwFacesConverterException(String key, String clientId, Object... arguments) throws ConverterException{
    	String messageString = MessageFormat.format(getStringFromBundleByKey(key), arguments);
    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, messageString, StringUtils.EMPTY);
		throw new ConverterException(msg);
				
    }
    
    /*
	 * This method is used to add localized messages by the client id.  This is used with the "p:message" tag. (Note: No "s" at the end of message)
	 */
	public void addInfoFacesMessageByKey(String messageKey, String clientId, Object... stringArguments){
		String messageString = MessageFormat.format(getStringFromBundleByKey(messageKey), stringArguments);
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, messageString, messageString));
	}
    
    protected void addFacesMessage(Severity severity, String messageKey, String clientId, Object... stringArguments){
    	String messageString = MessageFormat.format(getStringFromBundleByKey(messageKey), stringArguments);
    	FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(severity == null ? FacesMessage.SEVERITY_INFO : severity, messageString, StringUtils.EMPTY));
    }
    
    protected String getStringFromBundleByKey(String key){
    	String message = StringUtils.EMPTY;
    	try{
        	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        	ResourceBundle bundle = ResourceBundle.getBundle(STRING_FACES_RESOURCE, locale);
        	message = bundle.getString(key);
    	}catch(MissingResourceException mre){
    		LOG.error("Unable to find message resource with key of: " + key, mre);
    		message = StringUtils.EMPTY;
    	}catch(Exception ex){
    		LOG.error("Exception thrown when called with a key of: " + key, ex);
    		message = StringUtils.EMPTY;
    	}

    	return message;
    }

}
