public class Player {
    public Room currentRoom;
    private Room requestedRoom;


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
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
