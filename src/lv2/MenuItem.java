package lv2;


public class MenuItem {

    public String name;
    public int price;
    public String description;

    public MenuItem(String name, int price, String description){

        this.name=name;
        this.price=price;
        this.description=description;
    }

    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }
}
