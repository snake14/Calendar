package com.ym.web.calendar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ym.web.calendar.model.ser.DateDeserializer;
import com.ym.web.calendar.model.ser.DateSerializer;

@Entity
@Table(name = "calendar")
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calendar_id")
	private Integer calendarId;

	@Column(name = "title")
	private String title;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "start_date_time")
	private Date startDateTime;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "end_date_time")
	private Date endDateTime;

	@Column(name = "location")
	private String location;

	@Column(name = "description")
	private String description;

	/**
	 * @return the calendarId
	 */
	public Integer getCalendarId() {
		return calendarId;
	}

	/**
	 * @param calendarId
	 *            the calendarId to set
	 */
	public void setCalendarId(Integer calendarId) {
		this.calendarId = calendarId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the startDateTime
	 */
	public Date getStartDateTime() {
		return startDateTime;
	}

	/**
	 * @param startDateTime
	 *            the startDateTime to set
	 */
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * @return the endDateTime
	 */
	public Date getEndDateTime() {
		return endDateTime;
	}

	/**
	 * @param endDateTime
	 *            the endDateTime to set
	 */
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
