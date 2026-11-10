package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;//should be 0
        this.bookedRooms = bookedRooms;//should be 0
    }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedRooms;
    }

    public boolean bookRoom(int roomCount, boolean suite) {//add if for roomCount <= 0
        if (suite) {
            return roomCount <= getAvailableSuites(); //also update count
        } else {
            return roomCount <= getAvailableRooms(); //also update count
        }//return false for failed booking
    }
}
