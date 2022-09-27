package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static LinkedList<Trains> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Insert operation (add, add by id, print, delete, new info, save to file, read from file, every manager's work, every employee's work, exit): ");
            String input = in.nextLine();
            switch (input.toLowerCase()) {
                case "add" -> adding();
                case "add by id" -> addingById();
                case "print" -> printEveryone();
                case "delete" -> deleting();
                case "new info" -> newInfo();
                case "save to file" -> toFile();
                case "read from file" -> fromFile();
                case "every manager's work" -> everyManager();
                case "every employee's work" -> everyEmployee();
                case "exit" -> {
                    return;
                }
                default -> System.out.println("Wrong operation");
            }
        }
    }

    public static void adding()
    {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Adding new task...");
            System.out.print("Enter project name: ");
            String project = in.nextLine();
            System.out.print("Enter task: ");
            String task = in.nextLine();
            System.out.print("Enter name of employee: ");
            String employee = in.nextLine();
            System.out.print("Enter name of manager: ");
            String manager = in.nextLine();
            System.out.print("Enter start date: ");
            Date time = null;
            try {
                time = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
            }
            catch (Exception e) {
                System.out.println("Wrong date, returning to main menu...");
            }
            System.out.print("Enter number of days to complete: ");
            int num = in.nextInt();

            list.add(new Trains(project, task, employee, manager, time, num));
            System.out.println("Project " + project + ", task: " + task + ", executioner: " + employee + " under " + manager + ". Since " + new SimpleDateFormat("dd/MM/yyyy").format(time) + ", time to complete: " + num + " days");
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void addingById()
    {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Adding new task...");
            System.out.print("Enter project name: ");
            String project = in.nextLine();
            System.out.print("Enter task: ");
            String task = in.nextLine();
            System.out.print("Enter name of employee: ");
            String employee = in.nextLine();
            System.out.print("Enter name of manager: ");
            String manager = in.nextLine();
            System.out.print("Enter start date: ");
            Date time = null;
            try {
                time = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
            }
            catch (Exception e) {
                System.out.println("Wrong date, returning to main menu...");
            }
            System.out.print("Enter number of days to complete: ");
            int num = in.nextInt();

            System.out.print("Enter id of task: ");
            int id = in.nextInt();

            list.add(id, new Trains(project, task, employee, manager, time, num));
            System.out.println("Project " + project + ", task: " + task + ", executioner: " + employee + " under " + manager + ". Since " + new SimpleDateFormat("dd/MM/yyyy").format(time) + ", time to complete: " + num + " days");
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void printEveryone(){
        int id = 0;
        for (Trains train : list)
        {
            System.out.println("Task#" + id + ": ");
            train.printing();
            id++;
        }
    }

    public static void deleting(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter id of task: ");
            int id = in.nextInt();
            list.remove(id);
            System.out.println("Successful...");
        }   catch (Exception e) {
                System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void newInfo(){
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter id of task: ");
            int id = in.nextInt();
            in.nextLine();
            System.out.println("Project " + list.get(id).project + ", task: " + list.get(id).task + ", employee: " + list.get(id).employee + " under " + list.get(id).manager + ". Since " + formatter.format(list.get(id).time) + ", time to complete: " + list.get(id).num + " days");

            System.out.print("What do you want to change(project, task, employee, manager, date, time to complete, cancel)?: ");
            String input = in.nextLine();
            switch (input.toLowerCase()) {
                case "project" -> {
                    System.out.print("Enter new name of project: ");
                    list.get(id).project = in.nextLine();
                }
                case "task" -> {
                    System.out.print("Enter new task: ");
                    list.get(id).task = in.nextLine();
                }
                case "employee" -> {
                    System.out.print("Enter new employee: ");
                    list.get(id).employee = in.nextLine();
                }
                case "manager" -> {
                    System.out.print("Enter new manager: ");
                    list.get(id).employee = in.nextLine();
                }
                case "date" -> {
                    System.out.print("Enter new time: ");
                    Date time;
                    try {
                        time = formatter.parse(in.nextLine());
                        list.get(id).time = time;
                    } catch (ParseException e) {
                        System.out.println("Wrong time, starting over...");
                        newInfo();
                        return;
                    }
                }
                case "time to complete" -> {
                    System.out.print("Enter new time to complete(days): ");
                    list.get(id).num = in.nextInt();
                }
                case "cancel" -> {
                    System.out.println("Returning to the main menu...");
                    return;
                }
                default -> {
                    System.out.println("Wrong operation, returning to the main menu...");
                    return;
                }
            }
            System.out.println("Project " + list.get(id).project + ", task: " + list.get(id).task + ", employee: " + list.get(id).employee + " under " + list.get(id).manager + ". Since " + formatter.format(list.get(id).time) + ", time to complete: " + list.get(id).num + " days");
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void toFile(){
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try (FileWriter fileWriter = new FileWriter("info.txt")) {
            fileWriter.write("project|task|employee|manager|start date|num of days\n");
            for (Trains train : list) {
                fileWriter.append(train.project + "|" + train.task + "|" + train.employee + "|" + train.manager + "|" + formatter.format(train.time) + "|" + train.num + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void fromFile() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            File file = new File("info.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            br.readLine();
            while ((st = br.readLine()) != null) {
                String[] masString = st.split("\\|", 6);
                list.add(new Trains(masString[0], masString[1], masString[2], masString[3], formatter.parse(masString[4]), Integer.parseInt(masString[5])));
            }
            System.out.println("Successful..."); }
        catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void everyManager() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name of a manager: ");
        String name = in.nextLine();
        for (Trains train : list)
        {
            if (train.manager.equals(name))
                train.printing();
        }
        System.out.println("Successful...");
    }

    public static void everyEmployee() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name of a employee: ");
        String name = in.nextLine();
        for (Trains train : list)
        {
            if (train.employee.equals(name))
                train.printing();
        }
        System.out.println("Successful...");
    }
}
