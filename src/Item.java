public class Item {
    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getItemName() {
        return name;
    }

    public String getItemDescription() {
        return description;
    }

}
