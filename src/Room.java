import java.util.ArrayList;

public class Room {
    private final String name;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private final String description;

    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();


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

    public void addItem(Item item) {
        this.items.add(item);
    }

    // overload
    public void addItem(String description) {
        String name = createItemName(description);
        Item item = new Item(name, description);
        addItem(item);
    }

    // overload for creating food
    public void addItem(String description, int healthPoints, CheckFood type) {
        String name = createItemName(description);
        Food item = new Food(name, description, healthPoints, type);
        addItem(item);
    }

    public String createItemName(String description) {
        int lastIndexOfSpace = description.lastIndexOf(" ");
        String name = description.substring(lastIndexOfSpace +1);
        return name;
    }

    // enemies

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }

}
