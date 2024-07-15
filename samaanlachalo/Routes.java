package com.example.samaanlachalo;

public class Routes {
    private String Name, contact, startingLocation, endingLocation, Date, availableSpace;

    public Routes() {
    }

    public Routes(String Name, String contact, String startingLocation, String endingLocation, String date, String availableSpace) {
        this.Name = Name;
        this.contact = contact;
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.Date = date;
        this.availableSpace = availableSpace;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public  String getContact(){
        return contact;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public  String getStartingLocation(){
        return startingLocation;
    }

    public  void getStartingLocation(String startingLocation){ this.startingLocation = startingLocation;    }

    public String getEndingLocation(){
        return endingLocation;
    }

    public void setEndingLocation(String endingLocation){
        this.endingLocation = endingLocation;
    }

    public String getDate(){
        return Date;
    }
    public void setDate(String date){
        this.Date = date;
    }

    public String getAvailableSpace(){
        return availableSpace;
    }

    public void setAvailableSpace(String availableSpace){
        this.availableSpace = availableSpace;
    }
}
