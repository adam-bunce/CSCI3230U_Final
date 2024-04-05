package com.webdev.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webdev.project.model.Room;
import com.webdev.project.service.RoomService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	//Handler for the /rooms/list page and sets attributes to allow data render
	@GetMapping("/list")
	public String viewRooms(Model model) {
		model.addAttribute("rooms",this.roomService.getAllRooms());
		return "/rooms/list";
	}
	
	//handles the get call from create to create a new room and attach it to the page
    @GetMapping("/create")
    public String viewCreateRoom(Model model) {
        model.addAttribute("newRoom", new Room());
        return "/rooms/create";
    }
    
    //Post Handling for /create takes the room with the new data and saves it
    @PostMapping("/create")
    public String createRoom(Room newRoom, Model model) {
        this.roomService.updateRoom(newRoom);
        return "redirect:/rooms/list";
    }
    
    //Post handling for /delete deletes the room by given ID
    @PostMapping("/delete")
    public String deleteCustomer(Long roomID, Model model) {
        this.roomService.deleteRoombyID(roomID);
        return "redirect:/rooms/list";
    }

    // Get Mapping for Edit, gets the room details for editing by using given ID in url
    @GetMapping("/edit/{id}")
    public String editRoom(@PathVariable Long id, Model model) {
    	Room room = this.roomService.getRoombyID(id);
        model.addAttribute("selRoom", room);
        return "/rooms/edit";
    }

    //Post Handeling for /update updates room details and redirects to main page
    @PostMapping("/update")
    public String updateRoom(Room room, Model model) {
        this.roomService.updateRoom(room);
        return "redirect:/rooms/list";
    }
}
