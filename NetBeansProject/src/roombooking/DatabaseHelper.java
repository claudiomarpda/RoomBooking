package roombooking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *
 *
 * @author Claudiomar Araújo
 * @author Jonathan Rodrigues
 *
 * DatabaseHelper provides CRUD operations in a MySQL database. This class is
 * easily understood after checking the documentation. Therefore, we avoid to
 * pollute the code with unnecessary information in comments. For details about
 * the database, see the database design in the documentation. For details about
 * the whole project, see the Requirements Specification in the documentation.
 */
public final class DatabaseHelper {

    private static Connection mConnection;
    private static final String URL = "jdbc:mysql://localhost:3306/room_booking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";
    private static final String MY_DATE_FORMAT = "%Y-%m-%d %h:%i %p"; // Format for MySQL

    // ------------ Constant variables of the tables ------------
    // Person table 
    private static final String PERSON = "person";
    private static final String CPF = "cpf"; // Cadastro de Pessoa Física
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String BIRTH = "birth";

    // Email table
    private static final String EMAIL = "email";
    private static final String EMAIL_ADDRESS = "address";

    // Phone table
    private static final String PHONE = "phone";
    private static final String PHONE_NUMBER = "number";

    // UserType table
    private static final String USER_TYPE = "user_type";
    private static final String USER_TYPE_ID = "id_user_type";
    private static final String USER_TYPE_DESCRIPTION = "description";

    // User table
    private static final String USER = "user";
    private static final String USER_ID = "id_user";

    // Floor table
    private static final String FLOOR = "floor";
    private static final String FLOOR_ID = "id_floor";
    private static final String FLOOR_DESCRIPTION = "description";

    // RoomType table
    private static final String ROOM_TYPE = "room_type";
    private static final String ROOM_TYPE_ID = "id_room_type";
    private static final String ROOM_TYPE_DESCRIPTION = "description";

    // Room table
    private static final String ROOM = "room";
    private static final String ROOM_ID = "id_room";
    private static final String ROOM_CAPACITY = "capacity";
    private static final String HAS_PROJECTOR = "has_projector";
    private static final String NUM_COMPUTERS = "num_computers";

    // Booking table
    private static final String BOOKING = "booking";
    private static final String GOAL = "goal";
    private static final String NUM_PEOPLE = "num_people";
    private static final String DATE_TIME = "date_time";

    // ------------ Queries variables ------------
    // Insert queries
    private PreparedStatement addPersonStatement;
    private PreparedStatement addEmailStatement;
    private PreparedStatement addPhoneStatement;
    private PreparedStatement addUserTypeStatement;
    private PreparedStatement addUserStatement;
    private PreparedStatement addFloorStatement;
    private PreparedStatement addRoomTypeStatement;
    private PreparedStatement addRoomStatement;
    private PreparedStatement addBookingStatement;

    // Remove queries
    private PreparedStatement rmPersonStatement;

    /**
     * Constructor connects to the database and initializes PreparedStatement
     * for queries handling.
     */
    public DatabaseHelper() {
        connect();
        try {
            setPersonQueries();
            setEmailQueries();
            setPhoneQueries();
            setFloorQueries();
            setRoomTypeQueries();
            setUserTypeQueries();
            setUserQueries();
            setRoomQueries();
            setBookingQueries();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Connects to the MySQL database according to URL, USERNAME and, PASSWORD.
     */
    public void connect() {
        if (mConnection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                mConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Connected to MySQL server.");
        } else {
            System.out.println("The connection is already running.");
        }
    }

    /**
     * Closes the connection to the MySQL database.
     */
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

    // ---------------- Start of QUERIES declarations ----------------
    private void setPersonQueries() throws SQLException {
        addPersonStatement = mConnection.prepareStatement(
                "INSERT INTO " + PERSON
                + "(" + CPF + ", " + NAME + ", " + GENDER + ", " + BIRTH + ")"
                + "VALUES (?, ?, ?, ?)");

        rmPersonStatement = mConnection.prepareStatement(
                "DELETE FROM " + PERSON
                + " WHERE " + CPF + " = ?");
    }

    private void setPhoneQueries() throws SQLException {
        addPhoneStatement = mConnection.prepareStatement(
                "INSERT INTO " + PHONE
                + "(" + CPF + ", " + PHONE_NUMBER + ")"
                + "VALUES (?, ?)");
    }

    private void setEmailQueries() throws SQLException {
        addEmailStatement = mConnection.prepareStatement(
                "INSERT INTO " + EMAIL
                + "(" + CPF + ", " + EMAIL_ADDRESS + ")"
                + "VALUES (?, ?)");
    }

    private void setUserTypeQueries() throws SQLException {
        addUserTypeStatement = mConnection.prepareStatement(
                "INSERT INTO " + USER_TYPE
                + "(" + USER_TYPE_ID + ", " + USER_TYPE_DESCRIPTION + ")"
                + "VALUES (?, ?)");
    }

    private void setUserQueries() throws SQLException {
        addUserStatement = mConnection.prepareStatement(
                "INSERT INTO " + USER
                + "(" + USER_ID + ", " + CPF + "," + USER_TYPE + ")"
                + "VALUES (?, ?, ?)");
    }

    private void setFloorQueries() throws SQLException {
        addFloorStatement = mConnection.prepareStatement(
                "INSERT INTO " + FLOOR
                + "(" + FLOOR_ID + ", " + FLOOR_DESCRIPTION + ")"
                + "VALUES (?, ?)");
    }

    private void setRoomTypeQueries() throws SQLException {
        addRoomTypeStatement = mConnection.prepareStatement(
                "INSERT INTO " + ROOM_TYPE
                + "(" + ROOM_TYPE_ID + ", " + ROOM_TYPE_DESCRIPTION + ")"
                + "VALUES (?, ?)");
    }

    private void setRoomQueries() throws SQLException {
        addRoomStatement = mConnection.prepareStatement(
                "INSERT INTO " + ROOM
                + "(" + ROOM_ID + ", " + ROOM_TYPE + ", " + FLOOR + ", "
                + ROOM_CAPACITY + ", " + HAS_PROJECTOR + ", " + NUM_COMPUTERS + ")"
                + "VALUES (?, ?, ?, ?, ?, ?)");
    }

    private void setBookingQueries() throws SQLException {
        addBookingStatement = mConnection.prepareStatement(
                "INSERT INTO " + BOOKING
                + "(" + USER + ", " + ROOM + ", "
                + GOAL + ", " + NUM_PEOPLE + ", " + DATE_TIME + ")"
                + "VALUES (?, ?, ?, ?, STR_TO_DATE(?, '" + MY_DATE_FORMAT + "') )");
        //+ "VALUES (?, ?, ?, ?, ?))");
    }

    // ---------------- Start of CREATE methods ----------------
    /**
     * Creates an new person in Person table.
     */
    private void addPerson(String cpf, String name, char gender, String birth) {
        try {
            addPersonStatement.setString(1, cpf);
            addPersonStatement.setString(2, name);
            addPersonStatement.setString(3, String.valueOf(gender));
            addPersonStatement.setDate(4, Date.valueOf(birth));

            //addPersonStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addPerson successful.");
    }

    /**
     * Creates an new email in Email table.
     */
    private void addEmail(String cpf, String emailAddress) {
        try {
            addEmailStatement.setString(1, cpf);
            addEmailStatement.setString(2, emailAddress);

            //addEmailStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addPhone successful.");
    }

    /**
     * Creates an new phone in Phone table.
     */
    private void addPhone(String cpf, String phoneNumber) {
        try {
            addPhoneStatement.setString(1, cpf);
            addPhoneStatement.setString(2, phoneNumber);

            //addPhoneStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addEmail successful.");
    }

    /**
     * Creates an new user type in UserType table.
     */
    public void addUserType(int userTypeID, String description) {
        try {
            addUserTypeStatement.setInt(1, userTypeID);
            addUserTypeStatement.setString(2, description);

            addUserTypeStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addFloor successful.");
    }

    /**
     * Creates an new user in User table.
     */
    private void addUser(String userID, String cpf, int userTypeID) {
        try {
            addUserStatement.setString(1, userID);
            addUserStatement.setString(2, cpf);
            addUserStatement.setInt(3, userTypeID);

            //addUserStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addUser successful.");
    }

    /**
     * Creates an new user, a person, an email and a phone in their respective
     * tables.
     */
    public void addNewUser(String userID, String cpf, int userTypeID, String emailAddress,
            String phoneNumber, String name, char gender, String birth) {

        // TODO
        //add cpf existence verification before trying to insertS
        addPerson(cpf, name, gender, birth);
        addEmail(cpf, emailAddress);
        addPhone(cpf, phoneNumber);
        addUser(userID, cpf, userTypeID);

        try {
            addPersonStatement.executeUpdate();
            addEmailStatement.executeUpdate();
            addPhoneStatement.executeUpdate();
            addUserStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a new floor in Floor table.
     */
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

    /**
     * Creates a new room type in RoomType table.
     */
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

    /**
     * Creates a new room in Room table.
     */
    public void addRoom(String roomID, String roomType, int floorID, int capacity,
            int hasProjector, int numberOfComputers) {
        try {
            addRoomStatement.setString(1, roomID);
            addRoomStatement.setString(2, roomType);
            addRoomStatement.setInt(3, floorID);
            addRoomStatement.setInt(4, capacity);
            addRoomStatement.setInt(5, hasProjector);
            addRoomStatement.setInt(6, numberOfComputers);

            addRoomStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addRoom successful.");
    }

    /**
     * Creates a new booking in Booking table.
     */
    public void addBooking(String userID, String roomID, String goal, int numberOfPeople,
            String dateTime) {

        // TODO
        // verify before inserting in the table in order to 
        // avoid more than one booking at the same time
        try {
            addBookingStatement.setString(1, userID);
            addBookingStatement.setString(2, roomID);
            addBookingStatement.setString(3, goal);
            addBookingStatement.setInt(4, numberOfPeople);
            addBookingStatement.setString(5, dateTime);

            addBookingStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addBooking successful.");
    }

// ---------------- Start of DELETE methods ---------------- 
    public void removePerson(String cpf) {
        try {
            rmPersonStatement.setString(1, cpf);
            rmPersonStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
