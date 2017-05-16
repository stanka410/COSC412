package com.eventzone.cosc412.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.eventzone.cosc412.model.Events;

public class EventDTO {
	Long eventId;

	String eventName;

	String eventDescription;

	String schoolAddress;

	Date eventDateFrom;

	Date eventDateTo;

	String eventLocation;

	String eventType;

	Double price;
	Integer totalTicketRemaining;

	String organizedBy;

	String TimeFrom;

	String TimeTo;

	public EventDTO() {
		super();
	}

	public EventDTO(Events event) {
		eventName = event.getEventName();
		createdByUserId = event.getCreatedByUserId();
		createdOn = event.getCreatedOn();
		eventDateFrom = event.getEventDateFrom();
		eventDateTo = event.getEventDateTo();
		eventDescription = event.getEventDesciption();
		eventId = event.getEventId();
		eventLocation = event.getEventLocation();
		eventName = event.getEventName();
		TimeFrom = event.getEventTimeFrom();
		TimeTo = event.getEventTimeTo();
		eventDateFrom =event.getEventDateFrom();
		eventDateTo = event.getEventDateTo();
		price = event.getPrice();
		eventType = event.getEventType();
	}

	public String getTimeFrom() {
		return TimeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		TimeFrom = timeFrom;
	}

	public String getTimeTo() {
		return TimeTo;
	}

	public void setTimeTo(String timeTo) {
		TimeTo = timeTo;
	}

	String zipCode;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	Long createdByUserId;

	Timestamp createdOn;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getTotalTicketRemaining() {
		return totalTicketRemaining;
	}

	public void setTotalTicketRemaining(Integer totalTicketRemaining) {
		this.totalTicketRemaining = totalTicketRemaining;
	}

	public String getOrganizedBy() {
		return organizedBy;
	}

	public void setOrganizedBy(String organizedBy) {
		this.organizedBy = organizedBy;
	}

	public Long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Date getEventDateFrom() {
		return eventDateFrom;
	}

	public void setEventDateFrom(Date eventDateFrom) {
		this.eventDateFrom = eventDateFrom;
	}

	public Date getEventDateTo() {
		return eventDateTo;
	}

	public void setEventDateTo(Date eventDateTo) {
		this.eventDateTo = eventDateTo;
	}

}
