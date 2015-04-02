package com.ym.web.calendar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	@JsonProperty("id")
	private Integer calendarId;

	@Column(name = "title")
	private String title;

	@Column(name = "all_day")
	@JsonInclude(Include.NON_NULL)
	private Boolean allDay;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "start_date_time")
	@JsonProperty("start")
	private Date startDateTime;

	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "end_date_time")
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("end")
	private Date endDateTime;

	@Column(name = "url")
	@JsonInclude(Include.NON_NULL)
	private String url;

	@Column(name = "class_name")
	@JsonInclude(Include.NON_NULL)
	private String className;

	@Column(name = "editable")
	@JsonInclude(Include.NON_NULL)
	private Boolean editable;

	@Column(name = "start_editable")
	@JsonInclude(Include.NON_NULL)
	private Boolean startEditable;

	@Column(name = "duration_editable")
	@JsonInclude(Include.NON_NULL)
	private Boolean durationEditable;

	@Column(name = "rendering")
	@JsonInclude(Include.NON_NULL)
	private String rendering;

	@Column(name = "overlap")
	@JsonInclude(Include.NON_NULL)
	private Boolean overlap;

	@Column(name = "constraint_string")
	@JsonInclude(Include.NON_NULL)
	private String constraint;

	@Column(name = "color")
	@JsonInclude(Include.NON_NULL)
	private String color;

	@Column(name = "background_color")
	@JsonInclude(Include.NON_NULL)
	private String backgroundColor;

	@Column(name = "border_color")
	@JsonInclude(Include.NON_NULL)
	private String borderColor;

	@Column(name = "text_color")
	@JsonInclude(Include.NON_NULL)
	private String textColor;

	@Column(name = "location")
	@JsonInclude(Include.NON_NULL)
	private String location;

	@Column(name = "description")
	@JsonInclude(Include.NON_NULL)
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
	 * @return Returns the allDay.
	 */
	public Boolean getAllDay() {

		return allDay;
	}

	/**
	 * @param allDay
	 *            The allDay to set.
	 */
	public void setAllDay(Boolean allDay) {

		this.allDay = allDay;
	}

	/**
	 * @return the startDateTime
	 */
	public Date getStart() {
		return startDateTime;
	}

	/**
	 * @param start
	 *            the startDateTime to set
	 */
	public void setStart(Date start) {
		this.startDateTime = start;
	}

	/**
	 * @return the endDateTime
	 */
	public Date getEnd() {
		return endDateTime;
	}

	/**
	 * @param end
	 *            the endDateTime to set
	 */
	public void setEnd(Date end) {
		this.endDateTime = end;
	}

	/**
	 * @return Returns the url.
	 */
	public String getUrl() {

		return url;
	}

	/**
	 * @param url
	 *            The url to set.
	 */
	public void setUrl(String url) {

		this.url = url;
	}

	/**
	 * @return Returns the className.
	 */
	public String getClassName() {

		return className;
	}

	/**
	 * @param className
	 *            The className to set.
	 */
	public void setClassName(String className) {

		this.className = className;
	}

	/**
	 * @return Returns the editable.
	 */
	public Boolean getEditable() {

		return editable;
	}

	/**
	 * @param editable
	 *            The editable to set.
	 */
	public void setEditable(Boolean editable) {

		this.editable = editable;
	}

	/**
	 * @return Returns the startEditable.
	 */
	public Boolean getStartEditable() {

		return startEditable;
	}

	/**
	 * @param startEditable
	 *            The startEditable to set.
	 */
	public void setStartEditable(Boolean startEditable) {

		this.startEditable = startEditable;
	}

	/**
	 * @return Returns the durationEditable.
	 */
	public Boolean getDurationEditable() {

		return durationEditable;
	}

	/**
	 * @param durationEditable
	 *            The durationEditable to set.
	 */
	public void setDurationEditable(Boolean durationEditable) {

		this.durationEditable = durationEditable;
	}

	/**
	 * @return Returns the rendering.
	 */
	public String getRendering() {

		return rendering;
	}

	/**
	 * @param rendering
	 *            The rendering to set.
	 */
	public void setRendering(String rendering) {

		this.rendering = rendering;
	}

	/**
	 * @return Returns the overlap.
	 */
	public Boolean getOverlap() {

		return overlap;
	}

	/**
	 * @param overlap
	 *            The overlap to set.
	 */
	public void setOverlap(Boolean overlap) {

		this.overlap = overlap;
	}

	/**
	 * @return Returns the constraint.
	 */
	public String getConstraint() {

		return constraint;
	}

	/**
	 * @param constraint
	 *            The constraint to set.
	 */
	public void setConstraint(String constraint) {

		this.constraint = constraint;
	}

	/**
	 * @return Returns the color.
	 */
	public String getColor() {

		return color;
	}

	/**
	 * @param color
	 *            The color to set.
	 */
	public void setColor(String color) {

		this.color = color;
	}

	/**
	 * @return Returns the backgroundColor.
	 */
	public String getBackgroundColor() {

		return backgroundColor;
	}

	/**
	 * @param backgroundColor
	 *            The backgroundColor to set.
	 */
	public void setBackgroundColor(String backgroundColor) {

		this.backgroundColor = backgroundColor;
	}

	/**
	 * @return Returns the borderColor.
	 */
	public String getBorderColor() {

		return borderColor;
	}

	/**
	 * @param borderColor
	 *            The borderColor to set.
	 */
	public void setBorderColor(String borderColor) {

		this.borderColor = borderColor;
	}

	/**
	 * @return Returns the textColor.
	 */
	public String getTextColor() {

		return textColor;
	}

	/**
	 * @param textColor
	 *            The textColor to set.
	 */
	public void setTextColor(String textColor) {

		this.textColor = textColor;
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
