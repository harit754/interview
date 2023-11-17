package com.haritsaini.interview.services;

import com.haritsaini.interview.models.ConferenceRoomSlot;
import com.haritsaini.interview.models.Status;
import com.haritsaini.interview.repository.CommonRepository;

public class BookingService {


    // it will create building floors and conference rooms
   static CommonRepository commonRepository = new CommonRepository();


    public static void main(String[] args) {

//        CommonRepository commonRepository = new CommonRepository();

//        Scanner scanner = new Scanner();






    }


    public static void bookConferenceRoom(String userId,int start,int end,String buildingName,int floorNumber,String roomName){
        ConferenceRoomSlot slot =
                commonRepository.getAllConfRoomSLots()
                        .stream()
                        .filter(e->roomName.equals(e.getConferenceRoom().getName()))
                        .filter(e->Integer.valueOf(start).equals(e.getHourStart()))
                        .filter(e-> Status.AVAILABLE.equals(e.getStatus()))
                        .findFirst().orElse(null);

        //book this slot
        if(slot == null){
            System.out.println("Slot not found");
            return;
        }
        slot.setStatus(Status.BOOKED);
        commonRepository.updateSlotStatusToBooked(slot.getId());

        System.out.println("Successfully Booked the Slot");


    }

}
