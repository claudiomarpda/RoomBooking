package roombooking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DatabaseHelper {

    private static Connection mConnection;
    private static final String URL = "jdbc:mysql://localhost:3306/room_booking";
    ;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    private static final String PERSON = "person";
    private static final String CPF = "cpf";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String BIRTH = "birth";

    private static final String EMAIL = "email";
    private static final String EMAIL_ADDRESS = "address";

    private static final String PHONE = "phone";
    private static final String PHONE_NUMBER = "number";

    private static final String FLOOR = "floor";
    private static final String FLOOR_ID = "id_floor";
    private static final String FLOOR_DESCRIPTION = "description";

    private static final String ROOM_TYPE = "room_type";
    private static final String ROOM_TYPE_ID = "id_room_type";
    private static final String ROOM_TYPE_DESCRIPTION = "description";
    private static final String ROOM = "room";
    
    
    private static final String USER_TYPE = "user_type";
    private static final String USER = "user";

    private PreparedStatement addPersonStatement;
    private PreparedStatement addEmailStatement;
    private PreparedStatement addPhoneStatement;
    private PreparedStatement addFloorStatement;
    private PreparedStatement addRoomTypeStatement;

    public DatabaseHelper() {
        connect();
    }

    public void connect() {
        if (mConnection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                mConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Connected to MySQL server.");
        } else {
            System.out.println("The connection is already running.");
        }

        setPersonQueries();
        setEmailQueries();
        setPhoneQueries();
        setFloorQueries();
        setRoomTypeQueries();
    }

    public void closeConnection() {
        if (mConnection != null) {
            try {
                mConnection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Connection to MySQL server closed.");
        } else {
            System.out.println("There is no connection to be closed.");
        }
    }

    private void setPersonQueries() {
        try {
            addPersonStatement = mConnection.prepareStatement(
                    "INSERT INTO " + PERSON
                    + "(" + CPF + ", " + NAME + ", " + GENDER + ", " + BIRTH + ")"
                    + "VALUES (?, ?, ?, ?)");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPerson(String cpf, String name, char gender, String birth) {
        try {
            addPersonStatement.setString(1, cpf);
            addPersonStatement.setString(2, name);
            addPersonStatement.setString(3, String.valueOf(gender));
            addPersonStatement.setDate(4, Date.valueOf(birth));

            addPersonStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addPerson successful.");
    }

    private void setEmailQueries() {
        try {
            addEmailStatement = mConnection.prepareStatement(
                    "INSERT INTO " + EMAIL
                    + "(" + CPF + ", " + EMAIL_ADDRESS + ")"
                    + "VALUES (?, ?)");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addEmail(String cpf, String emailAddress) {
        try {
            addEmailStatement.setString(1, cpf);
            addEmailStatement.setString(2, emailAddress);

            addEmailStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addPhone successful.");
    }

    private void setPhoneQueries() {
        try {
            addPhoneStatement = mConnection.prepareStatement(
                    "INSERT INTO " + PHONE
                    + "(" + CPF + ", " + PHONE_NUMBER + ")"
                    + "VALUES (?, ?)");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPhone(String cpf, String phoneNumber) {
        try {
            addPhoneStatement.setString(1, cpf);
            addPhoneStatement.setString(2, phoneNumber);

            addPhoneStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addEmail successful.");
    }

    private void setFloorQueries() {
        try {
            addFloorStatement = mConnection.prepareStatement(
                    "INSERT INTO " + FLOOR
                    + "(" + FLOOR_ID + ", " + FLOOR_DESCRIPTION + ")"
                    + "VALUES (?, ?)");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addFloor(int floorID, String description) {
        try {
            addFloorStatement.setInt(1, floorID);
            addFloorStatement.setString(2, description);

            addFloorStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addFloor successful.");
    }

    private void setRoomTypeQueries() {
        try {
            addRoomTypeStatement = mConnection.prepareStatement(
                    "INSERT INTO " + ROOM_TYPE
                    + "(" + ROOM_TYPE_ID + ", " + ROOM_TYPE_DESCRIPTION + ")"
                    + "VALUES (?, ?)");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addRoomType(String roomTypeID, String description) {
        try {
            addRoomTypeStatement.setString(1, roomTypeID);
            addRoomTypeStatement.setString(2, description);

            addRoomTypeStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addRoomType successful.");
    }
}
