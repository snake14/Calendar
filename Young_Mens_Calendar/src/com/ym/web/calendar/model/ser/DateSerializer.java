package com.ym.web.calendar.model.ser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializer that contains the expected date format and parses the date
 * 
 * @author JacobR
 * 
 */
public class DateSerializer extends JsonSerializer<Date> {

	public static final String DATE_FORMAT = "dd-MMM-yy HH:mm:ss";

	@Override
	public void serialize(Date dateValue, JsonGenerator jgen, SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		String dateString = formatter.format(dateValue);
		if (dateString != null && !dateString.trim().isEmpty()) {
			dateString = dateString.toUpperCase();
		}
		jgen.writeString(dateString);
	}
}
