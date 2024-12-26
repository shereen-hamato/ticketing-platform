package com.ticketing.eventService.repository;


import com.ticketing.eventService.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
