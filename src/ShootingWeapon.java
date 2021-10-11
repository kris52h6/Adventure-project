public class ShootingWeapon extends Weapon{
    private int ammo;

    public ShootingWeapon(String name, String description,int damage, CheckWeapon weapon, int ammo) {
        super(name, description, damage ,weapon);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void attack() {
        useAmmo();
    }

    public void useAmmo() {
        this.ammo--;
    }
}
