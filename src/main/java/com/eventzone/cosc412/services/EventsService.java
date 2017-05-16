package com.eventzone.cosc412.services;

import java.util.List;

import com.eventzone.cosc412.dto.EventDTO;
import com.eventzone.cosc412.model.Events;

public interface EventsService {
	public Events findById(long eventId);
	public List<Events> findByOrganizedBy(String organizedBy);
	public List<Events> findByEventType(String eventType);
	
	public boolean saveEvents(EventDTO eventDTO);
	public void delete(Events events);
	public List<EventDTO> findAllEvents();

}
