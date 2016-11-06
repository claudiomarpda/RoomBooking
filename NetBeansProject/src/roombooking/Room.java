package roombooking;

/**
 * Room class represents database tables FLOOR, ROOM_TYPE and ROOM.
 */
public class Room {

    private int floorID;
    private String floor;
    private String roomTypeID;
    private String roomTypeDescription;
    private String roomID;
    private int capacity;
    private boolean hasProjector;
    private int numberOfComputers;

    public Room(int floorID, String floor, String roomTypeID, String roomTypeDescription, String roomID, int capacity, boolean hasProjector, int numberOfComputers) {
        this.floorID = floorID;
        this.floor = floor;
        this.roomTypeID = roomTypeID;
        this.roomTypeDescription = roomTypeDescription;
        this.roomID = roomID;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
        this.numberOfComputers = numberOfComputers;
    }

    public int getFloorID() {
        return floorID;
    }

    public void setFloorID(int floorID) {
        this.floorID = floorID;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(String roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomTypeDescription() {
        return roomTypeDescription;
    }

    public void setRoomTypeDescription(String roomTypeDescription) {
        this.roomTypeDescription = roomTypeDescription;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean HasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public int getNumberOfComputers() {
        return numberOfComputers;
    }

    public void setNumberOfComputers(int numberOfComputers) {
        this.numberOfComputers = numberOfComputers;
    }

    @Override
    public String toString() {
        return "Room{" + "floorID=" + floorID + ", floor=" + floor + ", roomTypeID=" + roomTypeID + ", roomTypeDescription=" + roomTypeDescription + ", roomID=" + roomID + ", capacity=" + capacity + ", hasProjector=" + hasProjector + ", numberOfComputers=" + numberOfComputers + '}';
    }

}
