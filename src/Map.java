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

        // Connect rooms
        // connect r1 with r2/r4
        room1.connectRoomsHorizontally(room2);
        room1.connectRoomsVertically(room4);

        //connect r2 with r3
        room2.connectRoomsHorizontally(room3);

        // connect r3 with r6
        room3.connectRoomsVertically(room6);

        // connect r4 with r7
        room4.connectRoomsVertically(room7);

        // connect r6 with r9
        room6.connectRoomsVertically(room9);

        // connect r8 with r7/r9/r5
        room7.connectRoomsHorizontally(room8);
        room8.connectRoomsHorizontally(room9);
        room5.connectRoomsVertically(room8);


    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}