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
                // defines the text followed by "take " as the argument to be sent to findItemFromRoom.
                int firstSpace = playerInput.indexOf(" ");
                String objToFind = playerInput.substring(firstSpace + 1);

                Item item = player.findItemFromRoom(objToFind);

                if (item != null) {
                    System.out.println("You've picked up the " + item.getItemName());
                } else {
                    System.out.println("There's no " + objToFind + " in this room.");
                }
            }

            if (playerInput.contains("drop")) {
                // defines the text followed by "drop " as the argument to be sent to findItemFromInventory.
                int firstSpace = playerInput.indexOf(" ");
                String objToFind = playerInput.substring(firstSpace + 1);

                Item item = player.findItemFromInventory(objToFind);

                if (item != null) {
                    System.out.println("You've dropped " + item.getItemName() + " in the current room.");
                } else {
                    System.out.println("You don't have " + objToFind + " in your inventory.");
                }

            }

            if (playerInput.contains("use")) {
                int firstSpace = playerInput.indexOf(" ");
                String objToUse = playerInput.substring(firstSpace + 1);

                Item item = player.useItemFromInventory(objToUse);


                if (item != null) {
                    System.out.println("You've used " + item.getItemName());
                    player.useItem(item);
                } else {
                    System.out.println("You don't have " + objToUse + " in your inventory");
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
                    printHelp(); // prints help
                    displayRoomDescription(player); // calls description after help

                }

                case "inventory" -> {
                    System.out.print("Your inventory contains: ");
                    for (int i = 0; i < player.inventory.size(); i++) {
                        System.out.print(player.inventory.get(i).getItemDescription() + ", ");
                    }
                    System.out.println("\n");
                }

            }
            if (requestedRoom == null) {
                System.out.println("You cannot go this way");
            }
        }
    }

    private static void printHelp() {
        System.out.println("\nWelcome to the help menu:");
        System.out.println("\tType 'go north', to go north");
        System.out.println("\tType 'go east', to go east");
        System.out.println("\tType 'go south', to go south");
        System.out.println("\tType 'go west', to go west");
        System.out.println("\tType 'look', to get a description of the room your currently in");
        System.out.println("\tType 'exit' to quit the program");
        System.out.println("\tType 'take' followed by an 'item' to take said item from the current room");
        System.out.println("\tType 'drop' followed by an 'item' to drop said item in the current room");
        System.out.println("\tType 'inventory' to view the items you're carrying around.");
        System.out.println("\t- Good luck :)\n");
    }

    public static void displayRoomDescription(Player player) {
        // print description
        String roomDescription = player.getCurrentRoom().getDescription();
        System.out.println(roomDescription);

        // print items
        if (player.getCurrentRoom().items.size() != 0) {
            System.out.print("The room contains: ");
            for (int i = 0; i < player.getCurrentRoom().items.size(); i++) {
                System.out.print(map.getItemDescription(player.getCurrentRoom().items.get(i)) + ", ");
            }
            System.out.println("\n");

        } else {
            System.out.println("There's no items in this location.");
        }
    }


}
