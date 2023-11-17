package com.haritsaini.interview.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConferenceRoom {

    String name;
    Floor floor;
    Building building;
    int capacity;


}
