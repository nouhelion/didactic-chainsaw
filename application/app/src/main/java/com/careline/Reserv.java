package com.careline;

public class Reserv {
    public String date,hour,why;

    public Reserv() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public Reserv(String date, String hour, String why) {
        this.date = date;
        this.hour = hour;
        this.why = why;
    }
}
