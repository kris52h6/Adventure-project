import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create rooms
        for (int i = 0; i < 9; i++) {

        }

        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();
        room1.setRoom(null, room2, room4, null);

        // Intro
        System.out.println("Welcome to the adventure game");

        // Start
        System.out.println("Which way do you want to go?");

        // Move directions
        while (true) {
            String playerInput = scanner.nextLine();
            if (playerInput.equals("go north")) {
                System.out.println("Going north");
            } else if (playerInput.equals("go east")) {
                System.out.println("Going east");
            } else if (playerInput.equals("go south")) {
                System.out.println("Going south");
            } else if (playerInput.equals("go west")) {
                System.out.println("Going west");
            } else if (playerInput.equals("look")) {
                System.out.println("Looking around"); // skal outputte beskrivelsen af currentRoom
            }
        }


    }

}
