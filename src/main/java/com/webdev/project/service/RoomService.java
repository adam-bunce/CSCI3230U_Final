package com.webdev.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdev.project.model.Customer;
import com.webdev.project.model.Room;
import com.webdev.project.repo.RoomRepo;

//Room Service
@Service
public class RoomService {
	RoomRepo roomRepo;

	//RoomService Constructor
    @Autowired
    public RoomService(RoomRepo repo) {
        super();
        this.roomRepo = repo;
    }
    
    //Updates/Saves whatever Room is passed to it to the Repo
    public Room updateRoom(Room room) {
    	return this.roomRepo.save(room);
    }
    
    //Fetch a List of all rooms
    public List<Room> getAllRooms() {
    	return this.roomRepo.findAll();
    }
    
    //Delete Room by given ID
    public void deleteRoombyID(Long id) {
        this.roomRepo.deleteById(id);
    }

    //getRoom using ID
    public Room getRoombyID(Long id) {return this.roomRepo.getReferenceById(id);}

    
}
