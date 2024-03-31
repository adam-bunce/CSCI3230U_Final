package com.webdev.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdev.project.model.Customer;
import com.webdev.project.model.Room;
import com.webdev.project.repo.RoomRepo;

@Service
public class RoomService {
	RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo repo) {
        super();
        this.roomRepo = repo;
    }
    
    public Room updateRoom(Room room) {
    	return this.roomRepo.save(room);
    }
    
    public List<Room> getAllRooms() {
    	return this.roomRepo.findAll();
    }
    
    public void deleteRoombyID(Long id) {
        this.roomRepo.deleteById(id);
    }

    public Room getRoombyID(Long id) {return this.roomRepo.getReferenceById(id);}

    
}
