import java.util.ArrayList;

public class Player {
    public Room currentRoom;
    private Room requestedRoom;

    ArrayList<Item> inventory = new ArrayList<>();


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addToInventory(Item objectToAdd) {
        inventory.add(objectToAdd);
    }

    public void removeItemFromRoom(Item result) {
        currentRoom.items.remove(result);
/*
        items.remove(result);
*/
    }

    public Item findItem(Room currentRoom, String objToFind) {
        Item result = null;
        for (int i = 0; i < currentRoom.items.size(); i++ ) {
            if (currentRoom.items.get(i).getItemName().equals(objToFind)) {
                result = currentRoom.items.get(i);
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
                System.out.println("you have said item");
            } else {
                System.out.println("you don't have said item");
            }
        }
        return result;
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
