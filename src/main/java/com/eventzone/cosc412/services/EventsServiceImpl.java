package com.eventzone.cosc412.services;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventzone.cosc412.dto.EventDTO;
import com.eventzone.cosc412.model.Events;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.repository.EventsDAO;



@Service("eventsService")
public class EventsServiceImpl implements EventsService{

	@Autowired
	private EventsDAO eventsDAO;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserService userInfoService;

	@Override
	public Events findById(long eventId) {
		
		return eventsDAO.findByEventId(eventId);
	}

	@Override
	public List<Events> findByOrganizedBy(String organizedBy) {
		
		return eventsDAO.findByOrganizedBy(organizedBy);
	}

	@Override
	public List<Events> findByEventType(String eventType) {
		return eventsDAO.findByEventType(eventType);
	}

	@Override
	public boolean saveEvents(EventDTO eventDTO) {
		Instant instant = Instant.now();
		eventDTO.setCreatedOn(Timestamp.from(instant));
		Optional<UserInfo> userInfo = Optional.ofNullable(userInfoService.getLoggedInUser());
		if(userInfo.isPresent()){
			eventDTO.setCreatedByUserId(userInfo.get().getUserInfoId());
		}
		else{
			return false;
		}
		
		Events event = new Events();
		event.setCreatedByUserId(eventDTO.getCreatedByUserId());
		event.setCreatedOn(eventDTO.getCreatedOn());
		event.setEventDateFrom(eventDTO.getEventDateFrom());
		event.setEventDateTo(eventDTO.getEventDateTo());
		event.setEventTimeFrom(eventDTO.getTimeFrom());
		event.setEventTimeTo(eventDTO.getTimeTo());
		//event.setEventDateTime(eventDTO.getEventDateTime());
		event.setEventDesciption(eventDTO.getEventDescription());
		event.setEventLocation(eventDTO.getEventLocation());
		event.setEventName(eventDTO.getEventName());
		event.setEventType(eventDTO.getEventType());
		event.setOrganizedBy(eventDTO.getOrganizedBy());
		event.setPrice(eventDTO.getPrice());
		event.setZipCode(eventDTO.getZipCode());
		event.setTotalTicketRemaining(eventDTO.getTotalTicketRemaining());
		
		Optional<Events> events = Optional.ofNullable(eventsDAO.save(event));
		if(events.isPresent())
			return true;
		else
			return false;
	}

	@Override
	public void delete(Events events) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventDTO> findAllEvents() {
		List<Events> events  = eventsDAO.findAll();
		
		List<EventDTO> eventDTO = events.stream().map(event->new EventDTO(event)).collect(Collectors.<EventDTO> toList());
		
		         
		return eventDTO;
	}
	

	
	

}
