import java.util.ArrayList;

public class Map {
    public Room currentRoom;

    public Map () {
        // Create rooms
        Room room1 = new Room("room1", "You're back where you started, at the dirt path.");
        Room room2 = new Room("room2", "You're at a river, you can take the boat west or enter the boathouse by heading south.");
        Room room3 = new Room("room3", "You're in a boat house, with gross looking furniture. You think to yourself: 'theres something useful nearby'.");
        Room room4 = new Room("room4", "You're at a beautiful open grassland with lots of happy bees, in the dirt below you, you see a hidden tunnel. Eerie noises sound from below.");
        Room room5 = new Room("room5", "You attempt to enter the tunnel, but a giant bear guards the entrance. Perhaps something sweet could distract the bear?");

        Room room6 = new Room("room6", "You're in a forest, to the east, there's a scary looking house. To the south, there's a castle.");
        Room room7 = new Room("room7", "You're in a house that seems to be haunted, if only you had something to lighten up the place.");
        Room room8 = new Room("room8", "You're staring inside a tiny closet, with a golden key inside it.");

        Room room9 = new Room("room9", "You're inside the castle. Straight ahead you see a golden door. Perhaps a key could open it?");
        Room room10 = new Room("room10", "You're inside the treasure room.");
        currentRoom = room1;


        // creates items in the different rooms
        room1.addItem("a mighty shovel");
        room1.addItem("a glorious axe");

        room3.addItem("a shiny lamp");
        room8.addItem("a golden key");
        room4.addItem("sweet honey");



        // Connect rooms
        // connect dirt path with river / forest
        room1.connectRoomsWest(room2);
        room1.connectRoomsEast(room6);

        // connect river with grassland / boat house
        room2.connectRoomsSouth(room3);
        room2.connectRoomsWest(room4);

        // connect boat house with grasslands
        room3.connectRoomsSouth(room4);

        // connect grasslands with tunnel
        room4.connectRoomsSouth(room5);

        // connect forest with haunted house
        room6.connectRoomsEast(room7);

        // connect haunted house with closet / key room
        room7.connectRoomsEast(room8);

        // forest with casle & castle with treasure room
        room6.connectRoomsSouth(room9);
        room9.connectRoomsSouth(room10);

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String getItemName(Item item) {
        return item.getItemName();
    }

    public String getItemDescription(Item item) {
        return item.getItemDescription();
    }

}