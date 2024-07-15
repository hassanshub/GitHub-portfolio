package com.example.samaanlachalo;

public class Parcels {
    private String name, contact, startingLocation, endingLocation, maxDate, size, notes;

    public Parcels(){
    }

    public Parcels(String name, String contact, String startingLocation, String endingLocation, String maxDate, String size, String notes){
        this.name = name;
        this.contact = contact;
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.maxDate = maxDate;
        this.size = size;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) { this.contact = contact; }

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

    public String getMaxDate(){
        return maxDate;
    }

    public void setMaxDate(String maxDate){
        this.maxDate = maxDate;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getNotes(){
        return notes;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

}
