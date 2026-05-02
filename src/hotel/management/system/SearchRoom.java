package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox bed_Type;
    JCheckBox available;
    JTable table;
    JScrollPane scroll;
    JButton search, back;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(250,50,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel searchRoom = new JLabel("Search For Room");
        searchRoom.setBounds(320,10,250,30);
        searchRoom.setFont(new Font("Times New Roman",Font.BOLD,20));

        JLabel lBedType = new JLabel("Bed Type");
        lBedType.setBounds(50,60,250,30);
        lBedType.setFont(new Font("Times New Roman",Font.PLAIN,18));

        bed_Type =  new JComboBox(new String[]{"Single Bed","Double Bed"});
        bed_Type.setBounds(150,60,120,25);
        bed_Type.setBackground(Color.WHITE);

        available = new JCheckBox("Available");
        available.setBounds(550,60,130,25);
        available.setFont(new Font("Times New Roman",Font.PLAIN,16));
        available.setBackground(Color.WHITE);

        table = new JTable();
        table.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN,15));
        scroll = new JScrollPane(table);
        scroll.setBounds(0,120,800,250);

        try{
            DataBaseConnect con =  new DataBaseConnect();
            ResultSet rs = con.st.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setFocusable(false);
        search.setBounds(250, 400, 100, 30);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);

        back = new JButton("Back");
        back.setFocusable(false);
        back.setBounds(400, 400, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);


        add(search);
        add(back);
        add(scroll);
        add(available);
        add(bed_Type);
        add(lBedType);
        add(searchRoom);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==search){
            try{
                String query1 = "select * from room where bedType = '"+bed_Type.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'available' and bedType = '"+bed_Type.getSelectedItem()+"'";
                DataBaseConnect con =  new DataBaseConnect();
                ResultSet rs;
                if(available.isSelected()){
                    rs = con.st.executeQuery(query2);
                } else {
                    rs = con.st.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
