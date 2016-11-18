package roombooking;

/**
 * Room class represents database tables FLOOR, ROOM_TYPE and ROOM.
 */
public class Room {

    public static final String PROFESSOR = "Professor";
    public static final String PROFESSOR_ID = "PROF";
    public static final String AUDITORIO = "Auditório";
    public static final String AUDITORIO_ID = "AUD";
    public static final String REUNIAO = "Reunião";
    public static final String REUNIAO_ID = "REU";
    public static final String LABORATORIO = "Laboratório";
    public static final String LABORATORIO_ID = "LAB";
    public static final String AULA = "Aula";
    public static final String AULA_ID = "AUL";

    private int floorID;
    private String floor;
    private String roomTypeID;
    private String roomTypeDescription;
    private String roomID;
    private int capacity;
    private boolean hasProjector;
    private int numberOfComputers;
    private int active;

    public Room(int floorID, String floor, String roomTypeID, String roomTypeDescription, String roomID,
            int capacity, boolean hasProjector, int numberOfComputers, int active) {
        this.floorID = floorID;
        this.floor = floor;
        this.roomTypeID = roomTypeID;
        this.roomTypeDescription = roomTypeDescription;
        this.roomID = roomID;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
        this.numberOfComputers = numberOfComputers;
        this.active = active;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Room{" + "floorID=" + floorID + ", floor=" + floor + ", roomTypeID=" + roomTypeID + ", roomTypeDescription=" + roomTypeDescription + ", roomID=" + roomID + ", capacity=" + capacity + ", hasProjector=" + hasProjector + ", numberOfComputers=" + numberOfComputers + '}';
    }

}
