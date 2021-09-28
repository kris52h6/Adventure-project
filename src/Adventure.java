import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerInput = "";


        // Intro
        System.out.println("Welcome to the adventure game.");


        // Start
        System.out.println("\nYou wake up on the side of a dirt path, your only options are: to head east, or: to head south.");
        System.out.print("Which way do you want to go? ");


        // Build map from Map object && player
        Map map = new Map();
        Room currentRoom = map.getCurrentRoom();

        Player player = new Player(currentRoom);


        // Player move / interaction
        while (true) {
            playerInput = scanner.nextLine();
            Room requestedRoom = player.currentRoom;

            switch (playerInput) {
                case "go north", "north", "n" -> {
                    requestedRoom = player.changeRoom("n");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                case "go east", "east", "e" -> {
                    requestedRoom = player.changeRoom("e");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                case "go south", "south", "s" -> {
                    requestedRoom = player.changeRoom("s");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                case "go west", "west", "w" -> {
                    requestedRoom = player.changeRoom("w");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                // if player looks
                case "look", "looking" -> {
                    System.out.println(currentRoom.getDescription());
                }

                // exit program
                case "exit", "quit" -> {
                    System.out.println("Killing program...");
                    System.exit(0);
                }

                // If player types help
                case "help", "h", "info" -> {
                    System.out.println("\nWelcome to the help menu:");
                    System.out.println("\tType 'go north', to go north");
                    System.out.println("\tType 'go east', to go east");
                    System.out.println("\tType 'go south', to go south");
                    System.out.println("\tType 'go west', to go west");
                    System.out.println("\tType 'look', to get a description of the room your currently in");
                    System.out.println("\tType 'exit' to quit the program");
                    System.out.println("\t- Good luck :)\n");
                    displayRoomDescription(player);
                }

            }

            if (requestedRoom == null) {
                System.out.println("You cannot go this way");
            }



        }



    }

    public static void displayRoomDescription(Player player) {
        System.out.println(player.getCurrentRoom().getDescription());

    }


}
