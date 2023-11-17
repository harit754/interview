package com.haritsaini.interview.repository;

import com.haritsaini.interview.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonRepository {


    private static List<ConferenceRoomSlot> conferenceRoomSlotList = new ArrayList<>();

    private static List<Building> buildings = new ArrayList<>();

    private static List<Floor> floors = new ArrayList<>();

    private static List<ConferenceRoom> conferenceRooms = new ArrayList<>();



    public List<ConferenceRoomSlot> getAllConfRoomSLots(){
        return conferenceRoomSlotList;
    }

    public String updateSlotStatusToBooked(Integer confRoomSlotId){
        conferenceRoomSlotList.stream()
                .filter(e->confRoomSlotId.equals(e.getId()))
                .findFirst().get().setStatus(Status.BOOKED);

        return "Status has been changed to BOOKED";
    }

    public List<ConferenceRoomSlot> search(Integer floorNumber, String buildingName, Integer start){

        return
        conferenceRoomSlotList.stream()
                .filter(e->buildingName.equals(e.getConferenceRoom().getBuilding().getName()))
                .filter(e->floorNumber.equals(e.getConferenceRoom().getFloor().getFloorNumber()))
                .filter(e->start.equals(e.getHourStart()))
                .filter(e-> Status.AVAILABLE.equals(e.getStatus()))
                .collect(Collectors.toList());


    }


    public String addBuilding(Building building){
        buildings.add(building);
        return "Added building " + building.getName() + " into the system.";
    }

    public String addFloor(Floor floor){
        floors.add(floor);
        return "Added floor " + floor.getFloorNumber() + " into the system.";
    }

    public Building findBuilding(String name){
        return
        buildings.stream()
                .filter(e->name.equals(e.getName()))
                .findFirst()
                .get();
    }

    public List<Floor> findFloor(Integer number){
        return
                floors.stream()
                        .filter(e->number.equals(e.getFloorNumber()))
                        .collect(Collectors.toList());
    }

    public String addConfRoom(ConferenceRoom conferenceRoom){
        conferenceRooms.add(conferenceRoom);

        for(int i = 0;i<24;i++){
            ConferenceRoomSlot conferenceRoomSlot = new ConferenceRoomSlot();
            conferenceRoomSlot.setConferenceRoom(conferenceRoom);
            conferenceRoomSlot.setStatus(Status.AVAILABLE);
            conferenceRoomSlot.setHourStart(i);
            conferenceRoomSlot.setId(i);
            conferenceRoomSlotList.add(conferenceRoomSlot);
        }
        return "Added successfully";
    }

}
