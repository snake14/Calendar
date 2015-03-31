package com.ym.web.calendar.model.ser;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * Deserializer that contains the expected date format and parses the date
 * 
 * @author JacobR
 * 
 */
public class DateDeserializer extends JsonDeserializer<Date> {

	public static final String DATE_FORMAT = "dd-MMM-yy HH:mm:ss";

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext arg1) throws IOException, JsonProcessingException {
		String stringDate = jp.getText();

		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		formatter.setLenient(false);
		Date parseDate = null;
		try {
			parseDate = formatter.parse(stringDate);
		} catch (ParseException e) {
			String message = MessageFormat.format("Can not construct instance of {0} from string value ''{1}''",
					new Object[] { Date.class.getName(), stringDate });
			throw new InvalidFormatException(message, jp.getCurrentLocation(), stringDate, Date.class);
		}

		return parseDate;

	}
}
