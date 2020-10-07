package com.example.mediquix;

public class Child {

    private String title;
    private String year;

    private boolean expanded;

    public Child(String title, String year) {
        this.title = title;
        this.year = year;
        this.expanded = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "Child{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", expanded=" + expanded +
                '}';
    }

}
