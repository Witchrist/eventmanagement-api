package com.eventmanagement.eventmanagementapi.controller;

import com.eventmanagement.eventmanagementapi.entities.Event;
import com.eventmanagement.eventmanagementapi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RepositoryRestController
public class EventKickOffController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("events/start/{id}")
    public ResponseEntity start(@PathVariable Long id){
        Optional<Event> event = eventRepository.findById(id);

        if(event.isEmpty()){
            throw new ResourceNotFoundException();
        }

        event.get().setStarted(true);
        eventRepository.save(event.get());

        return ResponseEntity.ok(event.get().getName() + " has started");
    }
}
