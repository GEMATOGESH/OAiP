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
            System.out.print("Insert operation (add, add by id, print, delete, new info, available places, save to file, read from file, exit): ");
            String input = in.nextLine();
            switch (input.toLowerCase()) {
                case "add" -> adding();
                case "add by id" -> addingById();
                case "print" -> printEveryone();
                case "delete" -> deleting();
                case "new info" -> newInfo();
                case "available places" -> availablePlaces();
                case "save to file" -> toFile();
                case "read from file" -> fromFile();
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
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            System.out.println("Adding new train...");
            System.out.print("Enter number of train: ");
            int num = in.nextInt();
            in.nextLine();
            System.out.print("Enter name of station: ");
            String station = in.nextLine();
            System.out.print("Enter arrival time: ");
            Date time;
            try {
                time = formatter.parse(in.nextLine());
            } catch (ParseException e) {
                System.out.println("Wrong time, starting over...");
                adding();
                return;
            }
            System.out.print("Enter number of empty seats: ");
            int seats = in.nextInt();

            list.add(new Trains(num, station, time, seats));
            System.out.println("Train #" + num + " is going to " + station + ". Arrival time: " + formatter.format(time) + ", available seats: " + seats);
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void addingById()
    {
        try {
            Scanner in = new Scanner(System.in);
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            System.out.println("Adding new train by id...");
            System.out.print("Enter number of train: ");
            int num = in.nextInt();
            in.nextLine();
            System.out.print("Enter name of station: ");
            String station = in.nextLine();
            System.out.print("Enter arrival time: ");
            Date time = null;
            try {
                time = formatter.parse(in.nextLine());
            } catch (ParseException e) {
                System.out.println("Wrong time, starting over...");
                adding();
            }
            System.out.print("Enter number of empty seats: ");
            int seats = in.nextInt();

            System.out.print("Enter id of train: ");
            int id = in.nextInt();

            list.add(id, new Trains(num, station, time, seats));
            System.out.println("Train #" + num + " is going to " + station + ". Arrival time: " + formatter.format(time) + ", available seats: " + seats);
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void printEveryone(){
        for (Trains train : list)
        {
            train.printing();
        }
    }

    public static void deleting(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter id of train: ");
            int id = in.nextInt();
            list.remove(id);
            System.out.println("Successful...");
        }   catch (Exception e) {
                System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void newInfo(){
        try {
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter id of train: ");
            int id = in.nextInt();
            in.nextLine();
            System.out.println("Train #" + list.get(id).num + " is going to " + list.get(id).station + ". Arrival time: " + formatter.format(list.get(id).time) + ", available seats: " + list.get(id).seats);

            System.out.print("What do you want to change(num, station, arriving time, number of empty seats, cancel)?: ");
            String input = in.nextLine();
            switch (input.toLowerCase()) {
                case "num" -> {
                    System.out.print("Enter new number of train: ");
                    int num = in.nextInt();
                    in.nextLine();
                    list.get(id).num = num;
                }
                case "station" -> {
                    System.out.print("Enter new name of station: ");
                    String station = in.nextLine();
                    in.nextLine();
                    list.get(id).station = station;
                }
                case "arriving time" -> {
                    System.out.print("Enter new arrival time: ");
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
                case "number of empty seats" -> {
                    System.out.print("Enter number of empty seats: ");
                    list.get(id).seats = in.nextInt();
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
            System.out.println("Train #" + list.get(id).num + " is going to " + list.get(id).station + ". Arrival time: " + formatter.format(list.get(id).time) + ", available seats: " + list.get(id).seats);
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void availablePlaces(){
        try {
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter new name of station: ");
            String station = in.nextLine();
            for (Trains train : list) {
                if (train.station.toLowerCase().equals(station.toLowerCase())) {
                    if (train.seats > 0) {
                        System.out.println("Train #" + train.num + " is going to " + train.station + ". Arrival time: " + formatter.format(train.time) + ", available seats: " + train.seats);
                    }
                }
            }
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void toFile(){
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        try (FileWriter fileWriter = new FileWriter("info.txt")) {
            fileWriter.write("num of train|end station|arriving time|available seats\n");
            for (Trains train : list) {
                fileWriter.append(train.num + "|" + train.station + "|" + formatter.format(train.time) + "|" + train.seats + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Successful...");
        }   catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }

    public static void fromFile() {
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        try {
            File file = new File("info.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            br.readLine();
            while ((st = br.readLine()) != null) {
                String[] masString = st.split("\\|", 4);
                list.add(new Trains(Integer.parseInt(masString[0]), masString[1], formatter.parse(masString[2]), Integer.parseInt(masString[3])));
            }
            System.out.println("Successful..."); }
        catch (Exception e) {
            System.out.println("Something went wrong, returning to main menu...");
        }
    }
}
