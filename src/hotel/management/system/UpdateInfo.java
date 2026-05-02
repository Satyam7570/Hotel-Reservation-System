package hotel.management.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInfo extends JFrame implements ActionListener {
    Choice customerChoice;
    JTextField roomNumber, name, paid, remaining;
    JButton check, update, back;
    UpdateInfo(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,50,450,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel("Update Info");
        text.setFont(new Font("Times New Roman",Font.BOLD,16));
        text.setBounds(200,40,130,25);

        JLabel customerID = new JLabel("Customer ID");
        customerID.setBounds(50,90,130,25);
        customerID.setFont(new Font("Times New Roman",Font.BOLD,15));

        customerChoice = new Choice();
        customerChoice.setBounds(200,90,150,25);

        try{
            DataBaseConnect con =  new DataBaseConnect();
            ResultSet rs = con.st.executeQuery("select * from customer");
            while(rs.next()){
                customerChoice.add(rs.getString("ID_number"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        JLabel lRoomNumber = new JLabel("Room Number");
        lRoomNumber.setBounds(50,140,130,25);
        lRoomNumber.setFont(new Font("Times New Roman",Font.BOLD,15));

        roomNumber = new JTextField();
        roomNumber.setBounds(200,140,150,25);
        roomNumber.setFont(new Font("Times New Roman",Font.BOLD,15));
        roomNumber.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        JLabel lName = new JLabel("Name");
        lName.setBounds(50,190,130,25);
        lName.setFont(new Font("Times New Roman",Font.BOLD,15));

        name = new JTextField();
        name.setBounds(200,190,150,25);
        name.setFont(new Font("Times New Roman",Font.BOLD,15));
        name.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        JLabel lPaid = new JLabel("Amount Paid");
        lPaid.setBounds(50,240,130,25);
        lPaid.setFont(new Font("Times New Roman",Font.BOLD,15));

        paid = new JTextField();
        paid.setBounds(200,240,150,25);
        paid.setFont(new Font("Times New Roman",Font.BOLD,15));
        paid.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        JLabel lRemaining = new JLabel("Remaining Amount");
        lRemaining.setBounds(50,290,130,25);
        lRemaining.setFont(new Font("Times New Roman",Font.BOLD,15));

        remaining = new JTextField();
        remaining.setBounds(200,290,150,25);
        remaining.setFont(new Font("Times New Roman",Font.BOLD,15));
        remaining.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        check = new JButton("Check");
        check.setBounds(50,370,100,25);
        check.setFont(new Font("Times New Roman",Font.BOLD,15));
        check.setBackground(Color.blue);
        check.setForeground(Color.white);
        check.setFocusable(false);
        check.addActionListener(this);

        update = new JButton("Update");
        update.setBounds(175,370,100,25);
        update.setFont(new Font("Times New Roman",Font.BOLD,15));
        update.setBackground(Color.blue);
        update.setForeground(Color.white);
        update.setFocusable(false);
        update.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(300,370,100,25);
        back.setFont(new Font("Times New Roman",Font.BOLD,15));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.addActionListener(this);


        add(check);
        add(update);
        add(back);
        add(lRemaining);
        add(remaining);
        add(lPaid);
        add(paid);
        add(name);
        add(lName);
        add(roomNumber);
        add(lRoomNumber);
        add(customerChoice);
        add(customerID);
        add(text);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==check){
            String id_number = customerChoice.getSelectedItem();
            String query = "select * from customer where ID_number = '"+id_number+"'";
            try{
                DataBaseConnect con = new DataBaseConnect();
                ResultSet rs = con.st.executeQuery(query);
                while(rs.next()){
                    roomNumber.setText(rs.getString("Room_Number"));
                    name.setText(rs.getString("Name"));
                    paid.setText(rs.getString("Deposite"));
                }

                ResultSet rs2 =  con.st.executeQuery("select * from room where roomNumber = '"+roomNumber.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int paidAmount = Integer.parseInt(price) - Integer.parseInt(paid.getText());
                    remaining.setText(""+paidAmount);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if (a.getSource()==update) {
            String id_number = customerChoice.getSelectedItem();
            String room = roomNumber.getText();
            String name1 = name.getText();
            String paid1 = paid.getText();
            String deposite1 = paid.getText();

            try {
                DataBaseConnect con = new DataBaseConnect();
                con.st.executeUpdate("update customer set Deposite = '" + deposite1 + "' where ID_number = '"+id_number+"'");
//                con.st.executeUpdate("update room set Room_Number = '" + room + "'");
//                con.st.executeUpdate("update customer set Name='" + name1 + "'");
                JOptionPane.showMessageDialog(null, "Data has been updated successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(a.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new UpdateInfo();
    }
}
