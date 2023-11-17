package com.haritsaini.interview.services;

import com.haritsaini.interview.models.Building;
import com.haritsaini.interview.models.ConferenceRoom;
import com.haritsaini.interview.models.Floor;
import com.haritsaini.interview.repository.CommonRepository;

public class BuildingService {


    CommonRepository commonRepository = new CommonRepository();


    public String addBuilding(String name){
        Building building = new Building();
        building.setName(name);
        return commonRepository.addBuilding(building);
    }

    public String addFloor(int floorNumber,String buildingName){
        Building building = commonRepository.findBuilding(buildingName);
        building.setName(buildingName);

        Floor floor = new Floor();
        floor.setFloorNumber(floorNumber);
        floor.setBuilding(building);
        return commonRepository.addFloor(floor);
    }

    public String addConfRoom(String name,int floorNumber,String buildingName ){
        Floor floor = commonRepository.findFloor(floorNumber)
                .stream().filter(e->buildingName.equals(e.getBuilding().getName()))
                .findFirst().get();
        ConferenceRoom conferenceRoom = new ConferenceRoom();
        conferenceRoom.setFloor(floor);
        return commonRepository.addConfRoom(conferenceRoom);
    }


}
