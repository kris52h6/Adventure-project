public class Item {
    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, int healthPoints) {
        this.name = name;
        this.description = description;
    }

    public String getItemName() {
        return name;
    }

    public String getItemDescription() {
        return description;
    }

    public CheckFood getType() {
        CheckFood type = null;
        return type;
    }

    public int getHealthPoints() {
        int healthPoints = 0;
        return healthPoints;
    }

}
