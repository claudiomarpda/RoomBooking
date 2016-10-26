package roombooking;

import java.util.ArrayList;
import java.util.Date;

public class User extends Person {

    private final String userID;
    private byte userTypeID;
    private String userTypeDescription;

    public User(String userID, byte userTypeID, String cpf, String name,
            char gender, Date birth, ArrayList<String> phoneNumberList, String userTypeDescription) {
        super(cpf, name, gender, birth, phoneNumberList);
        this.userTypeID = userTypeID;
        this.userID = userID;
        this.userTypeDescription = userTypeDescription;
    }

    public byte getUserType() {
        return userTypeID;
    }

    public void setUserType(byte userType) {
        this.userTypeID = userType;
    }

    public String getUserID() {
        return userID;
    }

    public byte getUserTypeID() {
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
    
}
