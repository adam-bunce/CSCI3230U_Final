package com.webdev.project.repo;

import com.webdev.project.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

// Room Repo not using any additional functions beyond the base
public interface RoomRepo extends JpaRepository<Room, Long> {
}
