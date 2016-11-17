package roombooking;

import java.sql.Date;

/**
 * User class represents database table User.
 */
public class User extends Person {
    
    public static final int PROFESSOR = 1; // user type id
    public static final int STUDENT = 2;
    public static final int ADMIN = 3;
    
    private String userID;
    private int userTypeID;
    private String userTypeDescription;
    private String password;
    private int active;

    public User() {
    }

    // Constructor with only one phone number
    public User(String userID, int userTypeID, String userTypeDescription, String cpf, String name,
            String gender, Date birth, String phoneNumber, String email, String password, int active) {
        super(cpf, name, gender, birth, phoneNumber, email);
        this.userID = userID;
        this.userTypeID = userTypeID;
        this.userTypeDescription = userTypeDescription;
        this.password = password;
        this.active = active;
    }

    public void setUserType(byte userType) {
        this.userTypeID = userType;
    }

    public String getUserID() {
        return userID;
    }

    public int getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(byte userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getUserTypeDescription() {
        return userTypeDescription;
    }

    public void setUserTypeDescription(String userTypeDescription) {
        this.userTypeDescription = userTypeDescription;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {

        return "User{" + "userID=" + userID + ", userTypeID=" + userTypeID + ", userTypeDescription=" + userTypeDescription
                + " " + super.toString() + '}';
    }

}
