public class Room {
    private Room north;
    private Room east;
    private Room south;
    private Room west;

        public Room() {
        }

        public void setRoom(Room north, Room east, Room south, Room west) {
            this.north = north;
            this.east = east;
            this.south = south;
            this.west = west;
        }

}
