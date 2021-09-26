public class Room {
    private String name;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private String description;
    private boolean activeRoom; // for map (extra)

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.activeRoom = false;
    }

    // Connects "horizontally" by setting east = nextRoom &
    // setting nextRoom's west to this (current object)
    public void connectRoomsHorizontally(Room nextRoom) {
        if (east == null) {
            east = nextRoom;
            nextRoom.setWest(this);
        }
    }

    // Connects "vertically" by setting south = nextRoom &
    // setting nextRoom's north to this (current object)
    public void connectRoomsVertically(Room nextRoom) {
        if (south == null) {
            south = nextRoom;
            nextRoom.setNorth(this);
        }
    }

    // for map (extra)
    public boolean getActiveRoom() {
        return activeRoom;
    }

    public boolean switchMap() {
        if (activeRoom) {
            this.activeRoom = false;
        } else
            this.activeRoom = true;
        return activeRoom;
    }
    //

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

        /*    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", north=" + north +
                ", east=" + east +
                ", south=" + south +
                ", west=" + west +
                '}';
    }*/

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
