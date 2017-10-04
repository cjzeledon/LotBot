package com.theironyard.charlotte.lotbot;

import java.time.LocalDateTime;

public class Transaction {
    private Vehicle vehicle;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private double price;

    // Use this method when parking a new car in a spot
    public Transaction(Vehicle vehicle, LocalDateTime checkInDate) {
        this.vehicle = vehicle;
        this.checkInDate = checkInDate;
    }

    public Transaction() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        this.price = price;
        return price;
    }




}
