package roombooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomBooking {

    public static void main(String[] args) {
        DatabaseHelper mDatabaseHelper = new DatabaseHelper();
        //mDatabaseHelper.addPerson("33333333333", "Jonathan", 'M', "1994-01-01");
        //mDatabaseHelper.addEmail("11111111111", "th@email.com");
        //mDatabaseHelper.addPhone("11111111111", "+55 083 91111-2222");
        //mDatabaseHelper.addFloor(0, "Térreo");
        //mDatabaseHelper.addRoomType("AUL", "Aula");
        mDatabaseHelper.closeConnection();
        //dateTest();
    }

    public static void dateTest() {
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

            
            
            java.sql.Date dsql = java.sql.Date.valueOf("2016-12-12");
            System.out.println(dsql);
        } catch (ParseException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
