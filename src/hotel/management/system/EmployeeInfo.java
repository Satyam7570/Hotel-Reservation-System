package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable table;
    JScrollPane scroll;
    JButton back;
    EmployeeInfo(){
        setBounds(0,100,1300,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text=new JLabel("Employee Information");
        text.setFont(new Font("Times New Roman",Font.BOLD,25));
        text.setBounds(520,10,400,30);
        add(text);

        table = new JTable();
        table.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
        scroll = new JScrollPane(table);
        scroll.setBounds(0,60,1300,600);

        try{
            DataBaseConnect con =  new DataBaseConnect();
            ResultSet rs = con.st.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setFont(new Font("Times New Roman",Font.BOLD,15));
        back.setBounds(550,400,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.addActionListener(this);

        add(back);
        add(scroll);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args){
        new EmployeeInfo();
    }
}
