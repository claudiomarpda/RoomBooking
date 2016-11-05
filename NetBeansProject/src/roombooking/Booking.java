package roombooking;


public class Booking {
    private int bookingID;
    private String userID;
    private String roomID;
    private String goal;
    private byte numberOfPeople;
    
    public Booking(int bookingID, String userID, String roomID, String goal, byte numberOfPeople){
        this.bookingID = bookingID;
        this.userID = userID;
        this.roomID = roomID;
        this.goal = goal;
        this.numberOfPeople = numberOfPeople;
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

    public byte getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(byte numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
    
      @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", userID=" + userID + ", roomID=" + roomID + ", goal=" + goal + ", numberOfPeople=" + numberOfPeople + '}';
    }
    
}
