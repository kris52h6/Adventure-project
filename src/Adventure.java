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


        // Build map from Map object
        Map map = new Map();
        Room currentRoom = map.getCurrentRoom();

/*        Player player = new Player(currentRoom);
        System.out.println(player.getCurrentRoom());*/


        // Player move / interaction
        while (true) {
            playerInput = scanner.nextLine();

            switch (playerInput) {
                case "go north", "north", "n" -> {
                    if (currentRoom.getNorth() == null) {
                        System.out.println("\nYou cannot go this way");
                    }
                    else {
                        System.out.println("\nGoing north");
                        currentRoom = currentRoom.getNorth();
                        System.out.println(currentRoom.getDescription());
                    }
                }
                case "go east", "east", "e" -> {
                    if (currentRoom.getEast() == null) {
                        System.out.println("\nYou cannot go this way");
                    } else {
                        System.out.println("\nGoing east");
                        currentRoom = currentRoom.getEast();
                        System.out.println(currentRoom.getDescription());
                    }
                }

                case "go south", "south", "s" -> {
                    if (currentRoom.getSouth() == null) {
                        System.out.println("\nYou cannot go this way");
                    } else {
                        System.out.println("\nGoing south");
                        currentRoom = currentRoom.getSouth();
                        System.out.println(currentRoom.getDescription());
                    }
                }

                case "go west", "west", "w" -> {
                    if (currentRoom.getWest() == null) {
                        System.out.println("\nYou cannot go this way");
                    } else {
                        System.out.println("\nGoing west");
                        currentRoom = currentRoom.getWest();
                        System.out.println(currentRoom.getDescription());
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
                }

            }

        }

    }


}
