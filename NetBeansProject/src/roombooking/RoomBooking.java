package roombooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomBooking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        connectionTest();
        //dateTest();
    }
    
     public static void connectionTest() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            final String url = "jdbc:mysql://localhost:3306/room_booking";
            final String username = "root";
            final String password = "mysql";
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected to MySQL server.");
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void dateTest(){
        java.util.Date dt = new java.util.Date();
        System.out.println(dt.toString());
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd KK:mm:ss aa");
        
        String currentTime = sdf.format(dt);
        System.out.println(currentTime);
        
        
        String s = "14:35:59";
        final SimpleDateFormat sdf2 = new SimpleDateFormat("H:mm");
        try {
            final Date dateObj = sdf2.parse(s);
            System.out.println(dateObj);
            System.out.println(new SimpleDateFormat("K:mm:ss aa").format(dt));
        } catch (ParseException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
