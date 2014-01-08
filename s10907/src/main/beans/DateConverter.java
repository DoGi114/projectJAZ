package main.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("date")
public class DateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		return null ;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateOfBirth = sdf.format(arg2);
		return dateOfBirth;
	}

}
