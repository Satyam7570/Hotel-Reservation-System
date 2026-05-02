package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JScrollPane scroll;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(250,50,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel customerInfo = new JLabel("Customer Info");
        customerInfo.setBounds(350,10,250,30);
        customerInfo.setFont(new Font("Times New Roman",Font.BOLD,20));

        table = new JTable();
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
        scroll = new JScrollPane(table);
        scroll.setBounds(0,60,800,500);

        try{
            DataBaseConnect con =  new DataBaseConnect();
            ResultSet rs = con.st.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(350,400,100,30);
        back.setFont(new Font("Times New Roman",Font.BOLD,20));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.addActionListener(this);

        add(back);
        add(customerInfo);
        add(scroll);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new CustomerInfo();
    }
}
