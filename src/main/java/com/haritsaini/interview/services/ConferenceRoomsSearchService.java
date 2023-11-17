package com.haritsaini.interview.services;

import com.haritsaini.interview.models.ConferenceRoom;
import com.haritsaini.interview.repository.CommonRepository;

import javax.xml.stream.events.Comment;

public class ConferenceRoomsSearchService {


    CommonRepository repository;


    ConferenceRoomsSearchService(CommonRepository repository){
        this.repository = repository;
    }
}
