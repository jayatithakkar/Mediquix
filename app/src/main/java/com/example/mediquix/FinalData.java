package com.example.mediquix;

public class FinalData {

    public int Age;
    public long Weight;
    public String Blood_Group;

    public FinalData() {
    }

    public FinalData(String bgrp, int age, long contact) {
        Blood_Group = bgrp;
        Age=age;
        Weight = contact;
    }

}
