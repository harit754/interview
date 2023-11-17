package com.haritsaini.interview.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ConferenceRoomSlot {

    int id;
    ConferenceRoom conferenceRoom;
    Date date;

    int hourStart;
    //default duration is 1hr
//    int hourEnd;
    Status status;
}
