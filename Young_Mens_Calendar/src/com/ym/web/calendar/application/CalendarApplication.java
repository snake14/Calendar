package com.ym.web.calendar.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.ym.web.calendar.model.response.JsonProcessingExceptionMapper;

public class CalendarApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public CalendarApplication() {
		singletons.add(new JacksonJsonProvider());
		singletons.add(new JsonProcessingExceptionMapper());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
