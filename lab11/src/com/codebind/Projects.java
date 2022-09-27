package com.codebind;

import java.util.Date;

public class Projects {
    String project;
    String task;
    String employee;
    String manager;
    Date time;
    int num;

    public Projects(String name, String task, String executioner, String boss, Date date, int numOfDays) {
        this.project = name;
        this.task = task;
        this.employee = executioner;
        this.manager = boss;
        this.time = date;
        this.num = numOfDays;
    }
}
