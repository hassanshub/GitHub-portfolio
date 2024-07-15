package com.example.samaanlachalo;

public class Select {
    private String Name, contact, price;

    public Select() {
    }

    public Select(String Name, String contact, String price) {
        this.Name = Name;
        this.contact = contact;
        this.price = price;
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

    public  String getPrice(){
        return price;
    }

    public  void setPrice(String price) { this.price = price; }

}
