import java.util.ArrayList;

public class Player {
    public Room currentRoom;
    public Room startRoom;
    private Room requestedRoom;

    ArrayList<Item> inventory = new ArrayList<>();


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.startRoom = currentRoom;

    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromRoom(Item result) {
        currentRoom.items.remove(result);
    }

    public Item findItemFromRoom(String objToFind) {
        Item result = null;
        for (int i = 0; i < currentRoom.items.size(); i++ ) {
            if (currentRoom.items.get(i).getItemName().equals(objToFind)) {
                result = currentRoom.items.get(i);
                addToInventory(result);
                removeItemFromRoom(result);
            }
        }
        return result;
    }

    public void placeItemInRoom(Item item) {
        currentRoom.items.add(item);
    }

    public void removeItemFromInventory(Item result) {
        inventory.remove(result);
    }

    public Item findItemFromInventory(String objToFind) {
        Item result = null;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemName().equals(objToFind)) {
                result = inventory.get(i);
                removeItemFromInventory(result);
                placeItemInRoom(result);
            }
        }
        return result;
    }

    public Item useItemFromInventory(String objToUse) {
        Item result = null;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemName().equals(objToUse)) {
                result = inventory.get(i);
                useItem(inventory.get(i));
            }
        }
        return result;
    }

    public void useItem(Item item) {
        if (item.getItemName().equals("honey") && currentRoom.getName().equals("Tunnel")) {
            currentRoom = startRoom;
        }
    }

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


}
