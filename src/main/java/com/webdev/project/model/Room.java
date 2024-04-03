package com.webdev.project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number")
    private String roomNumber;

    @Column
    private String type;

    @Column
    private Double price;

    // Room is associated with booking(s)
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Room(String roomNumber, String type, Double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
    }

    public Room() {
//        this.roomNumber = "Unknown Room Number";
//        this.type = "Unknown Type";
//        this.price = -1.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", bookings=" + bookings +
                '}';
    }
}
