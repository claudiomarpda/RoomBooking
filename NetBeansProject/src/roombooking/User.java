package roombooking;

import java.util.ArrayList;
import java.sql.Date;

public class User extends Person {

    private String userID;
    private int userTypeID;
    private String userTypeDescription;

    public User() {
    }

    // Construtor with a list of phones
    public User(String userID, byte userTypeID, String cpf, String name,
            String gender, Date birth, ArrayList<String> phoneNumberList, String userTypeDescription) {
        super(cpf, name, gender, birth, phoneNumberList);
        this.userTypeID = userTypeID;
        this.userID = userID;
        this.userTypeDescription = userTypeDescription;
    }

    // Constructor with only one phone number
    public User(String userID, int userTypeID, String userTypeDescription, String cpf, String name,
            String gender, Date birth, String phoneNumber, String email) {
        super(cpf, name, gender, birth, phoneNumber, email);
        this.userID = userID;
        this.userTypeID = userTypeID;
        this.userTypeDescription = userTypeDescription;
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

    @Override
    public String toString() {
        
        return "User{" + "userID=" + userID + ", userTypeID=" + userTypeID + ", userTypeDescription=" + userTypeDescription +
                " "+super.toString()+ '}';
    }
    
}
