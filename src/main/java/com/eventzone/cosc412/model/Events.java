package com.eventzone.cosc412.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Events")
public class Events {

	@Id
    @GeneratedValue
	@Column(name = "EVENT_ID")
	Long eventId;
	
    @Column(name = "EVENT_NAME")
    String eventName;
    
    @Column(name = "ORGANIZED_BY")
    String organizedBy;
    
    @Column(name = "EVENT_TYPE")
    String eventType;
    
    @Column(name = "EVENT_LOCATION")
    String eventLocation;
    
    @Column(name = "ZIP_CODE")
    String zipCode;
    
    @Column(name = "EVENT_DESCRIPTION")
    String eventDesciption;
    
    @Column(name = "TOTAL_SEATING_CAPACITY")
    String totalSeatingCapacity;
    
    @Column(name = "EVENT_DATE_FROM")
    Date eventDateFrom;
    
    @Column(name = "EVENT_DATE_TO")
    Date eventDateTo;
    
    @Column(name = "EVENT_TIME_FROM")
    String eventTimeFrom;
    
    @Column(name = "EVENT_TIME_TO")
    String eventTimeTo;
    
	public String getEventTimeFrom() {
		return eventTimeFrom;
	}

	public void setEventTimeFrom(String eventTimeFrom) {
		this.eventTimeFrom = eventTimeFrom;
	}

	public String getEventTimeTo() {
		return eventTimeTo;
	}

	public void setEventTimeTo(String eventTimeTo) {
		this.eventTimeTo = eventTimeTo;
	}

	@Column(name = "TotalTicketRemaining")
    Integer totalTicketRemaining;
    
    @Column(name = "price")
    Double price;

    @Column(name = "CREATED_BY_USER_ID")
    Long createdByUserId;
    
    @Column(name = "CREATED_ON")
    Timestamp createdOn;
    
    @Column(name = "FILE_PATH")
    String filePath;

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

	public String getOrganizedBy() {
		return organizedBy;
	}

	public void setOrganizedBy(String organizedBy) {
		this.organizedBy = organizedBy;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDesciption() {
		return eventDesciption;
	}

	public void setEventDesciption(String eventDesciption) {
		this.eventDesciption = eventDesciption;
	}

	public String getTotalSeatingCapacity() {
		return totalSeatingCapacity;
	}

	public void setTotalSeatingCapacity(String totalSeatingCapacity) {
		this.totalSeatingCapacity = totalSeatingCapacity;
	}


	public Integer getTotalTicketRemaining() {
		return totalTicketRemaining;
	}

	public void setTotalTicketRemaining(Integer totalTicketRemaining) {
		this.totalTicketRemaining = totalTicketRemaining;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventDesciption == null) ? 0 : eventDesciption.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventLocation == null) ? 0 : eventLocation.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((organizedBy == null) ? 0 : organizedBy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Events other = (Events) obj;
		if (eventDesciption == null) {
			if (other.eventDesciption != null)
				return false;
		} else if (!eventDesciption.equals(other.eventDesciption))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventLocation == null) {
			if (other.eventLocation != null)
				return false;
		} else if (!eventLocation.equals(other.eventLocation))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (organizedBy == null) {
			if (other.organizedBy != null)
				return false;
		} else if (!organizedBy.equals(other.organizedBy))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventName=" + eventName + ", organizedBy=" + organizedBy
				+ ", eventType=" + eventType + ", eventLocation=" + eventLocation + ", zipCode=" + zipCode
				+ ", eventDesciption=" + eventDesciption + ", totalSeatingCapacity=" + totalSeatingCapacity
				+ ", eventDateFrom=" + eventDateFrom + ", eventDateTo=" + eventDateTo + ", eventTimeFrom="
				+ eventTimeFrom + ", eventTimeTo=" + eventTimeTo + ", totalTicketRemaining=" + totalTicketRemaining
				+ ", price=" + price + ", createdByUserId=" + createdByUserId + ", createdOn=" + createdOn
				+ ", filePath=" + filePath + "]";
	}

	
}
