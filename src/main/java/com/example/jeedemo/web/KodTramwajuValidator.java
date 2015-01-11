package com.example.jeedemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("kodTramwajuValidator")
public class KodTramwajuValidator implements Validator {
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String kod = (String) value;
		
		if (kod.length() != 9) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Kod tramwaju musi składać się z 9 znaków/Tram code must contains 9 characters");
			message.setSummary("Kod tramwaju musi składać się z 9 znaków/Tram code must contains 9 characters");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
	
}
