package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Trains {

    String project;
    String task;
    String employee;
    String manager;
    Date time;
    int num;

    public Trains(String name, String task, String executioner, String boss, Date date, int numOfDays) {
        this.project = name;
        this.task = task;
        this.employee = executioner;
        this.manager = boss;
        this.time = date;
        this.num = numOfDays;
    }

    public void printing()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Project " + this.project + ", task: " + this.task + ", executioner: " + this.employee + " under " + this.manager + ". Since " + formatter.format(this.time) + ", time to complete: " + this.num + " days");
    }

}
