package com.example.mediquix;

public class Data {

    public String Name,Email,Gender;
    public long Contact;
    public int Age;
    public long Weight;
    public String Blood_Group;

    public Data() {
    }

    public Data(String name, String email, String gender, long contact, String bgrp, int age, long contac) {
        Name = name;
        Email = email;
        Gender = gender;
        Contact = contact;
        Blood_Group = bgrp;
        Age=age;
        Weight = contac;
    }
}
