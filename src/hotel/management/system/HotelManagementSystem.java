package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
    public HotelManagementSystem() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(90,30,1000,668);
        setLayout(null);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, 1000, 668);


        JLabel jLabel = new  JLabel("Hotel Reservation System");
        jLabel.setBounds(200,50,600,60);
        jLabel.setForeground(Color.white.brighter());
        jLabel.setFont(new Font("serif",Font.BOLD,50));

        JButton aContinue = new JButton("Continue");
        aContinue.setForeground(Color.MAGENTA);
        aContinue.setFocusable(false);
        aContinue.addActionListener(this);
        aContinue.setFont(new Font("serif",Font.PLAIN,15));
        aContinue.setBounds(450,350,100,40);


        add(label);

        label.add(jLabel);
        label.add(aContinue);

        setVisible(true);

        while(true){
            jLabel.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            jLabel.setVisible(true);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login().setVisible(true);
    }

    public static void main(String[] args){
        HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();
    }
}
