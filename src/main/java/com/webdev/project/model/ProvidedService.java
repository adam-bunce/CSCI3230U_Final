package com.webdev.project.model;

import jakarta.persistence.*;

@Entity
@Table
public class ProvidedService {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public ProvidedService(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProvidedService() {
//       this.name = "Unknown Service Name";
//       this.description = "Unknown Service Description";
//       this.price = -0.1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "ProvidedService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", booking=" + booking +
                '}';
    }
}
