package roombooking;


public class Room {
    private byte floorID;
    private String floor;
    private String roomTypeID;
    private String roomTypeDescription;
    private String roomID;
    private byte capacity;
    private boolean hasProjector;
    private byte numberOfComputers;
    
    public Room(byte floorID, String floor, String roomTypeID, String roomTypeDescription, String roomID, byte capacity, boolean hasProjector, byte numberOfComputers){
        this.floorID = floorID;
        this.floor = floor;
        this.roomTypeID = roomTypeID;
        this.roomTypeDescription = roomTypeDescription;
        this.roomID = roomID;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
        this.numberOfComputers = numberOfComputers;
    }
    
    
    public byte getFloorID() {
        return floorID;
    }
    
    public void setFloorID(byte floorID) {
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
    
    public byte getCapacity() {
        return capacity;
    }
    
    public void setCapacity(byte capacity) {
        this.capacity = capacity;
    }
    
    public boolean HasProjector() {
        return hasProjector;
    }
    
    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }
    
    public byte getNumberOfComputers() {
        return numberOfComputers;
    }
    
    public void setNumberOfComputers(byte numberOfComputers) {
        this.numberOfComputers = numberOfComputers;
    }
    
    
    
}