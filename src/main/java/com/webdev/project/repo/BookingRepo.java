package com.webdev.project.repo;

import com.webdev.project.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository <Entity, PrimaryKey>
public interface BookingRepo extends JpaRepository<Booking, Long> {

}
