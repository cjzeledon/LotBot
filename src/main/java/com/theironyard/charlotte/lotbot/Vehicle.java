package com.theironyard.charlotte.lotbot;

/*
Setting the Vehicle as an abstract class is perfect so that when creating various class of vehicles such as
motorcycle, truck, etc are created--they MUST have the field "licensePlate"
It also allows us the opportunity to generate different type of vehicles that can also have their own set of fields
*/

public abstract class Vehicle {
    protected String licensePlate;
}
