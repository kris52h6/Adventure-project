import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Intro
        System.out.println("Welcome to the adventure game.");


        // Start
        System.out.println("\nYou wake up on the side of a dirt path, your only options are: to head east, or: to head south.");
        System.out.print("Which way do you want to go? ");


        // Build map from Map object
        Map map = new Map();
        Room currentRoom = map.getCurrentRoom();

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
