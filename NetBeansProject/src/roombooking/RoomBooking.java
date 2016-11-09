package roombooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * This class is used for test cases. All methods are executed after written.
 *
 * @author Claudiomar Araújo
 * @author Jonathan Rodrigues
 */
public class RoomBooking {

    public static void main(String[] args) throws KeyNotFoundException, KeyExistsException {
        DatabaseHelper mDatabaseHelper = new DatabaseHelper();

        /**
         * ********** Database operations tests ***********
         */
        //mDatabaseHelper.addPerson("33333333333", "Jonathan", 'M', "1994-01-01");
        //mDatabaseHelper.addEmail("11111111111", "th@email.com");
        //mDatabaseHelper.addPhone("11111111111", "+55 083 91111-2222");
        //mDatabaseHelper.addFloor(0, "Térreo");
        //mDatabaseHelper.addRoomType("AUL", "Aula");
        //mDatabaseHelper.addUserType(2, "Aluno");
        //mDatabaseHelper.addUser("2015000000", "22222222222", 2);
        //mDatabaseHelper.addUser("20163", "55555555555", 2, "jonathan@gmail.com", 
        //    "083 9 2222-1111", "Jonathan", 'M', "1994-01-01");
        //mDatabaseHelper.addRoom("LAB-102", "LAB", 1, 60, 0, 30);
        // mDatabaseHelper.removePerson("22222222222");
        //mDatabaseHelper.addBooking("2016111111", "LAB-101", "Monitoria Banco de Dados I", 10, "2016-11-01 02:00 PM");
        //mDatabaseHelper.removePerson("22222222222");
        //mDatabaseHelper.removeUser("22222222222");
        //mDatabaseHelper.removeEmail("11111111111");
        //mDatabaseHelper.removeEmail("22222222222");
        //mDatabaseHelper.removeBooking(1);
        //mDatabaseHelper.removePhone("22222222222");
        //mDatabaseHelper.removeFloor(0);
        //mDatabaseHelper.addUserType(3, "Funcionário Admin");
        //mDatabaseHelper.removeUserType(3);
        //mDatabaseHelper.removeRoomType("AUL");
        //mDatabaseHelper.addRoom("AUD-001", "AUD", 1, 60, 1, 0);
        // mDatabaseHelper.addRoomType("AUD", "Auditório");
        //mDatabaseHelper.removeRoom("AUD-001");
        //mDatabaseHelper.printSelectEverythingFromPerson();
        //System.out.println(mDatabaseHelper.userExists("2016000000"));
        //mDatabaseHelper.updatePerson("55555555555", p);
        /**
         * ********** Classes instance tests ***********
         */
        /*        
        User p = new User("20160", 2, "Aluno", "00000000000", "Rodrigo", 'M', java.sql.Date.valueOf("1995-01-01"), 
                "083 9 0000-1111", "r@gmail.com");
        System.out.println(p.toString());
        
        Room r = new Room(1, "Primeiro andar", "LAB", "Laboratório", "LAB-102", 60, true, 30);
        System.out.println(r.toString());
        
        // bookingID is autoincrement. 
        // Therefore, it has to be gotten from an existing value from table
        Booking b = new Booking(2, "2016111111", "LAB-101", "To Rule The World", 15);
        System.out.println(b.toString());
        
         */
        /**
         * ********** READ operations ***********
         */
        /*        
        List<User> allUsers = mDatabaseHelper.getAllUsers();
        for (User u : allUsers) {
            System.out.println(u.toString());System.out.println("");
        }
         
 
        User u = mDatabaseHelper.getUserByCPF("55555555555");
        if(u != null)
            System.out.println(u.toString());
         
 
        User u2 = mDatabaseHelper.getUserByID("2016000000");
        if (u2 != null) {
            System.out.println(u2.toString());
        }
         */
 /*
        List<Room> roomList = mDatabaseHelper.getAllRooms();
        for (Room r : roomList) {
            System.out.println(r.toString());
        }
        System.out.println();
        List<Room> roomList2 = mDatabaseHelper.getAllRoomsByType("LAB");
        for (Room r : roomList2) {
            System.out.println(r.toString());
        }
         */
 /*
        List<Booking> bList = mDatabaseHelper.getAllBookings();
        for (Booking b : bList) {
            System.out.println(b.toString());
            System.out.println(mDatabaseHelper.bookingExists(b.getRoomID(), b.getTimeStamp().toString()));
        }
        
        List<Booking> bList2 = mDatabaseHelper.getBookingsByUserID("2016111111");
        for (Booking b : bList2) {
           // System.out.println(b.toString());
        }
       
        
        System.out.println(mDatabaseHelper.bookingExists("LAB-101", "2016-11-01 14:00:00"));
        
         */
 
 
        //mDatabaseHelper.addUser("20169", "99999999999", 2, "admin@gmail.com", "083 9 9999-9999", "Administrador", 'M', "2000-01-01", "123");
        /* 
         (String userID, String cpf, int userTypeID, String emailAddress,
             String phoneNumber, String name, char gender, String birth, String password)
         */
        mDatabaseHelper.closeConnection();
        //dateTest();
    }

    /**
     * For reference and test of java.sql.Date and java.util.Date.
     */
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
            final java.util.Date dateObj = sdf2.parse(s);
            System.out.println(dateObj);
            System.out.println(new SimpleDateFormat("K:mm:ss aa").format(dt));

            java.sql.Date dsql = java.sql.Date.valueOf("2016-12-12");
            System.out.println(dsql);
        } catch (ParseException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 2016-11-01 02:00 PM
    }

}
