package com.haritsaini.interview.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Floor {

    int id;
    int floorNumber;
    List<ConferenceRoom> rooms;
    Building building;
}
