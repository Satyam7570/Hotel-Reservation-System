package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1300,750);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/three.jpg"));
        Image image = img.getImage().getScaledInstance(1300,760,Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon);
        imgLabel.setBounds(0,0,1300,760);

        JLabel title = new JLabel("WELCOME TO THE GUPTA HOTEL");
        title.setFont(new Font("Times New Roman",Font.BOLD,40));
        title.setForeground(Color.black.brighter());
        title.setBounds(280,100,1000,50);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1300,30);
        imgLabel.add(menuBar);

        JMenu menu = new JMenu("Hotel Management");
        menu.setFont(new Font("Times New Roman",Font.BOLD,15));
        menu.setForeground(Color.RED.brighter());
        menuBar.add(menu);

        JMenu admin = new JMenu("ADMIN");
        admin.setFont(new Font("Times New Roman",Font.BOLD,14));
        admin.setForeground(Color.blue.brighter());
        menuBar.add(admin);

        JMenuItem item1 = new JMenuItem("RECEPTION");
        item1.addActionListener(this);
        menu.add(item1);

        JMenuItem item2 = new JMenuItem("Add Employee");
        item2.addActionListener(this);
        admin.add(item2);

        JMenuItem item3 = new JMenuItem("Add Room");
        item3.addActionListener(this);
        admin.add(item3);


        imgLabel.add(title);
        add(imgLabel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }else if (ae.getActionCommand().equals("Add Room")){
            new AddRoom();
        }else if (ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }

    public static void main(String[] args){

        new Dashboard();
    }
}
