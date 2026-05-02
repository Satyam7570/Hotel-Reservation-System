package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    JButton addroom, cancel;
    JTextField roomNumber, price;
    JComboBox<String> bedType, availability;
    AddRoom(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(370,200,500,400);

       JLabel heading = new JLabel("Add Room");
       heading.setFont(new Font("Times New Roman",Font.BOLD,20));
       heading.setBounds(180,40,200,20);

       JLabel lRoomNumber = new JLabel("Room Number");
       lRoomNumber.setBounds(50,100,150,20);
       lRoomNumber.setFont(new Font("Times New Roman",Font.PLAIN,17));

       roomNumber = new JTextField();
       roomNumber.setBounds(200,100,200,20);
       roomNumber.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));

       JLabel lAvailability = new JLabel("Availability");
       lAvailability.setBounds(50,150,200,20);
       lAvailability.setFont(new Font("Times New Roman",Font.PLAIN,17));

       String[] availabilityOption = {"Available","Not Available"};
       availability = new JComboBox<>(availabilityOption);
       availability.setBounds(200,148,200,30);
       availability.setFont(new Font("Times New Roman",Font.PLAIN,15));
       availability.setBackground(Color.WHITE);

       JLabel lBedType = new JLabel("Bed Type");
       lBedType.setBounds(50,200,200,20);
       lBedType.setFont(new Font("Times New Roman",Font.PLAIN,17));

       String[] type = {"Single Bed", "Double Bed"};
       bedType = new JComboBox<>(type);
       bedType.setBounds(200,198,200,30);
       bedType.setFont(new Font("Times New Roman",Font.PLAIN,15));
       bedType.setBackground(Color.WHITE);

       JLabel lprice = new JLabel("Price");
       lprice.setBounds(50,250,200,20);
       lprice.setFont(new Font("Times New Roman",Font.PLAIN,15));

       price = new JTextField();
       price.setBounds(200,250,200,20);
       price.setFont(new Font("Times New Roman",Font.PLAIN,17));
       price.setBackground(Color.WHITE);
       price.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));

       addroom = new JButton("Add Room");
       addroom.setBounds(50,300,150,32);
       addroom.setBackground(Color.black);
       addroom.setForeground(Color.white);
       addroom.setFocusable(false);
       addroom.addActionListener(this);

       cancel = new JButton("Cancel");
       cancel.setBounds(250,300,150,33);
       cancel.setBackground(Color.black);
       cancel.setForeground(Color.white);
       cancel.setFocusable(false);
       cancel.addActionListener(this);


       add(cancel);
       add(addroom);
       add(lprice);
       add(price);
       add(lBedType);
       add(bedType);
       add(availability);
       add(lAvailability);
       add(roomNumber);
       add(lRoomNumber);
       add(heading);
       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==addroom){
            String roomnumber1 = roomNumber.getText();
            String availabilityroom1 = (String) availability.getSelectedItem();
            String typ = (String) bedType.getSelectedItem();
            String cost = price.getText();

            try{
                DataBaseConnect con = new DataBaseConnect();
                String query = "insert into room values('"+roomnumber1+"', '"+availabilityroom1+"', '"+typ+"', '"+cost+"')";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");

                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddRoom();
    }
}
