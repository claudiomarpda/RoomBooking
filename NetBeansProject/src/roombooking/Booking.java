package roombooking;

import java.sql.Timestamp;

/**
 * 
 * Booking class represents database tables ROOM_TYPE and ROOM.
 */
public class Booking {

    private int bookingID;
    private String userID;
    private String roomID;
    private String goal;
    private int numberOfPeople;
    private Timestamp timeStamp;

    public Booking(int bookingID, String userID, String roomID, String goal, int numberOfPeople, Timestamp timeStamp) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.roomID = roomID;
        this.goal = goal;
        this.numberOfPeople = numberOfPeople;
        this.timeStamp = timeStamp;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", userID=" + userID + ", roomID=" + roomID + ", goal=" + goal + ", numberOfPeople=" + numberOfPeople + ", timeStamp=" + timeStamp + '}';
    }

}
