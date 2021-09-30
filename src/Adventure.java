import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {

    private static Map map = new Map();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerInput = "";


        // Intro
        System.out.println("Welcome to the adventure game.");


        // Start
        System.out.println("\nYou wake up on the side of a dirt path, your only options are: to head east, or: to head south.");
        System.out.print("Which way do you want to go? ");

        System.out.println();


        // Build map from Map object && player
        Room currentRoom = map.getCurrentRoom();

        Player player = new Player(currentRoom);


        // Player move / interaction
        while (true) {
            playerInput = scanner.nextLine();
            Room requestedRoom = player.currentRoom;

            if (playerInput.contains("take")) {
                String objToFind = playerInput.substring(5);
                player.currentRoom.findItem(player.currentRoom, objToFind);

            }

            switch (playerInput) {
                // if player moves north
                case "go north", "north", "n" -> {
                    requestedRoom = player.changeRoom("n");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                // if player moves east
                case "go east", "east", "e" -> {
                    requestedRoom = player.changeRoom("e");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                // if player moves south
                case "go south", "south", "s" -> {
                    requestedRoom = player.changeRoom("s");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                // if player moves west
                case "go west", "west", "w" -> {
                    requestedRoom = player.changeRoom("w");
                    if (requestedRoom != null) {
                        displayRoomDescription(player);
                    }
                }

                // if player looks
                case "look", "looking" -> {
                    displayRoomDescription(player);
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

                case "inventory" -> {
                    // TODO show player inventory
                }

/*                case "take" -> {
                    // pick up an item
                    String nameTest = "lamp";
                    player.currentRoom.findItem(player.currentRoom, nameTest);
*//*
                    player.currentRoom.removeItem(player.currentRoom);
*//*

                    // theres no such thing in the room

                }*/

                case "drop" -> {
                    // TODO drop an item
                    // TODO you dont have an ... in your inventory
                }
            }

            if (requestedRoom == null) {
                System.out.println("You cannot go this way");
            }

        }

    }

    public static void displayRoomDescription(Player player) {
        // print description
        String roomDescription = player.getCurrentRoom().getDescription();
        System.out.println(roomDescription);

        // print items
        System.out.print("The room contains: ");
        for (int i = 0; i < player.getCurrentRoom().items.size(); i++) {
            System.out.print(map.getItemName(player.getCurrentRoom().items.get(i)) + ", ");
        }



    }

}
