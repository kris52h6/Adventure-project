import java.util.ArrayList;

public class Room {
    private final String name;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private final String description;

    ArrayList<Item> items = new ArrayList<>();


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Connects "north" to "south" by setting north = nextRoom &
    // setting nextRoom's south to this (current object)
    public void connectRoomsNorth(Room nextRoom) {
        if (north == null) {
            north = nextRoom;
            nextRoom.setSouth(this);
        }
    }

    // Connects "east" to "west by setting east = nextRoom &
    // setting nextRoom's west to this (current object)
    public void connectRoomsEast(Room nextRoom) {
        if (east == null) {
            east = nextRoom;
            nextRoom.setWest(this);
        }
    }

    // Connects "south" to "north by setting south = nextRoom &
    // setting nextRoom's north to this (current object)
    public void connectRoomsSouth(Room nextRoom) {
        if (south == null) {
            south = nextRoom;
            nextRoom.setNorth(this);
        }
    }

    // Connects "west" to "east by setting west = nextRoom &
    // setting nextRoom's east to this (current object)
    public void connectRoomsWest(Room nextRoom) {
        if (west == null) {
            west = nextRoom;
            nextRoom.setEast(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }


    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }

}
