package com.codebind;

import javax.swing.*;

public class App {
    private JPanel mainPanel;
    public static JFrame frame = new JFrame("App");

    public static void main (String[] args) {
        frame.add(new Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(570,320);
        frame.setLocation(500, 400);
        frame.setTitle("Tasks");
        frame.setResizable(false);
    }
}
