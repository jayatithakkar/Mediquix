package com.example.mediquix;

public class Data {

    public String Name,Email;
    public long Contact;
    public int Age;
    public long Weight;
    public String Blood_Group;

    public Data() {
    }

    public Data(String name, String email,  long contact, String bgrp, int age, long contac) {
        Name = name;
        Email = email;

        Contact = contact;
        Blood_Group = bgrp;
        Age=age;
        Weight = contac;
    }
}
