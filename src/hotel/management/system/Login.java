package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField jPassword;
    JButton login, cancel;
    Login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setBounds(70,70,1144,600);
        setLayout(null);

        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("icons/LoginBackground.jpg"));
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, 1144, 600);

        JLabel user = new  JLabel("Username");
        user.setFont(new Font("serif",Font.BOLD,20));
        user.setBounds(290,100,150,27);

        username = new JTextField();
        username.setBounds(400,100,150,30);

        JLabel password = new  JLabel("Password");
        password.setFont(new Font("serif",Font.BOLD,20));
        password.setBounds(290,160,100,27);

        jPassword = new JPasswordField();
        jPassword.setBounds(400,160,150,30);


        login = new JButton("Login");
        login.setForeground(Color.WHITE);
        login.setBackground(Color.black);
        login.setFocusable(false);
        login.setBounds(290,240,110,31);
        login.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.setFocusable(false);
        cancel.setBounds(440,240,110,31);
        cancel.addActionListener(this);

        add(label);
        label.add(user);
        label.add(login);
        label.add(cancel);
        label.add(jPassword);
        label.add(username);
        label.add(password);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            String username1 = username.getText();
            String password1 = jPassword.getText();
            try{
                DataBaseConnect con = new DataBaseConnect();
                String query = "select * from login where username = '"+ username1+ "' and jPassword = '"+password1+ "'";
                ResultSet rs = con.st.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
