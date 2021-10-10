public class Food extends Item {
    private int healthPoints;
    private CheckFood type;

    public Food(String name, String description, int healthPoints, CheckFood type) {
        super(name, description);
        this.healthPoints = healthPoints;
        this.type = type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }



    public CheckFood getType() {
        return type;
    }

}
