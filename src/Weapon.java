public abstract class Weapon extends Item{
    private int damage;
    private final CheckWeapon weapon;

    public Weapon(String name, String description,int damage,CheckWeapon weapon) {
        super(name, description);
        this.damage = damage;
        this.weapon = weapon;
    }

    public CheckWeapon getWeaponType() {
        return this.weapon;
    }

    public int getAmmo() {
        int ammo = 10000;
        return ammo;
    }

    public int getDamage() {
        return damage;
    }

   /* public void attack(Enemy enemy) {
        removeHealth(enemy, damage);
    }

    public void removeHealth(Enemy enemy, int damage) {
        enemy.hit(damage);
    }*/

}
