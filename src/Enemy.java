public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;
    private Room currentRoom;

    public Enemy(String name,String description,int health, Weapon weapon, Room currentRoom) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
        this.currentRoom = currentRoom;
    }

    public int getHealth() {
        return health;
    }

    public boolean hit(int damage) {
        if (this.health > 0) {
            this.health -= damage;
            if (this.health <= 0) {
                die();
                return false;
            }
        } return true;
    }

    public void attack(Player player) {
        // TODO enemy retaliate
        player.hit(getWeapon().getDamage());
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void die() {
        // TODO: enemy dies
        dropWeapon(weapon);
        currentRoom.removeEnemy(this);
    }

    public void dropWeapon(Weapon weapon) {
        currentRoom.items.add(weapon);
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", health=" + health +
                ", weapon=" + weapon.getItemDescription() +
                '}';
    }

}

