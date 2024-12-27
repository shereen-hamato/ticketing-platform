package com.ticketing.eventService.service;


import com.ticketing.eventService.Model.UserDto;
import com.ticketing.eventService.entity.Event;
import com.ticketing.eventService.repository.EventRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserServiceClient userServiceClient;

    public EventService(EventRepository eventRepository, UserServiceClient userServiceClient) {
        this.eventRepository = eventRepository;
        this.userServiceClient = userServiceClient;
    }

    public Event createEvent(Event event, Authentication auth) {
        String username = auth.getName();

//        UserDto user = userServiceClient.getUserDetails(username);
//
//        if (!user.getRoles().contains("ADMIN")) {
//            throw new RuntimeException("Access denied: User lacks required role");
//        }

        event.setCreatedByUsername(username);
        event.setCreatedByFullName(username);
        //event.setCreatedByFullName(user.getFullName());

        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
