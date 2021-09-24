public class Room {
    private String name;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private String description;

        public Room(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public void setConnections(Room north, Room east, Room south, Room west) {
            this.north = north;
            this.east = east;
            this.south = south;
            this.west = west;
        }

        public void connectRoomsEast(Room nextRoom) {
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Room getNorth() {
            return north;
        }

        public Room getEast() {
            return east;
        }

        public Room getSouth() {
            return south;
        }

        public Room getWest() {
            return west;
        }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
