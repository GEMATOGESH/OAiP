package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trains {

    int num;
    String station;
    Date time;
    int seats;

    public Trains(int num, String station, Date time, int seats) {
        this.num = num;
        this.station = station;
        this.time = time;
        this.seats = seats;
    }

    public void printing()
    {
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        System.out.println("Train #" + this.num + " is going to " + this.station + ". Arrival time: " + formatter.format(this.time) + ", available seats: " + this.seats);
    }

}
