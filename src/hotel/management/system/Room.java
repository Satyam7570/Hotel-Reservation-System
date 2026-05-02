package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JScrollPane scroll;
    JButton back;
    Room(){
        setBounds(350,100,600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text=new JLabel("Room Information");
        text.setFont(new Font("Times New Roman",Font.BOLD,25));
        text.setBounds(190,10,400,30);
        add(text);

        table = new JTable();
        table.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
        scroll = new JScrollPane(table);
        scroll.setBounds(0,60,600,600);

        try{
            DataBaseConnect con =  new DataBaseConnect();
            ResultSet rs = con.st.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(250,400,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setFocusable(false);
        back.addActionListener(this);

        add(back);
        add(scroll);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Room();
    }
}
