package com.example.fragments;

public class Contact {
    private int imageID;
    private String name;
    private String phoneNumber;

    public Contact(int imgID, String name, String phoneNumber) {
        this.imageID = imgID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
