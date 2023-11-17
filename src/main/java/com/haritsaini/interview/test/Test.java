package com.haritsaini.interview.test;

import com.haritsaini.interview.models.ConferenceRoomSlot;
import com.haritsaini.interview.repository.CommonRepository;
import com.haritsaini.interview.services.BookingService;
import com.haritsaini.interview.services.BuildingService;

import java.awt.print.Book;

public class Test {


    static BuildingService buildingService = new BuildingService();
    static CommonRepository repository = new CommonRepository();

    static BookingService bookingService = new BookingService();



    public static void main(String[] args) {

        System.out.println(buildingService.addBuilding("b1"));

        System.out.println(buildingService.addFloor(1,"b1"));
        System.out.println(buildingService.addConfRoom("c1",1,"b1"));

        BookingService.bookConferenceRoom("userId",5,6,"b1",1,"c1");

        for(ConferenceRoomSlot slot : repository.getAllConfRoomSLots()){
            System.out.println(slot.getConferenceRoom().getName()+" "+slot.getStatus());
        }
        System.out.println(repository.findBuilding("b1").getName());



    }
}
