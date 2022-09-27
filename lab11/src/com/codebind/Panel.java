package com.codebind;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class Panel extends JPanel {

    static LinkedList<Projects> list = new LinkedList<>();

    private final JLabel jlTitle = new JLabel();

    //Adding
    private final JTextField jtfAddProject = new JTextField();
    private final JTextField jtfAddTask = new JTextField();
    private final JTextField jtfAddEmployee = new JTextField();
    private final JTextField jtfAddManager = new JTextField();
    private final JTextField jtfAddDate = new JTextField();
    private final JTextField jtfAddNum = new JTextField();
    private final JLabel jlAddProject = new JLabel();
    private final JLabel jlAddTask = new JLabel();
    private final JLabel jlAddEmployee = new JLabel();
    private final JLabel jlAddManager = new JLabel();
    private final JLabel jlAddDate = new JLabel();
    private final JLabel jlAddNum = new JLabel();
    private final JButton btnAddOK = new JButton();

    //Adding by id
    private final JTextField jtfAddByIDProject = new JTextField();
    private final JTextField jtfAddByIDTask = new JTextField();
    private final JTextField jtfAddByIDEmployee = new JTextField();
    private final JTextField jtfAddByIDManager = new JTextField();
    private final JTextField jtfAddByIDDate = new JTextField();
    private final JTextField jtfAddByIDNum = new JTextField();
    private final JTextField jtfAddByIDID = new JTextField();
    private final JLabel jlAddByIDProject = new JLabel();
    private final JLabel jlAddByIDTask = new JLabel();
    private final JLabel jlAddByIDEmployee = new JLabel();
    private final JLabel jlAddByIDManager = new JLabel();
    private final JLabel jlAddByIDDate = new JLabel();
    private final JLabel jlAddByIDNum = new JLabel();
    private final JLabel jlAddByIDID = new JLabel();
    private final JButton btnAddByIDOK = new JButton();

    //Print
    private final JTextArea jtaPrint = new JTextArea();

    //Delete
    private final JTextField jtfDelete = new JTextField();
    private final JLabel jlDeleteID = new JLabel();
    private final JButton btnDeleteOK = new JButton();

    //Change
    private final JTextField jtfChangeID = new JTextField();
    private final JLabel jlChangeID = new JLabel();
    private final JButton btnChangeOKID = new JButton();
    private final JTextField jtfChangeProject = new JTextField();
    private final JTextField jtfChangeTask = new JTextField();
    private final JTextField jtfChangeEmployee = new JTextField();
    private final JTextField jtfChangeManager = new JTextField();
    private final JTextField jtfChangeDate = new JTextField();
    private final JTextField jtfChangeNum = new JTextField();
    private final JLabel jlChangeProject = new JLabel();
    private final JLabel jlChangeTask = new JLabel();
    private final JLabel jlChangeEmployee = new JLabel();
    private final JLabel jlChangeManager = new JLabel();
    private final JLabel jlChangeDate = new JLabel();
    private final JLabel jlChangeNum = new JLabel();
    private final JButton btnChangeOK = new JButton();

    //managers work
    private final JTextField jtfManager = new JTextField();
    private final JLabel jlManager = new JLabel();
    private final JButton btnManagerOK = new JButton();
    private final JTextArea jtaManager = new JTextArea();

    //employees work
    private final JTextField jtfEmployee = new JTextField();
    private final JLabel jlEmployee = new JLabel();
    private final JButton btnEmployeeOK = new JButton();
    private final JTextArea jtaEmployee = new JTextArea();

    public Panel() {
        setLayout(null);
        jlTitle.setBounds(220, 10, 200, 20);
        add(jlTitle);
        jlTitle.setVisible(false);
        JButton btnAdd = new JButton();
        btnAdd.setBounds(10, 10, 200, 20);
        btnAdd.setText("Add new task");
        add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setText("Adding new task:");
                jlTitle.setVisible(true);
                AddingPanelVisibility();
            }
        });

        JButton btnAddById = new JButton();
        btnAddById.setBounds(10, 40, 200, 20);
        btnAddById.setText("Add new task by id");
        add(btnAddById);
        btnAddById.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setText("Adding new task by id:");
                jlTitle.setVisible(true);
                AddingByIdPanelVisibility();
            }
        });

        JButton btnPrint = new JButton();
        btnPrint.setBounds(10, 70, 200, 20);
        btnPrint.setText("Print every task");
        add(btnPrint);
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(950,320);
                AllGone();
                jlTitle.setText("Every task:");
                int id = 0;
                for (Projects project : list)
                {
                    jtaPrint.setText(jtaPrint.getText() + "Task#" + id + ": ");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    jtaPrint.setText(jtaPrint.getText() + "\nProject " + project.project + ", task: " + project.task + ", executioner: " + project.employee + " under " + project.manager + ". Since " + formatter.format(project.time) + ", time to complete: " + project.num + " days\n");
                    id++;
                }
                jtaPrint.setVisible(true);
                jlTitle.setVisible(true);
            }
        });
        JButton btnDelete = new JButton();
        btnDelete.setBounds(10, 100, 200, 20);
        btnDelete.setText("Delete task");
        add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setText("Deleting task:");
                jtfDelete.setVisible(true);
                jlDeleteID.setVisible(true);
                jlTitle.setVisible(true);
                btnDeleteOK.setVisible(true);
            }
        });
        JButton btnChange = new JButton();
        btnChange.setBounds(10, 130, 200, 20);
        btnChange.setText("Change task");
        add(btnChange);
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setText("Change task:");
                jlChangeID.setVisible(true);
                jlTitle.setVisible(true);
                jtfChangeID.setVisible(true);
                jtfChangeID.setEditable(true);
                btnChangeOKID.setVisible(true);
            }
        });
        JButton btnToFile = new JButton();
        btnToFile.setBounds(10, 160, 200, 20);
        btnToFile.setText("Save tasks to file");
        add(btnToFile);
        btnToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setVisible(false);
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
                int result = fileChooser.showOpenDialog(App.frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    try (FileWriter fileWriter = new FileWriter(selectedFile)) {
                        fileWriter.write("project|task|employee|manager|start date|num of days\n");
                        for (Projects project : list) {
                            fileWriter.append(project.project + "|" + project.task + "|" + project.employee + "|" + project.manager + "|" + formatter.format(project.time) + "|" + project.num + "\n");
                        }
                        fileWriter.flush();
                        fileWriter.close();
                        JOptionPane.showMessageDialog(null, "Successful");
                    }
                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Something went wrong");
                    }
                }
            }
        });
        JButton btnFromFile = new JButton();
        btnFromFile.setBounds(10, 190, 200, 20);
        btnFromFile.setText("Read tasks from file");
        add(btnFromFile);
        btnFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setVisible(false);
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
                    int result = fileChooser.showOpenDialog(App.frame);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        if (list.size() != 0) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Overwrite tasks?", "Warning", dialogButton);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                list.clear();
                            }
                        }
                        File selectedFile = fileChooser.getSelectedFile();

                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                            String st;
                            br.readLine();
                            while ((st = br.readLine()) != null) {
                                String[] masString = st.split("\\|", 6);
                                list.add(new Projects(masString[0], masString[1], masString[2], masString[3], formatter.parse(masString[4]), Integer.parseInt(masString[5])));
                            }
                            JOptionPane.showMessageDialog(null, "Successful");
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Something went wrong");
                        }
                    }
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }
            }
        });
        JButton btnManager = new JButton();
        btnManager.setBounds(10, 220, 200, 20);
        btnManager.setText("Print every manager's tasks");
        add(btnManager);
        btnManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setText("Every manager's task:");
                jlManager.setVisible(true);
                jlTitle.setVisible(true);
                jtfManager.setVisible(true);
                jtfManager.setEditable(true);
                btnManagerOK.setVisible(true);
            }
        });
        JButton btnEmployee = new JButton();
        btnEmployee.setBounds(10, 250, 200, 20);
        btnEmployee.setText("Print every employee's tasks");
        add(btnEmployee);
        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(570,320);
                AllGone();
                jlTitle.setText("Every employee's task:");
                jlEmployee.setVisible(true);
                jlTitle.setVisible(true);
                jtfEmployee.setVisible(true);
                jtfEmployee.setEditable(true);
                btnEmployeeOK.setVisible(true);
            }
        });

        //Adding
        jlAddProject.setBounds(220, 40, 110, 20);
        jlAddProject.setText("Project name:");
        add(jlAddProject);
        jlAddTask.setBounds(220, 70, 110, 20);
        jlAddTask.setText("Task:");
        add(jlAddTask);
        jlAddEmployee.setBounds(220, 100, 110, 20);
        jlAddEmployee.setText("Employee:");
        add(jlAddEmployee);
        jlAddManager.setBounds(220, 130, 110, 20);
        jlAddManager.setText("Manager:");
        add(jlAddManager);
        jlAddDate.setBounds(220, 160, 110, 20);
        jlAddDate.setText("Start date:");
        add(jlAddDate);
        jlAddNum.setBounds(220, 190, 110, 20);
        jlAddNum.setText("Time to complete:");
        add(jlAddNum);

        jtfAddProject.setBounds(340, 40, 200, 20);
        add(jtfAddProject);
        jtfAddTask.setBounds(340, 70, 200, 20);
        add(jtfAddTask);
        jtfAddEmployee.setBounds(340, 100, 200, 20);
        add(jtfAddEmployee);
        jtfAddManager.setBounds(340, 130, 200, 20);
        add(jtfAddManager);
        jtfAddDate.setBounds(340, 160, 200, 20);
        add(jtfAddDate);
        jtfAddNum.setBounds(340, 190, 200, 20);
        add(jtfAddNum);

        btnAddOK.setBounds(340, 250, 200, 20);
        btnAddOK.setText("OK");
        add(btnAddOK);
        btnAddOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                if (jtfAddProject.getText() != null && jtfAddTask.getText() != null && jtfAddEmployee.getText() != null && jtfAddManager.getText() != null && jtfAddDate.getText() != null && jtfAddNum.getText() != null) {
                    try {
                        list.add(new Projects(jtfAddProject.getText(), jtfAddTask.getText(), jtfAddEmployee.getText(), jtfAddManager.getText(), formatter.parse(jtfAddDate.getText()), Integer.parseInt(jtfAddNum.getText())));
                        JOptionPane.showMessageDialog(null, "Successful");
                        AllGone();
                    } catch (ParseException parseException) {
                        JOptionPane.showMessageDialog(null, "Something wrong!\nCheck date and num of days and try again.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Something wrong!\nSome of fields empty.");
                }
            }
        });

        jlAddProject.setVisible(false);
        jlAddTask.setVisible(false);
        jlAddEmployee.setVisible(false);
        jlAddManager.setVisible(false);
        jlAddDate.setVisible(false);
        jlAddNum.setVisible(false);

        jtfAddProject.setVisible(false);
        jtfAddTask.setVisible(false);
        jtfAddEmployee.setVisible(false);
        jtfAddManager.setVisible(false);
        jtfAddDate.setVisible(false);
        jtfAddNum.setVisible(false);

        btnAddOK.setVisible(false);

        //Adding by id
        jlAddByIDProject.setBounds(220, 70, 110, 20);
        jlAddByIDProject.setText("Project name:");
        add(jlAddByIDProject);
        jlAddByIDTask.setBounds(220, 100, 110, 20);
        jlAddByIDTask.setText("Task:");
        add(jlAddByIDTask);
        jlAddByIDEmployee.setBounds(220, 130, 110, 20);
        jlAddByIDEmployee.setText("Employee:");
        add(jlAddByIDEmployee);
        jlAddByIDManager.setBounds(220, 160, 110, 20);
        jlAddByIDManager.setText("Manager:");
        add(jlAddByIDManager);
        jlAddByIDDate.setBounds(220, 190, 110, 20);
        jlAddByIDDate.setText("Start date:");
        add(jlAddByIDDate);
        jlAddByIDNum.setBounds(220, 220, 110, 20);
        jlAddByIDNum.setText("Time to complete:");
        add(jlAddByIDNum);
        jlAddByIDID.setBounds(220, 40, 110, 20);
        jlAddByIDID.setText("id:");
        add(jlAddByIDID);

        jtfAddByIDProject.setBounds(340, 70, 200, 20);
        add(jtfAddByIDProject);
        jtfAddByIDTask.setBounds(340, 100, 200, 20);
        add(jtfAddByIDTask);
        jtfAddByIDEmployee.setBounds(340, 130, 200, 20);
        add(jtfAddByIDEmployee);
        jtfAddByIDManager.setBounds(340, 160, 200, 20);
        add(jtfAddByIDManager);
        jtfAddByIDDate.setBounds(340, 190, 200, 20);
        add(jtfAddByIDDate);
        jtfAddByIDNum.setBounds(340, 220, 200, 20);
        add(jtfAddByIDNum);
        jtfAddByIDID.setBounds(340, 40, 200, 20);
        add(jtfAddByIDID);

        btnAddByIDOK.setBounds(340, 250, 200, 20);
        btnAddByIDOK.setText("OK");
        add(btnAddByIDOK);
        btnAddByIDOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                if (jtfAddByIDProject.getText() != null && jtfAddByIDTask.getText() != null && jtfAddByIDEmployee.getText() != null && jtfAddByIDManager.getText() != null && jtfAddByIDDate.getText() != null && jtfAddByIDNum.getText() != null && jtfAddByIDID.getText() != null) {
                    try {
                        list.add(Integer.parseInt(jtfAddByIDID.getText()), new Projects(jtfAddByIDProject.getText(), jtfAddByIDTask.getText(), jtfAddByIDEmployee.getText(), jtfAddByIDManager.getText(), formatter.parse(jtfAddByIDDate.getText()), Integer.parseInt(jtfAddByIDNum.getText())));
                        JOptionPane.showMessageDialog(null, "Successful");
                        AllGone();
                    } catch (ParseException parseException) {
                        JOptionPane.showMessageDialog(null, "Something wrong!\nCheck date num of days, id and try again.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Something wrong!\nSome of fields empty.");
                }
            }
        });

        jlAddByIDProject.setVisible(false);
        jlAddByIDTask.setVisible(false);
        jlAddByIDEmployee.setVisible(false);
        jlAddByIDManager.setVisible(false);
        jlAddByIDDate.setVisible(false);
        jlAddByIDNum.setVisible(false);
        jlAddByIDID.setVisible(false);

        jtfAddByIDProject.setVisible(false);
        jtfAddByIDTask.setVisible(false);
        jtfAddByIDEmployee.setVisible(false);
        jtfAddByIDManager.setVisible(false);
        jtfAddByIDDate.setVisible(false);
        jtfAddByIDNum.setVisible(false);
        jtfAddByIDID.setVisible(false);

        btnAddByIDOK.setVisible(false);

        //Print
        jtaPrint.setBounds(220, 40, 700, 230);
        add(jtaPrint);
        jtaPrint.setEditable(false);
        jtaPrint.setVisible(false);

        //Delete
        jlDeleteID.setBounds(220, 40, 110, 20);
        jlDeleteID.setText("id:");
        add(jlDeleteID);

        jtfDelete.setBounds(340, 40, 200, 20);
        add(jtfDelete);

        btnDeleteOK.setBounds(340, 70, 200, 20);
        btnDeleteOK.setText("OK");
        add(btnDeleteOK);
        btnDeleteOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.remove(Integer.parseInt(jtfDelete.getText()));
                    JOptionPane.showMessageDialog(null, "Successful");
                    AllGone();
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Something wrong!\nCheck id.");
                }
            }
        });

        jtfDelete.setVisible(false);
        jlDeleteID.setVisible(false);
        btnDeleteOK.setVisible(false);

        //Change
        jlChangeID.setBounds(220, 40, 110, 20);
        jlChangeID.setText("id:");
        add(jlChangeID);

        jtfChangeID.setBounds(340, 40, 200, 20);
        add(jtfChangeID);

        jlChangeProject.setBounds(220, 70, 110, 20);
        jlChangeProject.setText("Project name:");
        add(jlChangeProject);
        jlChangeTask.setBounds(220, 100, 110, 20);
        jlChangeTask.setText("Task:");
        add(jlChangeTask);
        jlChangeEmployee.setBounds(220, 130, 110, 20);
        jlChangeEmployee.setText("Employee:");
        add(jlChangeEmployee);
        jlChangeManager.setBounds(220, 160, 110, 20);
        jlChangeManager.setText("Manager:");
        add(jlChangeManager);
        jlChangeDate.setBounds(220, 190, 110, 20);
        jlChangeDate.setText("Start date:");
        add(jlChangeDate);
        jlChangeNum.setBounds(220, 220, 110, 20);
        jlChangeNum.setText("Time to complete:");
        add(jlChangeNum);

        jtfChangeProject.setBounds(340, 70, 200, 20);
        add(jtfChangeProject);
        jtfChangeTask.setBounds(340, 100, 200, 20);
        add(jtfChangeTask);
        jtfChangeEmployee.setBounds(340, 130, 200, 20);
        add(jtfChangeEmployee);
        jtfChangeManager.setBounds(340, 160, 200, 20);
        add(jtfChangeManager);
        jtfChangeDate.setBounds(340, 190, 200, 20);
        add(jtfChangeDate);
        jtfChangeNum.setBounds(340, 220, 200, 20);
        add(jtfChangeNum);

        btnChangeOK.setBounds(340, 250, 200, 20);
        btnChangeOK.setText("OK");
        add(btnChangeOK);

        jlChangeProject.setVisible(false);
        jlChangeTask.setVisible(false);
        jlChangeEmployee.setVisible(false);
        jlChangeManager.setVisible(false);
        jlChangeDate.setVisible(false);
        jlChangeNum.setVisible(false);
        jtfChangeProject.setVisible(false);
        jtfChangeTask.setVisible(false);
        jtfChangeEmployee.setVisible(false);
        jtfChangeManager.setVisible(false);
        jtfChangeDate.setVisible(false);
        jtfChangeNum.setVisible(false);

        btnChangeOK.setVisible(false);

        btnChangeOKID.setBounds(340, 70, 200, 20);
        btnChangeOKID.setText("OK");
        add(btnChangeOKID);
        btnChangeOKID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    int id = Integer.parseInt(jtfChangeID.getText());
                    jtfChangeProject.setText(list.get(id).project);
                    jtfChangeTask.setText(list.get(id).task);
                    jtfChangeEmployee.setText(list.get(id).employee);
                    jtfChangeManager.setText(list.get(id).manager);
                    jtfChangeDate.setText(formatter.format(list.get(id).time));
                    jtfChangeNum.setText(String.valueOf(list.get(id).num));

                    btnChangeOKID.setVisible(false);
                    jtfChangeID.setEditable(false);

                    jlChangeProject.setVisible(true);
                    jlChangeTask.setVisible(true);
                    jlChangeEmployee.setVisible(true);
                    jlChangeManager.setVisible(true);
                    jlChangeDate.setVisible(true);
                    jlChangeNum.setVisible(true);
                    jtfChangeProject.setVisible(true);
                    jtfChangeTask.setVisible(true);
                    jtfChangeEmployee.setVisible(true);
                    jtfChangeManager.setVisible(true);
                    jtfChangeDate.setVisible(true);
                    jtfChangeNum.setVisible(true);

                    btnChangeOK.setVisible(true);
                }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Something wrong!\nCheck id.");
                }
            }
        });

        btnChangeOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(jtfChangeID.getText());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    list.get(id).project = jtfChangeProject.getText();
                    list.get(id).task = jtfChangeTask.getText();
                    list.get(id).employee = jtfChangeEmployee.getText();
                    list.get(id).manager = jtfChangeManager.getText();
                    list.get(id).time = formatter.parse(jtfChangeDate.getText());
                    list.get(id).num = Integer.parseInt(jtfChangeNum.getText());
                    JOptionPane.showMessageDialog(null, "Successful");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something wrong!\nCheck date and num of days and try again.");
                }
                AllGone();
            }
        });

        jlChangeID.setVisible(false);
        jtfChangeID.setVisible(false);
        btnChangeOKID.setVisible(false);

        //Manager
        jlManager.setBounds(220, 40, 110, 20);
        jlManager.setText("Manager:");
        add(jlManager);

        jtfManager.setBounds(340, 40, 200, 20);
        add(jtfManager);

        jtaManager.setBounds(220, 70, 700, 230);
        add(jtaManager);
        jtaManager.setEditable(false);

        btnManagerOK.setBounds(340, 70, 200, 20);
        btnManagerOK.setText("OK");
        add(btnManagerOK);
        btnManagerOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(950,320);
                int id = 0;

                jtaManager.setVisible(true);
                btnManagerOK.setVisible(false);
                jtfManager.setEditable(false);
                for (Projects project : list)
                {
                    if (project.manager.equals(jtfManager.getText())) {
                        jtaManager.setText(jtaManager.getText() + "Task#" + id + ": ");
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        jtaManager.setText(jtaManager.getText() + "\nProject " + project.project + ", task: " + project.task + ", executioner: " + project.employee + " under " + project.manager + ". Since " + formatter.format(project.time) + ", time to complete: " + project.num + " days\n");
                    }
                    id++;
                }
            }
        });

        jlManager.setVisible(false);
        jtfManager.setVisible(false);
        jtaManager.setVisible(false);
        btnManagerOK.setVisible(false);

        //employee
        jlEmployee.setBounds(220, 40, 110, 20);
        jlEmployee.setText("Employee:");
        add(jlEmployee);

        jtfEmployee.setBounds(340, 40, 200, 20);
        add(jtfEmployee);

        jtaEmployee.setBounds(220, 70, 700, 230);
        add(jtaEmployee);
        jtaEmployee.setEditable(false);

        btnEmployeeOK.setBounds(340, 70, 200, 20);
        btnEmployeeOK.setText("OK");
        add(btnEmployeeOK);
        btnEmployeeOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.frame.setSize(950,320);
                int id = 0;

                jtaEmployee.setVisible(true);
                btnEmployeeOK.setVisible(false);
                jtfEmployee.setEditable(false);
                for (Projects project : list)
                {
                    if (project.employee.equals(jtfEmployee.getText())) {
                        jtaEmployee.setText(jtaEmployee.getText() + "Task#" + id + ": ");
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        jtaEmployee.setText(jtaEmployee.getText() + "\nProject " + project.project + ", task: " + project.task + ", executioner: " + project.employee + " under " + project.manager + ". Since " + formatter.format(project.time) + ", time to complete: " + project.num + " days\n");
                    }
                    id++;
                }
            }
        });

        jlEmployee.setVisible(false);
        jtfEmployee.setVisible(false);
        jtaEmployee.setVisible(false);
        btnEmployeeOK.setVisible(false);
    }

    private void AllGone() {
        JLabel[] lmas = { jlAddProject, jlAddTask, jlAddEmployee, jlAddManager, jlAddDate, jlAddNum, jlAddByIDProject, jlAddByIDTask, jlAddByIDEmployee, jlAddByIDManager,
                jlAddByIDDate, jlAddByIDNum, jlAddByIDID, jlDeleteID, jlChangeID, jlChangeProject, jlChangeTask, jlChangeEmployee, jlChangeManager, jlChangeDate,
                jlChangeNum, jlManager, jlEmployee, jlTitle};
        for (JLabel jl : lmas) {
            jl.setVisible(false);
        }
        JTextField[] jtfmas = { jtfAddProject, jtfAddTask, jtfAddEmployee, jtfAddManager, jtfAddDate, jtfAddNum, jtfAddProject, jtfAddByIDProject, jtfAddByIDTask,
                jtfAddByIDEmployee, jtfAddByIDManager, jtfAddByIDDate, jtfAddByIDNum, jtfAddByIDID, jtfDelete, jtfDelete, jtfChangeID, jtfChangeProject, jtfChangeTask,
                jtfChangeEmployee, jtfChangeManager, jtfChangeDate, jtfChangeNum, jtfChangeProject, jtfChangeTask, jtfChangeManager, jtfChangeEmployee, jtfChangeDate,
                jtfChangeNum, jtfManager, jtfEmployee};
        for (JTextField jtf : jtfmas) {
            jtf.setVisible(false);
            jtf.setText(null);
        }
        JButton[] btnmas = { btnAddOK, btnAddByIDOK, btnDeleteOK, btnChangeOKID, btnChangeOK, btnManagerOK, btnEmployeeOK};
        for (JButton jbtn : btnmas) {
            jbtn.setVisible(false);
        }
        JTextArea[] jtamas = { jtaPrint, jtaManager, jtaEmployee};
        for (JTextArea jta : jtamas) {
            jta.setVisible(false);
            jta.setText(null);
        }
    }

    private void AddingPanelVisibility() {
        jlAddProject.setVisible(true);
        jlAddTask.setVisible(true);
        jlAddEmployee.setVisible(true);
        jlAddManager.setVisible(true);
        jlAddDate.setVisible(true);
        jlAddNum.setVisible(true);

        jtfAddProject.setVisible(true);
        jtfAddTask.setVisible(true);
        jtfAddEmployee.setVisible(true);
        jtfAddManager.setVisible(true);
        jtfAddDate.setVisible(true);
        jtfAddNum.setVisible(true);

        btnAddOK.setVisible(true);
    }

    private void AddingByIdPanelVisibility() {
        jlAddByIDProject.setVisible(true);
        jlAddByIDTask.setVisible(true);
        jlAddByIDEmployee.setVisible(true);
        jlAddByIDManager.setVisible(true);
        jlAddByIDDate.setVisible(true);
        jlAddByIDNum.setVisible(true);
        jlAddByIDID.setVisible(true);

        jtfAddByIDProject.setVisible(true);
        jtfAddByIDTask.setVisible(true);
        jtfAddByIDEmployee.setVisible(true);
        jtfAddByIDManager.setVisible(true);
        jtfAddByIDDate.setVisible(true);
        jtfAddByIDNum.setVisible(true);
        jtfAddByIDID.setVisible(true);

        btnAddByIDOK.setVisible(true);
    }
}