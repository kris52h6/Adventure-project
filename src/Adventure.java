import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create rooms
        Room room1 = new Room("room1", "You're back where you started, at the dirt path.");
        Room room2 = new Room("room2", "You're at a river, flowing with violent waves");
        Room room3 = new Room("room3", "haunted house");
        Room room4 = new Room("room4", "gloomy forest");
        Room room5 = new Room("room5", "treasure room");
        Room room6 = new Room("room6", "ass");
        Room room7 = new Room("room7", "dark alley");
        Room room8 = new Room("room8", "twisted bushes");
        Room room9 = new Room("room9", "SPURGT MAND");

        Room currentRoom = room1;

        // map test (extra)
        System.out.println(currentRoom.getActiveRoom());
        currentRoom.switchMap();
        System.out.println(currentRoom.getActiveRoom());
        //

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

        // Intro
        System.out.println("Welcome to the adventure game.");


        // Start
        System.out.println("\nYou wake up on the side of a dirt path, your only options are: to head east, or: to head south.");
        System.out.print("Which way do you want to go? ");


        // Move directions
        while (true) {
            String playerInput = scanner.nextLine();

            // If player attempts to move north
            if (playerInput.equals("go north")) {
                if (currentRoom.getNorth() == null) {
                    System.out.println("You cannot go this way");
                } else {
                    System.out.println("Going north");
                    System.out.println(currentRoom.getNorth());
                    currentRoom = currentRoom.getNorth();
                    System.out.println(currentRoom.getDescription());
                }
            }

            // If player attempts to move east
            if (playerInput.equals("go east")) {
                if (currentRoom.getEast() == null) {
                    System.out.println("You cannot go this way");
                } else {
                    System.out.println("Going east");
                    System.out.println(currentRoom.getEast());
                    currentRoom = currentRoom.getEast();
                    System.out.println(currentRoom.getDescription());
                }
            }

            // If player attempts to move south
            if (playerInput.equals("go south")) {
                if (currentRoom.getSouth() == null) {
                    System.out.println("You cannot go this way");
                } else {
                    System.out.println("Going south");
                    System.out.println(currentRoom.getSouth());
                    currentRoom = currentRoom.getSouth();
                    System.out.println(currentRoom.getDescription());
                }
            }

            // If player attempts to move west
            if (playerInput.equals("go west")) {
                if (currentRoom.getWest() == null) {
                    System.out.println("You cannot go this way");
                } else {
                    System.out.println("Going west");
                    System.out.println(currentRoom.getWest());
                    currentRoom = currentRoom.getWest();
                    System.out.println(currentRoom.getDescription());
                }
            }

            // If player looks
            if (playerInput.equals("look")) {
                System.out.println(currentRoom.getDescription());
            }

            if (playerInput.equals("exit")) {
                System.out.println("Killing program...");
                System.exit(0);
            }

            if (playerInput.equals("help")) {
                System.out.println("\nWelcome to the help menu:");
                System.out.println("\tType 'go north', to go north");
                System.out.println("\tType 'go east', to go east");
                System.out.println("\tType 'go south', to go south");
                System.out.println("\tType 'go west', to go west");
                System.out.println("\tType 'look', to get a description of the room your currently in");
                System.out.println("\tType 'exit' to quit the program");
                System.out.println("\t- Good luck :)");
            }

        }

        }


    }
