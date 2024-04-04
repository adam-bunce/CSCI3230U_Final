package com.webdev.project.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<ProvidedService> services;

    public Booking(LocalDate startDate, LocalDate endDate, Customer customer, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.room = room;
    }

    public Booking() {
        this.startDate = LocalDate.of(1, 1, 1);
        this.endDate = LocalDate.of(1, 1, 2);
        this.customer = new Customer();
        this.room = new Room();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<ProvidedService> getServices() {
        return services;
    }

    public void setServices(List<ProvidedService> services) {
        this.services = services;
    }

    public String numberAndRoom() {
        return "Booking " + id + " - " + "Room " + room.getRoomNumber() ;
    }

    public String startToEnd() {
        return startDate + " to " + endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", customer=" + customer.getName() +
                ", room=" + room.getRoomNumber() +
                ", services=" + services +
                '}';
    }
}
