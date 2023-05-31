package com.eventmanagement.eventmanagementapi.controller;

import com.eventmanagement.eventmanagementapi.controller.exceptions.AlreadyCheckInException;
import com.eventmanagement.eventmanagementapi.entities.Participant;
import com.eventmanagement.eventmanagementapi.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RepositoryRestController
public class CheckInController {

    @Autowired
    ParticipantRepository participantRepository;

    //O Assembler será responsável em transformar nossa entity em um Hal resource
    @PostMapping("participants/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler){

        Optional<Participant> participant = participantRepository.findById(id);

        if(participant.isPresent()){
            if(participant.get().getCheckedIn()){
                throw new AlreadyCheckInException();
            }

            participant.get().setCheckedIn(true);
            participantRepository.save(participant.get());
        }

        return ResponseEntity.ok(assembler.toFullResource(participant.get()));
    }
}
