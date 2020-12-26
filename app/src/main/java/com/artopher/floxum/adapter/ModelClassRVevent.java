package com.artopher.floxum.adapter;

public class ModelClassRVevent {


    int calendar_icon ,event_image , location_pin ;
    String event_title , event_date , event_location ;

    public ModelClassRVevent(int event_image, String event_title, String event_date, String event_location ,int location_pin, int calendar_icon) {
        this.event_image = event_image;
        this.event_title = event_title;
        this.event_date = event_date;
        this.event_location = event_location;
        this.location_pin = location_pin;
        this.calendar_icon = calendar_icon;
    }

    public int getEvent_image() {
        return event_image;
    }

    public void setEvent_image(int event_image) {
        this.event_image = event_image;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public int getLocation_pin() {
        return location_pin;
    }

    public void setLocation_pin(int location_pin) {
        this.location_pin = location_pin;
    }

    public int getCalendar_icon() {
        return calendar_icon;
    }

    public void setCalendar_icon(int calendar_icon) {
        this.calendar_icon = calendar_icon;
    }
}
