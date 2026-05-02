package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer, rooms, department, allEmployees, managerInfo, customers, updateInfo, searchrooms, logout;
    Reception() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(380,120,480,450);

        newCustomer = new JButton("New Customer");
        newCustomer.setBounds(50,50,150,30);
        newCustomer.setFocusable(false);
        newCustomer.setBackground(Color.blue.darker());
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);

        rooms = new JButton("Rooms");
        rooms.setBounds(250,50,150,30);
        rooms.setFocusable(false);
        rooms.setBackground(Color.blue.darker());
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);

//        department = new JButton("Department");
//        department.setBounds(50,150,150,30);
//        department.setFocusable(false);
//        department.setBackground(Color.black);
//        department.setForeground(Color.white);

        allEmployees = new JButton("All Employees");
        allEmployees.setBounds(250,150,150,30);
        allEmployees.setFocusable(false);
        allEmployees.setBackground(Color.blue.darker());
        allEmployees.setForeground(Color.white);
        allEmployees.addActionListener(this);

        customers = new JButton("Customers Info");
        customers.setBounds(50,250,150,30);
        customers.setFocusable(false);
        customers.setBackground(Color.blue.darker());
        customers.setForeground(Color.white);
        customers.addActionListener(this);

//        managerInfo = new JButton("Manager Info");
//        managerInfo.setBounds(250,250,150,30);
//        managerInfo.setFocusable(false);
//        managerInfo.setBackground(Color.black);
//        managerInfo.setForeground(Color.white);

        updateInfo = new JButton("Update Info");
        updateInfo.setBounds(250,250,150,30);
        updateInfo.setFocusable(false);
        updateInfo.setBackground(Color.blue.darker());
        updateInfo.setForeground(Color.white);
        updateInfo.addActionListener(this);

        searchrooms = new JButton("Search Rooms");
        searchrooms.setBounds(50,150,150,30);
        searchrooms.setFocusable(false);
        searchrooms.setBackground(Color.blue.darker());
        searchrooms.setForeground(Color.white);
        searchrooms.addActionListener(this);

        logout = new JButton("Logout");
        logout.setBounds(150,350,150,30);
        logout.setFocusable(false);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);

        add(logout);
        add(searchrooms);
        add(updateInfo);
//        add(managerInfo);
        add(customers);
        add(allEmployees);
//        add(department);
        add(rooms);
        add(newCustomer);
        setVisible(true);
    }

    public void  actionPerformed(ActionEvent e) {
        if (e.getSource() == newCustomer) {
            setVisible(false);
            new AddNewCustomer();
        } else if  (e.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if(e.getSource() == allEmployees) {
            setVisible(false);
            new EmployeeInfo();
        } else if(e.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        }  else if(e.getSource() == searchrooms) {
            setVisible(false);
            new SearchRoom();
        } else if(e.getSource() == updateInfo) {
            setVisible(false);
            new UpdateInfo();
        } else if(e.getSource() == logout) {
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Reception();
    }
}
