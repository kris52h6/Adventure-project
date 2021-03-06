public class Map {
    private final Room startRoom;

    public Map () {
        // Create rooms
        Room room1 = new Room("Dirt path", "You're back where you started, at the dirt path.");
        Room room2 = new Room("River", "You're at a river, you can take the boat west or enter the boathouse by heading south.");
        Room room3 = new Room("Boat house", "You're in a boat house, with gross looking furniture. You think to yourself: 'theres something useful nearby'.");
        Room room4 = new Room("Grasslands", "You're at a beautiful open grassland with lots of happy bees, in the dirt below you, you see a hidden tunnel. Eerie noises sound from below.");
        Room room5 = new Room("Tunnel", "You attempt to enter the tunnel, but a giant bear guards the entrance. Perhaps something sweet could distract the bear?");

        Room room6 = new Room("Forest", "You're in a forest, to the east, there's a scary looking house. To the south, there's a castle.");
        Room room7 = new Room("Haunted house", "You're in a house that seems to be haunted, if only you had something to lighten up the place.");
        Room room8 = new Room("Closet", "You're staring inside a tiny closet, with a golden key inside it.");

        Room room9 = new Room("Castle", "You're inside the castle. Straight ahead you see a golden door. Perhaps a key could open it?");
        Room room10 = new Room("Treasure room", "You're inside the treasure room.");
        startRoom = room1;


/*        Item item = new Item("shovel", "a mighty shovel");
        room1.addItem(item);

        Item item2 = new Item("lamp", "a shiny lamp");
        room3.addItem(item2);*/

        // creates items in the different rooms
        room1.addItem("a mighty shovel");
        room3.addItem("a shiny lamp");
        room8.addItem("a golden key");
        room4.addItem("sweet honey");


        // create food
        room1.addItem("a red apple", 20, CheckFood.EDIBLE);

        Food badfood = new Food("cig", "a worn down cig", 40, CheckFood.TOXIC);
        room1.addItem(badfood);


        // Add weapons
        MeleeWeapon mlwep1 = new MeleeWeapon("axe", "a mighty axe", 2, CheckWeapon.MELEEWEAPON);
        ShootingWeapon shwep = new ShootingWeapon("gun" , "a small gun", 3,CheckWeapon.SHOOTINGWEAPON, 5);
        MeleeWeapon excalibur = new MeleeWeapon("excalibur", "the glorious excalibur", 30, CheckWeapon.MELEEWEAPON);
        MeleeWeapon knife = new MeleeWeapon("knife", "a small kitchen knife", 3, CheckWeapon.MELEEWEAPON);
        MeleeWeapon club = new MeleeWeapon("club", "a humongous club", 15, CheckWeapon.MELEEWEAPON);

        room1.addItem(mlwep1);
        room1.addItem(shwep);
        room8.addItem(excalibur);

        // create enemies & add them to rooms
        Enemy enemy1 = new Enemy("bandit", "a grimy bandit", 20, knife, room1);
        room1.addEnemy(enemy1);

        Enemy ogre = new Enemy("ogre", "a humongous ogre", 100, club, room9);
        room9.addEnemy(ogre);


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

    public Room getStartRoom() {
        return startRoom;
    }


}