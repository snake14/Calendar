package com.ym.web.calendar.model.response;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonProcessingException;

@Provider
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException> {

	@Override
	public Response toResponse(JsonProcessingException exception) {
		ResponseBuilder builder = Response.status(Status.BAD_REQUEST).entity(exception.getOriginalMessage())
				.type(MediaType.APPLICATION_JSON_TYPE);

		return builder.build();
	}
}
