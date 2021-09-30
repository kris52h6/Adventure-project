import java.util.ArrayList;

public class Map {
    public Room currentRoom;

    public Map () {
        // Create rooms
        Room room1 = new Room("room1", "You're back where you started, at the dirt path.");
        Room room2 = new Room("room2", "You're at a river, flowing with violent waves");
        Room room3 = new Room("room3", "You pass a scary looking house.");
        Room room4 = new Room("room4", "You enter a gloomy forest.");
        Room room5 = new Room("room5", "You enter a treasure room. What could be hiding here?");
        Room room6 = new Room("room6", "You pass a scary tree.");
        Room room7 = new Room("room7", "You're at a dark alley, around you are a bunch of sketchy looking people.");
        Room room8 = new Room("room8", "You enter a small building, to the north of you, is a special looking door.");
        Room room9 = new Room("room9", "You enter a small tavern.");
        currentRoom = room1;



        Item item = new Item("lamp", "a shiny lamp");
        room1.items.add(item);


        Item item2 = new Item("knife", "an ugly knife");
        room1.items.add(item2);


        Item item3 = new Item("hat", "a blue wizard hat");
        room2.items.add(item3);


        // Connect rooms
        // connect r1 with r2/r4
        room1.connectRoomsEast(room2);
        room1.connectRoomsSouth(room4);

        //connect r2 with r3
        room2.connectRoomsEast(room3);

        // connect r3 with r6
        room3.connectRoomsSouth(room6);

        // connect r4 with r7
        room4.connectRoomsSouth(room7);

        // connect r6 with r9
        room6.connectRoomsSouth(room9);

        // connect r8 with r7/r9/r5
        room8.connectRoomsWest(room7);
        room8.connectRoomsEast(room9);
        room8.connectRoomsNorth(room5);

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