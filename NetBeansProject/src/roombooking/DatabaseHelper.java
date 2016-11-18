package roombooking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * DatabaseHelper provides CRUD operations in a MySQL database. This class is
 * easily understood after checking the documentation. Therefore, we write
 * comments only when necessary. For details about the database, see the
 * database design in the documentation. For details about the whole project,
 * see the Requirements Specification in the documentation.
 */
public final class DatabaseHelper {

    private Connection mConnection;
    private static final String URL = "jdbc:mysql://localhost:3306/room_booking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";
    private static final String MY_DATE_FORMAT = "%Y-%m-%d %h:%i %p"; // Format for MySQL

    // ------------ Constant variables of the tables ------------
    private static final String ACTIVE = "active";

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
    private static final String USER_PASSWORD = "password";

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
    private static final String BOOKING_ID = "id_booking";
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
    private PreparedStatement rmEmailStatement;
    private PreparedStatement rmPhoneStatement;
    private PreparedStatement rmUserTypeStatement;
    private PreparedStatement rmUserStatement;
    private PreparedStatement rmFloorStatement;
    private PreparedStatement rmRoomTypeStatement;
    private PreparedStatement rmRoomStatement;
    private PreparedStatement rmBookingStatement;

    // Update queries
    private PreparedStatement upPersonStatement;
    private PreparedStatement upUserStatement;
    private PreparedStatement upPhoneStatement;
    private PreparedStatement upEmailStatement;
    private PreparedStatement upBookingStatement;
    private PreparedStatement upRoomStatement;
    private PreparedStatement upFloorStatement;
    private PreparedStatement upRoomTypeStatement;
    private PreparedStatement upUserTypeStatement;

    // Read queries
    private PreparedStatement readUserByCPFStatement;
    private PreparedStatement readUserByIDStatement;
    private PreparedStatement readAllUsersStatement;
    private PreparedStatement readAllRoomsStatement;
    private PreparedStatement readRoomsByTypeStatement;
    private PreparedStatement readRoomByIDStatement;
    private PreparedStatement readAllBookingsStatement;
    private PreparedStatement readBookingsByUserIDStatement;
    private PreparedStatement readUsersLikeStatement;

    private PreparedStatement checkUserExistence;
    private PreparedStatement checkBookingExistence;

    private PreparedStatement activationUserStatement;
    private PreparedStatement activationRoomStatement;

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

    /*
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

    /*
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

        upPersonStatement = mConnection.prepareStatement(
                "UPDATE " + PERSON + " SET "
                + CPF + " = ?, "
                + NAME + " = ?, "
                + GENDER + " = ?, "
                + BIRTH + " = ? "
                + "WHERE " + CPF + " = ?"
        );

    }

    private void setPhoneQueries() throws SQLException {
        addPhoneStatement = mConnection.prepareStatement(
                "INSERT INTO " + PHONE
                + "(" + CPF + ", " + PHONE_NUMBER + ")"
                + "VALUES (?, ?)");

        rmPhoneStatement = mConnection.prepareStatement(
                "DELETE FROM " + PHONE
                + " WHERE " + CPF + " = ?");

        upPhoneStatement = mConnection.prepareStatement(
                "UPDATE " + PHONE + " SET "
                //+ CPF + " = ?, "
                + PHONE_NUMBER + " = ? "
                + "WHERE " + CPF + " = ?"
        );
    }

    private void setEmailQueries() throws SQLException {
        addEmailStatement = mConnection.prepareStatement(
                "INSERT INTO " + EMAIL
                + "(" + CPF + ", " + EMAIL_ADDRESS + ")"
                + "VALUES (?, ?)");

        rmEmailStatement = mConnection.prepareStatement(
                "DELETE FROM " + EMAIL
                + " WHERE " + CPF + " = ?");

        upEmailStatement = mConnection.prepareStatement(
                "UPDATE " + EMAIL + " SET "
                //+ CPF + " = ?, "
                + EMAIL_ADDRESS + " = ? "
                + "WHERE " + CPF + " = ?"
        );
    }

    private void setUserTypeQueries() throws SQLException {
        addUserTypeStatement = mConnection.prepareStatement(
                "INSERT INTO " + USER_TYPE
                + "(" + USER_TYPE_ID + ", " + USER_TYPE_DESCRIPTION + ")"
                + "VALUES (?, ?)"
        );

        rmUserTypeStatement = mConnection.prepareStatement(
                "DELETE FROM " + USER_TYPE
                + " WHERE " + USER_TYPE_ID + " = ?"
        );

        upUserTypeStatement = mConnection.prepareStatement(
                "UPDATE " + USER_TYPE + " SET "
                + USER_TYPE_DESCRIPTION + " = ? "
                + "WHERE " + USER_TYPE_ID + " = ?"
        );
    }

    private void setUserQueries() throws SQLException {
        addUserStatement = mConnection.prepareStatement(
                "INSERT INTO " + USER
                + "(" + USER_ID + ", " + CPF + "," + USER_TYPE + "," + USER_PASSWORD + ", " + ACTIVE + ")"
                + "VALUES (?, ?, ?, ?, ?)");

        rmUserStatement = mConnection.prepareStatement(
                "DELETE FROM " + USER
                + " WHERE " + CPF + " = ?");

        checkUserExistence = mConnection.prepareStatement(
                "SELECT * FROM " + USER + ", " + PERSON
                + " WHERE " + USER_ID + " = ? OR " + PERSON + "." + CPF + "= ?");

        // The result columns type represents all attributes of User class
        final String allUsersQuery = "SELECT "
                + USER_ID + ", " + USER_TYPE_ID + ", " + USER_TYPE_DESCRIPTION + ", "
                + PERSON + "." + CPF + "," + NAME + ", " + GENDER + ", " + BIRTH + " ,"
                + PHONE + "." + PHONE_NUMBER + ", " + EMAIL_ADDRESS + ", "
                + USER + "." + USER_PASSWORD + ", " + ACTIVE
                + " FROM " + PERSON
                + " LEFT JOIN " + USER + " ON " + PERSON + "." + CPF + " = " + USER + "." + CPF
                + " LEFT JOIN " + USER_TYPE + " ON " + USER + "." + USER_TYPE + " = " + USER_TYPE + "." + USER_TYPE_ID
                + " LEFT JOIN " + PHONE + " ON " + PERSON + "." + CPF + " = " + PHONE + "." + CPF
                + " LEFT JOIN " + EMAIL + " ON " + PERSON + "." + CPF + " = " + EMAIL + "." + CPF;

        readAllUsersStatement = mConnection.prepareStatement(
                allUsersQuery + " ORDER BY " + PERSON + "." + NAME
        );

        readUserByCPFStatement = mConnection.prepareStatement(
                allUsersQuery
                + " WHERE " + PERSON + "." + CPF + " = ?"
        );

        readUserByIDStatement = mConnection.prepareStatement(
                allUsersQuery
                + " WHERE " + USER + "." + USER_ID + " = ?"
        );

        upUserStatement = mConnection.prepareStatement(
                "UPDATE " + USER + " SET "
                + USER_ID + " = ?, "
                + CPF + " = ?, "
                + USER_TYPE + " = ?, "
                + USER_PASSWORD + " = ? "
                + "WHERE " + USER_ID + " = ?"
        );

        readUsersLikeStatement = mConnection.prepareStatement(
                allUsersQuery
                + " WHERE " + PERSON + "." + NAME + " LIKE ?"
                + " ORDER BY " + PERSON + "." + NAME
        );

        activationUserStatement = mConnection.prepareStatement(
                "UPDATE " + USER + " SET "
                + ACTIVE + " = ? "
                + "WHERE " + USER_ID + " = ?"
        );
    }

    private void setFloorQueries() throws SQLException {
        addFloorStatement = mConnection.prepareStatement(
                "INSERT INTO " + FLOOR
                + "(" + FLOOR_ID + ", " + FLOOR_DESCRIPTION + ")"
                + "VALUES (?, ?)");

        rmFloorStatement = mConnection.prepareStatement(
                "DELETE FROM " + FLOOR
                + " WHERE " + FLOOR_ID + " = ?");

        upFloorStatement = mConnection.prepareStatement(
                "UPDATE " + FLOOR + " SET "
                + FLOOR_DESCRIPTION + " = ? "
                + "WHERE " + FLOOR_ID + " = ?"
        );
    }

    private void setRoomTypeQueries() throws SQLException {
        addRoomTypeStatement = mConnection.prepareStatement(
                "INSERT INTO " + ROOM_TYPE
                + "(" + ROOM_TYPE_ID + ", " + ROOM_TYPE_DESCRIPTION + ")"
                + "VALUES (?, ?)");

        rmRoomTypeStatement = mConnection.prepareStatement(
                "DELETE FROM " + ROOM_TYPE
                + " WHERE " + ROOM_TYPE_ID + " = ?");

        upRoomTypeStatement = mConnection.prepareStatement(
                "UPDATE " + ROOM_TYPE + " SET "
                + ROOM_TYPE_DESCRIPTION + " = ? "
                + "WHERE " + ROOM_TYPE_ID + " = ?"
        );
    }

    private void setRoomQueries() throws SQLException {
        addRoomStatement = mConnection.prepareStatement(
                "INSERT INTO " + ROOM
                + "(" + ROOM_ID + ", " + ROOM_TYPE + ", " + FLOOR + ", "
                + ROOM_CAPACITY + ", " + HAS_PROJECTOR + ", " + NUM_COMPUTERS + ", " + ACTIVE + ")"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        rmRoomStatement = mConnection.prepareStatement(
                "DELETE FROM " + ROOM
                + " WHERE " + ROOM_ID + " = ?"
        );

        // The result columns type represents all attributes of Room class
        final String allRoomsQuery
                = "SELECT id_floor, floor.description, id_room_type, room_type.description, "
                + "id_room, capacity, has_projector, num_computers, active "
                + "FROM " + ROOM
                + " LEFT JOIN " + FLOOR + " ON " + FLOOR + "." + FLOOR_ID + " = " + ROOM + "." + FLOOR
                + " LEFT JOIN " + ROOM_TYPE + " ON " + ROOM_TYPE + "." + ROOM_TYPE_ID + " = " + ROOM + "." + ROOM_TYPE;

        readAllRoomsStatement = mConnection.prepareStatement(
                allRoomsQuery + " ORDER BY " + ROOM + "." + ROOM_ID
        );

        readRoomsByTypeStatement = mConnection.prepareStatement(
                allRoomsQuery
                + " WHERE " + ROOM + "." + ROOM_TYPE + " = ?"
        );

        upRoomStatement = mConnection.prepareStatement(
                "UPDATE " + ROOM + " SET "
                + ROOM_ID + " = ?, "
                + ROOM_TYPE + " = ?, "
                + FLOOR + " = ?, "
                + ROOM_CAPACITY + " = ?, "
                + HAS_PROJECTOR + " = ?, "
                + NUM_COMPUTERS + " = ?, "
                + ACTIVE + " = ? "
                + "WHERE " + ROOM_ID + " = ?"
        );

        activationRoomStatement = mConnection.prepareStatement(
                "UPDATE " + ROOM + " SET "
                + ACTIVE + " = ? "
                + "WHERE " + ROOM_ID + " = ?"
        );

        readRoomByIDStatement = mConnection.prepareStatement(
                allRoomsQuery
                + " WHERE " + ROOM_ID + " = ?"
        );
    }

    private void setBookingQueries() throws SQLException {

        /**
         * STR_TO_DATE converts the given string to SQL Date that will be
         * retrieved later with getTimetamp.
         */
        addBookingStatement = mConnection.prepareStatement(
                "INSERT INTO " + BOOKING
                + "(" + USER + ", " + ROOM + ", "
                + GOAL + ", " + NUM_PEOPLE + ", " + DATE_TIME + ")"
                //+ "VALUES (?, ?, ?, ?, STR_TO_DATE(?, '" + MY_DATE_FORMAT + "') )");
                + "VALUES (?, ?, ?, ?, ? )"
        );

        rmBookingStatement = mConnection.prepareStatement(
                "DELETE FROM " + BOOKING
                + " WHERE " + BOOKING_ID + " = ?");

        final String allBookingsQuery = "SELECT *"
                + " FROM " + BOOKING;

        readAllBookingsStatement = mConnection.prepareStatement(
                allBookingsQuery + " ORDER BY " + BOOKING_ID + " DESC"
        );
        readBookingsByUserIDStatement = mConnection.prepareStatement(
                allBookingsQuery
                + " WHERE " + USER + " = ?"
        );

        // Looks for a booking of given room_type, date and time.
        checkBookingExistence = mConnection.prepareStatement(
                allBookingsQuery
                + " WHERE " + ROOM + " = ? AND " + DATE_TIME + " = ?"
        );

        upBookingStatement = mConnection.prepareStatement(
                "UPDATE " + BOOKING + " SET "
                + GOAL + " = ?, "
                + NUM_PEOPLE + " = ?, "
                //+ DATE_TIME + " = ? "
                + DATE_TIME + " = STR_TO_DATE(?, '" + MY_DATE_FORMAT + "') "
                + "WHERE " + BOOKING_ID + " = ?"
        );

    }

    // ---------------- Start of CREATE methods ----------------
    /*
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

    /*
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
        System.out.println("addEmail successful.");
    }

    /*
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
        System.out.println("addPhone successful.");
    }

    /*
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
        System.out.println("addUserType successful.");
    }

    /**
     * Creates an new user in User table.
     */
    private void addUser(String userID, String cpf, int userTypeID, String password, int active) {
        try {
            addUserStatement.setString(1, userID);
            addUserStatement.setString(2, cpf);
            addUserStatement.setInt(3, userTypeID);
            addUserStatement.setString(4, password);
            addUserStatement.setInt(5, active);

            //addUserStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addUser successful.");
    }

    /*
     * Creates an new user, a person, an email and a phone in their respective
     * tables.
     */
    public void addUser(String userID, String cpf, int userTypeID, String emailAddress,
            String phoneNumber, String name, char gender, String birth, String password,
            int active) throws KeyExistsException {

        if (userExists(userID, cpf)) {
            throw new KeyExistsException("User already exists");
        }

        addPerson(cpf, name, gender, birth);
        addEmail(cpf, emailAddress);
        addPhone(cpf, phoneNumber);
        addUser(userID, cpf, userTypeID, password, active);

        try {
            addPersonStatement.executeUpdate();
            addEmailStatement.executeUpdate();
            addPhoneStatement.executeUpdate();
            addUserStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
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

    /*
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

    /*
     * Creates a new room in Room table.
     */
    public void addRoom(String roomID, String roomType, int floorID, int capacity,
            int hasProjector, int numberOfComputers, int active) {
        try {
            addRoomStatement.setString(1, roomID);
            addRoomStatement.setString(2, roomType);
            addRoomStatement.setInt(3, floorID);
            addRoomStatement.setInt(4, capacity);
            addRoomStatement.setInt(5, hasProjector);
            addRoomStatement.setInt(6, numberOfComputers);
            addRoomStatement.setInt(7, active);

            addRoomStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addRoom successful.");
    }

    /*
     * Creates a new booking in Booking table.
     */
    public boolean addBooking(String userID, String roomID, String goal, int numberOfPeople,
            Timestamp dateTime) throws KeyExistsException {

        /* 
        Verifies booking existence before inserting in the table in order to 
         avoid more than one booking at the same time 
         */
        if (bookingExists(roomID, dateTime)) {
            throw new KeyExistsException("Booking already exists");
        }
        try {
            addBookingStatement.setString(1, userID);
            addBookingStatement.setString(2, roomID);
            addBookingStatement.setString(3, goal);
            addBookingStatement.setInt(4, numberOfPeople);
            addBookingStatement.setTimestamp(5, dateTime);

            addBookingStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("addBooking successful.");
        return true;
    }

    /**
     * Checks if a booking exists.
     *
     * @param roomID
     * @param dateTime is compared as String with Date in MySQL query (and it
     * works)
     * @return true if exists, false otherwise
     */
    private boolean bookingExists(String roomID, Timestamp dateTime) {
        ResultSet mResultSet = null;
        try {
            checkBookingExistence.setString(1, roomID);
            checkBookingExistence.setTimestamp(2, dateTime);
            mResultSet = checkBookingExistence.executeQuery();
            if (mResultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

// ---------------- Start of DELETE methods ---------------- 
    private void removePerson(String cpf) {
        try {
            rmPersonStatement.setString(1, cpf);
            rmPersonStatement.executeUpdate();

            System.out.println("Person of " + cpf + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeUser(String cpf) {
        try {
            rmUserStatement.setString(1, cpf);
            rmUserStatement.executeUpdate();
            removePerson(cpf);

        } catch (SQLException ex) {
            System.err.println("User cannot be deleted for data consistency.");
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removePhone(String cpf) {
        try {
            rmPhoneStatement.setString(1, cpf);
            rmPhoneStatement.executeUpdate();

            System.out.println("Phone of CPF " + cpf + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeEmail(String cpf) {
        try {
            rmEmailStatement.setString(1, cpf);
            rmEmailStatement.executeUpdate();

            System.out.println("Email of CPF " + cpf + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeUserType(int userTypeID) {
        try {
            rmUserTypeStatement.setInt(1, userTypeID);
            rmUserTypeStatement.executeUpdate();

            System.out.println("UserType of userTypeID " + userTypeID + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeRoomType(String roomTypeID) {
        try {
            rmRoomTypeStatement.setString(1, roomTypeID);
            rmRoomTypeStatement.executeUpdate();

            System.out.println("RoomType of roomTypeID " + ROOM_TYPE_ID + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeRoom(String roomID) {
        try {
            rmRoomStatement.setString(1, roomID);
            rmRoomStatement.executeUpdate();

            System.out.println("Room of roomID " + ROOM_ID + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeFloor(int floorID) {
        try {
            rmFloorStatement.setInt(1, floorID);
            rmFloorStatement.executeUpdate();

            System.out.println("Floor of floorID " + ROOM_TYPE_ID + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeBooking(int bookingID) {
        // TODO
        // 1. Allow to remove only before the reservation time for common user.

        try {
            rmBookingStatement.setInt(1, bookingID);
            rmBookingStatement.executeUpdate();

            System.out.println("Booking of bookingID" + ROOM_TYPE_ID + " deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean userExists(String userID, String cpf) {
        ResultSet mResultSet = null;
        try {
            checkUserExistence.setString(1, userID);
            checkUserExistence.setString(2, cpf);
            mResultSet = checkUserExistence.executeQuery();
            if (mResultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * Adds users to one list according to resultSet from MySQL database.
     *
     * @param resultSet after one query statement executed, according to the
     * calling method.
     * @return a list of users according to ResultSet.
     * @throws SQLException
     */
    private ArrayList<User> getUsers(ResultSet resultSet) throws SQLException {

        final ArrayList<User> list = new ArrayList<>();

        if (!resultSet.next()) { // if the search has no result
            return null;
        } else {
            resultSet.beforeFirst(); // before the first row
        }

        while (resultSet.next()) { // moves to the next valid row
            User user = new User(
                    resultSet.getString(1), // userID
                    resultSet.getInt(2), // userTypeID
                    resultSet.getString(3), // userTypeDescription
                    resultSet.getString(4), // CPF
                    resultSet.getString(5), // name
                    resultSet.getString(6), // gender
                    resultSet.getDate(7), // birth
                    resultSet.getString(8), // phoneNumber
                    resultSet.getString(9), // email
                    resultSet.getString(10), // password
                    resultSet.getInt(11) // active
            );
            list.add(user);
        }
        return list;
    }

    /**
     * Looks for a User in the database according to given key and
     * PreparedStatement.
     *
     * @param key from database (CPF, ID).
     * @param pStatement has a query to be executed in order to obtain a result
     * from database.
     * @return one User.
     * @throws KeyNotFoundException when the user doesn't exist.
     */
    private User getUserByKey(String key, PreparedStatement pStatement) throws KeyNotFoundException {
        User user = null;
        ResultSet mResultSet = null;
        try {
            pStatement.setString(1, key);
            mResultSet = pStatement.executeQuery();

            if (!mResultSet.next()) { // if the search has no result
                throw new KeyNotFoundException("User not found for key '" + key + "'");
            }

            user = new User(
                    mResultSet.getString(1),
                    mResultSet.getInt(2),
                    mResultSet.getString(3),
                    mResultSet.getString(4),
                    mResultSet.getString(5),
                    mResultSet.getString(6),
                    mResultSet.getDate(7),
                    mResultSet.getString(8),
                    mResultSet.getString(9),
                    mResultSet.getString(10),
                    mResultSet.getInt(11)
            );

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return user;
    }

    /**
     * Looks for a User in the database by its CPF with the method getUserByKey.
     *
     * @param cpf the primary key of Person table of the database.
     * @return one User, if exist.
     * @throws KeyNotFoundException when key CPF is not found.
     */
    public User getUserByCPF(String cpf) throws KeyNotFoundException {
        return getUserByKey(cpf, readUserByCPFStatement);
    }

    /**
     * Looks for a User in the database by its ID with the method getUserByKey.
     *
     * @param id the primary key of User table of the database.
     * @return one User, if exist.
     * @throws KeyNotFoundException when id is not found.
     */
    public User getUserByID(String id) throws KeyNotFoundException {
        return getUserByKey(id, readUserByIDStatement);
    }

    /**
     * Gets all registered users in the database with getUsers method.
     *
     * @return a list of all users.
     */
    public ArrayList<User> getAllUsers() {
        ArrayList<User> list = null;
        ResultSet mResultSet = null;
        try {
            mResultSet = readAllUsersStatement.executeQuery();
            list = getUsers(mResultSet);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    /**
     * Adds rooms to one list according to resultSet from MySQL database.
     *
     * @param resultSet after one query statement executed, according to the
     * calling method.
     * @return a list of Rooms according to resultSet.
     * @throws SQLException
     */
    private ArrayList<Room> getRooms(ResultSet resultSet) throws SQLException {
        final ArrayList<Room> list = new ArrayList<>();

        if (!resultSet.next()) { // if the search has no result
            return null;
        } else {
            resultSet.beforeFirst(); // before the first row
        }

        while (resultSet.next()) { // moves to the next valid row

            Room room = new Room(
                    resultSet.getInt(1), // floorID 
                    resultSet.getString(2), // floor
                    resultSet.getString(3), // roomTypeID
                    resultSet.getString(4), // roomTypeDescription
                    resultSet.getString(5), // roomID
                    resultSet.getInt(6), // capacity
                    resultSet.getBoolean(7), // hasProjector
                    resultSet.getInt(8), // numberOfComputers
                    resultSet.getInt(9) // active

            );
            list.add(room);
        }

        return list;
    }

    private Room getRoom(ResultSet resultSet) throws SQLException {

        if (!resultSet.next()) { // if the search has no result
            return null;
        } else {
            resultSet.beforeFirst(); // before the first row
        }

        resultSet.next();

        Room room = new Room(
                resultSet.getInt(1), // floorID 
                resultSet.getString(2), // floor
                resultSet.getString(3), // roomTypeID
                resultSet.getString(4), // roomTypeDescription
                resultSet.getString(5), // roomID
                resultSet.getInt(6), // capacity
                resultSet.getBoolean(7), // hasProjector
                resultSet.getInt(8), // numberOfComputers
                resultSet.getInt(9) // active

        );

        return room;
    }

    public Room getRoomByID(String roomID) {
        Room room = null;
        try {
            readRoomByIDStatement.setString(1, roomID);
            ResultSet mResultSet = readRoomByIDStatement.executeQuery();
            room = getRoom(mResultSet);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return room;
    }

    /**
     * Gets all registered rooms in the database with getRooms method.
     *
     * @return a list of all rooms.
     */
    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> list = null;
        ResultSet mResultSet = null;
        try {
            mResultSet = readAllRoomsStatement.executeQuery();
            list = getRooms(mResultSet);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    /**
     * Gets all registered rooms in the database according to room type with
     * getRooms method.
     *
     * @param type room_type of Room table of the database.
     * @return a list of all rooms of given type.
     */
    public ArrayList<Room> getAllRoomsByType(String type) {
        ArrayList<Room> list = null;
        try {
            readRoomsByTypeStatement.setString(1, type);
            ResultSet mResultSet = readRoomsByTypeStatement.executeQuery();
            list = getRooms(mResultSet);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Adds booking to one list according to resultSet from MySQL database.
     *
     * @param resultSet after one query statement executed, according to the
     * calling method.
     * @return a list of Bookings according to resultSet.
     * @throws SQLException
     */
    private ArrayList<Booking> getBookings(ResultSet resultSet) throws SQLException {
        final ArrayList<Booking> list = new ArrayList<>();

        if (!resultSet.next()) { // if the search has no result
            return null;
        } else {
            resultSet.beforeFirst(); // before the first row
        }

        while (resultSet.next()) { // moves to the next valid row

            Booking room = new Booking(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getTimestamp(6)
            );
            list.add(room);
        }

        return list;
    }

    /**
     * Gets all registered bookings from database with getBookings method.
     *
     * @return list of bookings according to resultSet.
     */
    public ArrayList<Booking> getAllBookings() {
        ArrayList<Booking> list = null;
        ResultSet mResultSet = null;
        try {
            mResultSet = readAllBookingsStatement.executeQuery();
            list = getBookings(mResultSet);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    /**
     * Gets all registered bookings done by one user in the database with
     * getRooms method.
     *
     * @param userID the primary key of User table of the database.
     * @return list of bookings according to resultSet.
     * @throws KeyNotFoundException when there is no booking for the given
     * userID.
     */
    public ArrayList<Booking> getBookingsByUserID(String userID) throws KeyNotFoundException {
        ArrayList<Booking> list = null;
        ResultSet mResultSet = null;
        try {
            readBookingsByUserIDStatement.setString(1, userID);
            mResultSet = readBookingsByUserIDStatement.executeQuery();
            if (!mResultSet.next()) { // if the search has no result
                throw new KeyNotFoundException("Booking not found for user id " + userID);
            } else {
                mResultSet.beforeFirst(); // before the first row
            }
            list = getBookings(mResultSet);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    /**
     * Updates person in the database.
     *
     * @param currentCPF is the CPF of the person to be updated.
     * @param person has the new values for currentCPF.
     */
    private void updatePerson(String currentCPF, Person person) {
        try {
            upPersonStatement.setString(1, person.getCpf());
            upPersonStatement.setString(2, person.getName());
            upPersonStatement.setString(3, String.valueOf(person.getGender()));
            upPersonStatement.setDate(4, person.getBirth());
            upPersonStatement.setString(5, currentCPF);

            //upPhoneStatement.setString(1, person.getCpf());
            upPhoneStatement.setString(1, person.getPhoneNumber());
            upPhoneStatement.setString(2, currentCPF);

            //upEmailStatement.setString(1, person.getCpf());
            upEmailStatement.setString(1, person.getEmail());
            upEmailStatement.setString(2, currentCPF);

            upPhoneStatement.executeUpdate();
            upEmailStatement.executeUpdate();
            upPersonStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates user and person in the database.
     *
     * @param currentUserID is the current user to be updated.
     * @param user are the new values for currentUserID.
     */
    public void updateUser(String currentUserID, User user) {
        try {
            try {
                updatePerson(getUserByID(currentUserID).getCpf(), (Person) user);
            } catch (KeyNotFoundException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }

            upUserStatement.setString(1, user.getUserID());
            upUserStatement.setString(2, user.getCpf());
            upUserStatement.setInt(3, user.getUserTypeID());
            upUserStatement.setString(4, user.getPassword());
            upUserStatement.setString(5, currentUserID);

            upUserStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates booking in the database. Booking ID and Room ID cannot be
     * updated.
     *
     * @param bookingID the booking to be updated
     * @param booking new data to update the booking
     * @param time as string: YYYY/MM/DD HH:MM AA. We use STR_TO_DATE(time) in
     * MySQL query.
     */
    public void updateBooking(int bookingID, Booking booking, String time) {
        try {

            // TODO
            // 1 - Allow update only before the reservation time for all users.
            upBookingStatement.setString(1, booking.getGoal());
            upBookingStatement.setInt(2, booking.getNumberOfPeople());
            upBookingStatement.setString(3, time);
            upBookingStatement.setInt(4, bookingID);

            upBookingStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates Room in the database.
     *
     * @param roomID is the room to be updated
     * @param room the new data
     */
    public void updateRoom(String roomID, Room room) {
        try {
            upRoomStatement.setString(1, room.getRoomID());
            upRoomStatement.setString(2, room.getRoomTypeID());
            upRoomStatement.setInt(3, room.getFloorID());
            upRoomStatement.setInt(4, room.getCapacity());
            upRoomStatement.setInt(5, (room.HasProjector() ? 1 : 0));
            upRoomStatement.setInt(6, room.getNumberOfComputers());
            upRoomStatement.setInt(7, room.getActive());
            upRoomStatement.setString(8, roomID);

            upRoomStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates Floor in the database.
     *
     * @param floorID the floor to be updated.
     * @param floorDescription the new description.
     */
    public void updateFloor(int floorID, String floorDescription) {
        try {
            upFloorStatement.setString(1, floorDescription);
            upFloorStatement.setInt(2, floorID);

            upFloorStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates UserType in the database.
     *
     * @param userTypeID the user type to be updated.
     * @param userTypeDescription the new description.
     */
    public void updateUserType(int userTypeID, String userTypeDescription) {
        try {
            upUserTypeStatement.setString(1, userTypeDescription);
            upUserTypeStatement.setInt(2, userTypeID);

            upUserTypeStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates RoomType in the database.
     *
     * @param roomTypeID the room type to be updated.
     * @param roomTypeDescription the new description.
     */
    public void updateRoomType(String roomTypeID, String roomTypeDescription) {
        try {
            upRoomTypeStatement.setString(1, roomTypeDescription);
            upRoomTypeStatement.setString(2, roomTypeID);

            upRoomTypeStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Finds all users in the database whose name contains a given substring.
     *
     * @param nameLike is a possible substring of a name.
     * @return list of users whose name has nameLike as substring.
     */
    public ArrayList<User> getUsersLike(String nameLike) {
        ArrayList<User> list = null;
        ResultSet mResultSet = null;
        try {
            readUsersLikeStatement.setString(1, "%" + nameLike + "%"); // % for sintax of MySQL query 

            mResultSet = readUsersLikeStatement.executeQuery();
            list = getUsers(mResultSet);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                mResultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    /**
     * Reverses the current 'active' status of the user and saves it to the
     * database.
     *
     * @param user to be activated or deactivated.
     */
    public void reverseUserActivation(User user) {
        try {
            if (user.getActive() == 0) {
                user.setActive(1);
                activationUserStatement.setInt(1, 1); // set active
            } else {
                user.setActive(0);
                activationUserStatement.setInt(1, 0); // set inactive
            }
            activationUserStatement.setString(2, user.getUserID());
            activationUserStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reverses the current 'active' status of the room and saves it to the
     * database.
     *
     * @param room to be activated or deactivated.
     */
    public void reverseRoomActivation(Room room) {
        try {
            if (room.getActive() == 0) {
                room.setActive(1);
                activationRoomStatement.setInt(1, 1); // set active
            } else {
                room.setActive(0);
                activationRoomStatement.setInt(1, 0); // set inactive
            }
            activationRoomStatement.setString(2, room.getRoomID());
            activationRoomStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
