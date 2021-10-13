import java.util.Scanner;

public class Adventure {

    private static final Map map = new Map();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerInput = "";


        // Intro
        System.out.println("Welcome to the adventure game.");


        // Start
        System.out.println("\nYou wake up on the side of a dirt path, your only options are: to head west, or: to head east.");
        System.out.print("Which way do you want to go? ");

        System.out.println();


        // Build map from Map object && player
        Room currentRoom = map.getStartRoom();

        Player player = new Player(currentRoom);


        // Player move / interaction
        while (true) {
            playerInput = scanner.nextLine();
            Room requestedRoom = player.currentRoom;

            if (playerInput.contains("take")) {
                // defines the text followed by "take " as the argument to be sent to findItemFromRoom.
                int firstSpace = playerInput.indexOf(" ");
                String objToFind = playerInput.substring(firstSpace + 1);

                // declares item as the returned value from findItem method
                Item item = player.findItem(player.currentRoom.items,objToFind);
                player.takeItem(item);

                // prints result
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

                // declares item as the returned value from findItem method
                Item item = player.findItem(player.inventory, objToFind);
                player.dropItem(item);

                // prints result
                if (item != null) {
                    System.out.println("You've dropped " + item.getItemName() + " in the current room.");
                } else {
                    System.out.println("You don't have " + objToFind + " in your inventory.");
                }

            }

            if (playerInput.contains("use")) {
                int firstSpace = playerInput.indexOf(" ");
                String objToUse = playerInput.substring(firstSpace + 1);

                Item item = player.findItem(player.inventory,objToUse);
                player.useItem(item);

                if (item != null) {
                    System.out.println("\nYou've used " + item.getItemName());
                    player.useItem(item);
                    if (objToUse.equals("honey")) {
                        System.out.println("The honey distracts the bear, allowing you to use the tunnel.\n");
                    }
                    displayRoomDescription(player);
                } else {
                    System.out.println("You don't have " + objToUse + " in your inventory");
                }

            }

            if (playerInput.contains("eat")) {
                int firstSpace = playerInput.indexOf(" ");
                String objToEat = playerInput.substring(firstSpace + 1);
                boolean match = false;


                Item item = null;
                // checks inventory list & current room list for the specific item to eat.
                while (!match) {
                    for (int i  = 0; i < 2; i++) {
                        if (player.findItem(player.currentRoom.items, objToEat) != null) {
                            item = player.findItem(player.currentRoom.items, objToEat);
                            match = true;

                        } else if (player.findItem(player.inventory, objToEat) != null) {
                            item = player.findItem(player.inventory, objToEat);
                            match = true;
                        }
                    }
                }

                if (item != null) { // if item exits
                    CheckFood checkIfItemIsEdible = player.checkFoodType(item); // check if the item is edible
                    int itemHealth = item.getHealthPoints();

                    if (checkIfItemIsEdible == CheckFood.EDIBLE) { // if food is edible
                        player.eatFood(item);
                        System.out.println("You ate " + item.getItemName() + " you gain some health.");
                        player.addHealthPoints(itemHealth);

                    } else if (checkIfItemIsEdible == CheckFood.TOXIC) { // if food is edible, but toxic
                        player.eatFood(item);
                        System.out.println("You ate " + item.getItemName() + " you lose some health." );
                        player.removeHealthPoints(itemHealth);
                    }
                    else {
                        System.out.println(item.getItemName() + " is inedible!");
                    }
                }
                 else {
                    System.out.println("You don't have " + objToEat + " in your inventory.");
                }
                 String currentHealth = "Your current health is: " + player.getHealth();
                System.out.println(currentHealth);
            }

            if (playerInput.contains("equip")) {
                int firstSpace = playerInput.indexOf(" ");
                String objToEquip = playerInput.substring(firstSpace + 1);

                Item item = player.findItem(player.inventory, objToEquip);

                if (item != null) { // if item exits
                    CheckWeapon checkIfItemIsAWeapon = player.equipWeapon(item); // check if the item is weapon
                    if (checkIfItemIsAWeapon == CheckWeapon.MELEEWEAPON || checkIfItemIsAWeapon == CheckWeapon.SHOOTINGWEAPON ) {
                        System.out.println("You equip " + item.getItemName());
                    } else if (checkIfItemIsAWeapon == CheckWeapon.NOTWEAPON) {
                        System.out.println("ITEM IS NOT A WEAPON");
                        System.out.println("You can't equip " + item.getItemName() + " it's not a weapon." );
                    } else
                        System.out.println(objToEquip + " is not a weapon.");
                }
                else {
                    System.out.println("You don't have " + objToEquip + " in your inventory.");
                }
            }

            if (playerInput.contains("attack")) {
                int firstSpace = playerInput.indexOf(" ");
                String objToAttack = playerInput.substring(firstSpace + 1);

                Enemy enemy = player.findEnemy(player.currentRoom.enemies, objToAttack);

                if (player.getEquippedWeapon() != null) {
                    String weaponName = player.getEquippedWeapon().getItemName();
                    Weapon weapon = player.getEquippedWeapon();

                    // checks if weapon has uses
                    if (weapon.getAmmo() >= 1) {

                        // checks if the enemy exists in the room
                        if (enemy != null) {
                            System.out.println("You attack the " + objToAttack + " with your " + weaponName + ".");
                            boolean enemyAlive = player.attack(enemy);  // attacks enemy and returns boolean to check if enemy is alive.
                            String enemyHealthRemaining = objToAttack + " has " + enemy.getHealth() + " health remaining";
                            System.out.println(enemyHealthRemaining);

                            // if enemy is alive after player attack. it retaliates and attacks the player
                            if (enemyAlive) {
                                boolean playerAlive = enemy.attack(player); // attack player and returns boolean to check if player is alive
                                String enemyRetaliation = "The " + objToAttack + " fights back, hitting you with its " + enemy.getWeapon().getItemName();

                                System.out.println("\n");
                                System.out.println(enemyRetaliation);
                                if (playerAlive) {
                                    String playerHealthRemaining = "You've " + player.getHealth() + " health remaining, " + player.getHealthStatus();
                                    System.out.println(playerHealthRemaining);
                                } else if (!playerAlive) {
                                    System.out.println("You've died. Scrub");
                                    System.exit(0);
                                }

                            }// if enemy is dead
                            else {
                                System.out.println(objToAttack + " has died");
                            }

                        }// if theres no enemy matching the player input
                        else {
                            System.out.println("There's no enemy named " + objToAttack + " in this room!");
                        }

                    } // if theres no ammo in the equipped weapon
                    else {
                        System.out.println("You have no ammo!");
                    }

                // if player has no weapon equipped
                } else {
                    System.out.println("You have no weapon");
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

                case "health" -> {
                    String displayHealth = "Health: " + player.getHealth() + " - " +  player.getHealthStatus();
                    System.out.println(displayHealth);
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

                // If player types inventory
                case "inventory", "i", "inv" -> {
                    if (player.inventory.size() != 0) {
                        System.out.print("Your inventory contains: ");
                        String items = "";

                        for (int i = 0; i < player.inventory.size(); i++) {
                            items += player.inventory.get(i).getItemDescription() + ", ";
                        }

                        items = items.substring(0, items.length() - 2); // removes comma and space from the last item in the array
                        System.out.println(items);
                        System.out.println("\n");
                    } else {
                        System.out.println("Your inventory is empty.");
                    }

                    if (player.getEquippedWeapon() != null) {
                        System.out.println("Your equipped weapon is: " + player.getEquippedWeapon().getItemName());
                    }
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
        System.out.println("\tType 'use' followed by an 'item' to attempt to use said item in the current room");
        System.out.println("\tType 'eat' followed by an 'item' to attempt to eat said item in the current room");
        System.out.println("\tType 'equip' followed by an 'weapon' to attempt to equip said weapon in your inventory");
        System.out.println("\tType 'attack' followed by an 'enemy' to attempt attack said enemy in the current room");
        System.out.println("\t- Good luck :)\n");
    }

    public static void displayRoomDescription(Player player) {
        // print description
        String roomDescription = player.getCurrentRoom().getDescription();
        System.out.println(roomDescription);

        printItems(player, map);
        printEnemies(player, map);
    }

    public static void printItems(Player player, Map map) {
        String items = "";

        // print items
        if (player.getCurrentRoom().items.size() != 0) {
            System.out.print("\tThe room contains: ");
            for (int i = 0; i < player.getCurrentRoom().items.size(); i++) {
                items += player.currentRoom.items.get(i).getItemDescription() + ", ";
            }
            items = items.substring(0, items.length() -2); // removes comma and space from the last item in the array
            System.out.println(items);

        } else { // if room doesn't have any items
            System.out.println("\tThere's no items in this location.");
        }
    }

    public static void printEnemies(Player player, Map map) {
        String enemies = "";

        // print enemies
        if (player.getCurrentRoom().enemies.size() != 0) {
            System.out.print("\tEnemies in the room: ");
            for (int i = 0; i < player.getCurrentRoom().enemies.size(); i++) {
                enemies += player.currentRoom.enemies.get(i).getName() + ", ";
            }
            enemies = enemies.substring(0, enemies.length() -2); // removes comma and space from the last enemy in the array
            System.out.println(enemies);

        } else { // if room doesn't have any enemies
            System.out.println("\tThere's no enemies in this location.");
        }
    }
}
