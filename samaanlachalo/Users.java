package com.example.samaanlachalo;

public class Users {
    private String UID, type;

    public Users() {
    }

    public Users(String UID, String Type) {
        this.UID = UID;
        this.type = Type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

}
