public abstract class Weapon extends Item{
    private CheckWeapon weapon;

    public Weapon(String name, String description, CheckWeapon weapon) {
        super(name, description);
        this.weapon = weapon;
    }

    public CheckWeapon getWeaponType() {
        return this.weapon;
    }

}
