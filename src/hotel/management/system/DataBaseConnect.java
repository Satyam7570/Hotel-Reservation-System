package hotel.management.system;

import java.sql.*;

public class DataBaseConnect {
    Connection con;
    Statement st;
    DataBaseConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservationsystem", "root", "S@ty@m7275");
            st = con.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(){
        new DataBaseConnect();
    }
}
