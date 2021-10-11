public class ShootingWeapon extends Weapon{
    private int ammo;

    public ShootingWeapon(String name, String description, CheckWeapon weapon, int ammo) {
        super(name, description, weapon);
        this.ammo = ammo;
    }
}
