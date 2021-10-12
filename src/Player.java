import java.util.ArrayList;

public class Player {
    public Room currentRoom;
    public Room startRoom;
    private Room requestedRoom;
    private int health;
    private Weapon equippedWeapon;

    ArrayList<Item> inventory = new ArrayList<>();
    ArrayList<Item> equipmentList = new ArrayList<>();


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.startRoom = currentRoom;
        this.health = 100;
    }


    public void removeItemFromRoom(Item result) {
        currentRoom.items.remove(result);
    }

    public void placeItemInRoom(Item item) {
        currentRoom.items.add(item);
    }

    public void dropItem(Item result) {
        removeItemFromInventory(result);
        placeItemInRoom(result);
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    public void takeItem(Item item) {
        addItemToInventory(item);
        removeItemFromRoom(item);
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public Item findItem(ArrayList<Item> list, String itemName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getItemName().equals(itemName)) {
                return list.get(i);
            }
        }
        return null;
    }

    public Enemy findEnemy(ArrayList<Enemy> list, String itemName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(itemName)) {
                return list.get(i);
            }
        }
        return null;
    }

    public void useItem(Item item) {
        if (item.getItemName().equals("honey") && currentRoom.getName().equals("Tunnel")) {
            currentRoom = startRoom;
        }
    }


    // controls room
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room changeRoom(String direction) {

        switch (direction) {
            case "go north", "north", "n" -> {
                requestedRoom = this.currentRoom.getNorth();
            }
            case "go east", "east", "e" -> {
                requestedRoom = this.currentRoom.getEast();
            }
            case "go south", "south", "s" -> {
                requestedRoom = this.currentRoom.getSouth();
            }
            case "go west", "west", "w" -> {
                requestedRoom = this.currentRoom.getWest();
            }
            
        }
        if (requestedRoom != null) {
            this.currentRoom = requestedRoom;
        }
        return requestedRoom;
    }


    // Player health
    public CheckFood eatFood(Item food) {
        removeItemFromInventory(food);
        removeItemFromRoom(food);
        return food.getFoodType();
    }

    public int getHealth() {
        return health;
    }

    public String getHealthStatus() {
        int health = getHealth();
        String statusString = "";
        if (health >= 25) {
            statusString = "You're low on health, be careful.";
        } if (health >= 50) {
            statusString = "You're in decent shape.";
        } if (health >= 75) {
            statusString = "You're very healthy.";
        }
        return statusString;
    }

    public void addHealthPoints(int healthToBeAdded) {
        this.health += healthToBeAdded;
    }

    public void removeHealthPoints(int healthToBeRemoved) {
        this.health -= healthToBeRemoved;
    }

    // player equipment
    public CheckWeapon equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        removeItemFromInventory(weapon);
        return weapon.getWeaponType();
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    // attack methods
    public boolean attack(Enemy enemy) {
        return enemy.hit(getEquippedWeapon().getDamage());
    }

    public boolean hit(int damage) {
        // TODO PLAYER GETS HIT
        if (this.health > 0) {
            this.health -= damage;
            if (this.health <= 0) {
                return false;
            }
        } return true;
    }

}
