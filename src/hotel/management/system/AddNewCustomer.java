package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddNewCustomer extends JFrame implements ActionListener {
    JComboBox id;
    JTextField name, idNumberText, deposite;
    JRadioButton male, female;
    Choice choiceRoom;
    JButton add, back;

    AddNewCustomer (){
        setBounds(400,100,500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("New Customer Details");
        text.setFont(new Font("Times New Roman",Font.BOLD,17));
        text.setBounds(150,20,200,30);

        JLabel lname = new JLabel("Name:");
        lname.setFont(new Font("Times New Roman",Font.PLAIN,15));
        lname.setBounds(50,70,200,30);

        name = new JTextField();
        name.setFont(new Font("Times New Roman",Font.PLAIN,15));
        name.setBounds(150,70,200,30);
        name.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));


        JLabel lid = new JLabel("ID");
        lid.setFont(new Font("Times New Roman",Font.PLAIN,15));
        lid.setBounds(50,120,200,30);

        String[] cardOption = {"Passport", "Aadhaar Card", "Driving License", "Voter Id"};
        id = new JComboBox<>(cardOption);
        id.setBounds(150,120,200,30);
        id.setFont(new Font("Times New Roman",Font.PLAIN,15));
        id.setBackground(Color.white);
        id.setForeground(Color.black.darker());

        JLabel idNumber = new JLabel("ID Number");
        idNumber.setFont(new Font("Times New Roman",Font.PLAIN,15));
        idNumber.setBounds(50,170,200,30);

        idNumberText = new JTextField();
        idNumberText.setBounds(150,170,200,30);
        idNumberText.setBackground(Color.white);
        idNumberText.setForeground(Color.black.darker());
        idNumberText.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Times New Roman",Font.PLAIN,15));
        gender.setBounds(50,220,200,30);
        gender.setBackground(Color.white);
        gender.setForeground(Color.black.darker());

        male = new JRadioButton("Male");
        male.setFont(new Font("Times New Roman",Font.PLAIN,15));
        male.setBounds(150,220,100,30);
        male.setBackground(Color.white);
        male.setForeground(Color.black.darker());

        female = new JRadioButton("Female");
        female.setFont(new Font("Times New Roman",Font.PLAIN,15));
        female.setBounds(250,220,100,30);
        female.setBackground(Color.white);
        female.setForeground(Color.black.darker());

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        JLabel allocatedRoomNumber = new JLabel("Allocated Room Number");
        allocatedRoomNumber.setBounds(50,270,200,30);
        allocatedRoomNumber.setFont(new Font("Times New Roman",Font.PLAIN,15));
        allocatedRoomNumber.setBackground(Color.white);
        allocatedRoomNumber.setForeground(Color.black.darker());

        choiceRoom = new Choice();

        try{
            DataBaseConnect con =  new DataBaseConnect();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = con.st.executeQuery(query);
            while(rs.next()){
                choiceRoom.add(rs.getString("roomNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        choiceRoom.setBounds(250,275,100,30);
        choiceRoom.setBackground(Color.white);
        choiceRoom.setForeground(Color.black.darker());

        JLabel ldeposite =  new JLabel("Deposite");
        ldeposite.setBounds(50,320,200,30);
        ldeposite.setFont(new Font("Times New Roman",Font.PLAIN,15));
        ldeposite.setForeground(Color.black.darker());

        deposite = new JTextField();
        deposite.setBounds(150,320,200,30);
        deposite.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        deposite.setBackground(Color.white);
        deposite.setForeground(Color.black.darker());
        deposite.setFont(new Font("Times New Roman",Font.PLAIN,15));

        add =  new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white.darker());
        add.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add.setBounds(100,390,100,30);
        add.setFocusable(false);
        add.addActionListener(this);

        back =  new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white.darker());
        back.setFont(new Font("Times New Roman",Font.PLAIN,15));
        back.setBounds(250,390,100,30);
        back.setFocusable(false);
        back.addActionListener(this);


        add(back);
        add(add);
        add(deposite);
        add(ldeposite);
        add(choiceRoom);
        add(allocatedRoomNumber);
        add(gender);
        add(male);
        add(female);
        add(lname);
        add(name);
        add(idNumberText);
        add(idNumber);
        add(id);
        add(lid);
        add(text);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==add){
            String name1 = name.getText();
            String id1 = (String) id.getSelectedItem();
            String idNumber = idNumberText.getText();
            String gender1 = null;
            if(female.isSelected()){
                gender1 = "Female";
            } else {
                gender1 = "Male";
            }

            String roomNumber1 = choiceRoom.getSelectedItem();
            String deposite1 = deposite.getText();

            try{
                DataBaseConnect con =  new DataBaseConnect();

                String query = "insert into customer values ('"+name1+"','"+id1+"','"+idNumber+"', '"+gender1+"', '"+roomNumber1+"', '"+deposite1+"')";
                String query2 = "update room set availability = 'Occupied' where roomNumber = '"+roomNumber1+"'";

                con.st.executeUpdate(query);
                con.st.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception ee){
                ee.printStackTrace();
            }

        } else if (ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){

        new AddNewCustomer();
    }
}
