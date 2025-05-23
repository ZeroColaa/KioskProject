package challenge.lv2;

public class MenuItem {
    private final String name;
    private final int    price;
    private final String description;

    public MenuItem(String name, int price, String description) {
        this.name = name;  this.price = price;  this.description = description;
    }

    public String getName()        { return name; }
    public int    getPrice()       { return price; }


    @Override
    public String toString() {
        return name + " | W " + price/100.0 + " | " + description;
    }
}
