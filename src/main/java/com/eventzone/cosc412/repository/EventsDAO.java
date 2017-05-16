package com.eventzone.cosc412.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.Events;

@Repository("eventsDAO")
public interface EventsDAO extends JpaRepository<Events, Long>{
	public Events findByEventId(long eventId);
	public List<Events> findByOrganizedBy(String organizedBy);
	public List<Events> findByEventType(String eventType);
	
}
