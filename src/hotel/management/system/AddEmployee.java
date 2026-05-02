package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField name, age, salary, email, adhaar;
    JButton submit;
    JRadioButton lmale,lfemale;
    JComboBox<String> job;

    AddEmployee(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(370,200,550,520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lname = new JLabel("NAME");
        lname.setBounds(50,30,120,30);
        lname.setFont(new Font("Times New Roman",Font.PLAIN,15));

        name = new JTextField();
        name.setBounds(200,30,190,30);
        name.setFont(new Font("Times New Roman",Font.PLAIN,15));
        name.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));

        JLabel lage = new JLabel("AGE");
        lage.setBounds(50,80,120,30);
        lage.setFont(new Font("Times New Roman",Font.PLAIN,15));

        age = new JTextField();
        age.setBounds(200,80,190,30);
        age.setFont(new Font("Times New Roman",Font.PLAIN,15));
        age.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));

        JLabel lgender = new JLabel("GENDER");
        lgender.setBounds(50,130,120,30);
        lgender.setFont(new Font("Times New Roman",Font.PLAIN,15));

        lmale = new JRadioButton("Male");
        lmale.setBounds(195,130,70,30);
        lmale.setFont(new Font("Times New Roman",Font.PLAIN,14));
        lmale.setBackground(Color.white);

        lfemale = new JRadioButton("Female");
        lfemale.setBounds(290,130,70,30);
        lfemale.setBackground(Color.white);
        lfemale.setFont(new Font("Times New Roman",Font.PLAIN,14));

        ButtonGroup group = new ButtonGroup();
        group.add(lmale);
        group.add(lfemale);

        JLabel ljob = new JLabel("JOB");
        ljob.setBounds(50,170,120,30);
        ljob.setFont(new Font("Times New Roman",Font.PLAIN,15));

        String[] jobType = {"Frontend Developer", "Backend Developer", "UI/UX Developer", "Android Developer", "Desktop Software Developer", "Testing Engineer", "Cloud Engineer", "Java Full Stack Developer", "MERN Stack Developer", "Web Developer"};
        job = new JComboBox(jobType);
        job.setBounds(200,170,190,30);
        job.setFont(new Font("Times New Roman",Font.PLAIN,14));
        job.setBackground(Color.black);
        job.setForeground(Color.white);

        JLabel lsalary = new JLabel("Salary");
        lsalary.setBounds(50,220,120,30);
        lsalary.setFont(new Font("Times New Roman",Font.PLAIN,15));

        salary = new JTextField();
        salary.setBounds(200,220,190,30);
        salary.setFont(new Font("Times New Roman",Font.PLAIN,15));
        salary.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));

        JLabel lemail = new JLabel("Email");
        lemail.setBounds(50,270,120,30);
        lemail.setFont(new Font("Times New Roman",Font.PLAIN,15));

        email = new JTextField();
        email.setBounds(200,270,190,30);
        email.setFont(new Font("Times New Roman",Font.PLAIN,15));
        email.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));

        JLabel ladhaar = new JLabel("Adhaar");
        ladhaar.setBounds(50,320,120,30);
        ladhaar.setFont(new Font("Times New Roman",Font.PLAIN,15));

        adhaar = new JTextField();
        adhaar.setBounds(200,320,190,30);
        adhaar.setFont(new Font("Times New Roman",Font.PLAIN,15));
        adhaar.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));

        submit = new JButton("Submit");
        submit.setBounds(200,380,190,30);
        submit.setFocusable(false);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);



        add(ladhaar);
        add(adhaar);
        add(submit);
        add(lemail);
        add(email);
        add(lsalary);
        add(salary);
        add(job);
        add(ljob);
        add(lmale);
        add(lfemale);
        add(lgender);
        add(lage);
        add(age);
        add(name);
        add(lname);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String name1 = name.getText();
        String age1 = age.getText();
        String salary1 = salary.getText();
        String email1 = email.getText();
        String adhaar1 = adhaar.getText();
        String gender1 = null;

//        if(name1.equals("")){
//            JOptionPane.showMessageDialog(null, "Name cannot be empty");
//            return;
//        }
//        if(age1.equals("")){
//            JOptionPane.showMessageDialog(null, "Age cannot be empty");
//            return;
//        }
//        if(salary1.equals("")){
//            JOptionPane.showMessageDialog(null, "Salary cannot be empty");
//            return;
//        }
//        if(email1.equals("")){
//            JOptionPane.showMessageDialog(null, "Email cannot be empty");
//            return;
//        }
//        if(adhaar1.equals("")){
//            JOptionPane.showMessageDialog(null, "Adhaar cannot be empty");
//            return;
//        }
//        if(gender1.equals("")){
//            JOptionPane.showMessageDialog(null, "Gender cannot be empty");
//            return;
//        }
//        if(salary1.equals("")){
//            JOptionPane.showMessageDialog(null, "Salary cannot be empty");
//            return;
//        }
//        if(email1.equals("")){
//            JOptionPane.showMessageDialog(null, "Email cannot be empty");
//            return;
//        }
//        if(adhaar1.equals("")){
//            JOptionPane.showMessageDialog(null, "Adhaar cannot be empty");
//            return;
//        }


        if(lmale.isSelected()){
            gender1 = "Male";
        } else if(lfemale.isSelected()){
            gender1 = "Female";
        }

        String job1 = (String) job.getSelectedItem();

        try {
            DataBaseConnect con = new DataBaseConnect();

            String query = "insert into employee values('"+name1+"', '"+age1+"', '"+gender1+"', '"+job1+"', '"+salary1+"', '"+email1+"', '"+adhaar1+"')";

            con.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee has been added successfully");
            setVisible(false);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
