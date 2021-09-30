import java.util.Scanner;

public class Adventure {

    private static final Map map = new Map();

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
                int firstSpace = playerInput.indexOf(" ");
                String objToFind = playerInput.substring(firstSpace + 1);

                Item item = player.findItem(player.currentRoom, objToFind);

                if (item != null) {
                    System.out.println("You've picked up the " + item.getItemName());

                    player.addToInventory(item);
                    player.removeItemFromRoom(item);
                } else {
                    System.out.println("There's no " + objToFind + " in this room.");
                }
            }

            if (playerInput.contains("drop")) {
                // TODO drop items
                int firstSpace = playerInput.indexOf(" ");
                String objToFind = playerInput.substring(firstSpace + 1);

                Item item = player.findItemFromInventory(objToFind);

                if (item != null) {
                    System.out.println("You've dropped " + item.getItemName() + " in the current room.");
                    player.removeItemFromInventory(item);
                    player.placeItemInRoom(item);
                } else {
                    System.out.println("You don't have " + objToFind + " in your inventory.");
                }


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
                    System.out.print("Your inventory contains: ");
                    for (int i = 0; i < player.inventory.size(); i++) {
                        System.out.println(player.inventory.get(i).getItemDescription());
                    }
                    System.out.println("\n");
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
            System.out.print(map.getItemDescription(player.getCurrentRoom().items.get(i)) + ", ");
        }
        System.out.println("\n");


    }

}
