package challenge.lv2;

public class Cart {
    private final MenuItem item;
    private int quantity = 1;

    public Cart(MenuItem item) {
        this.item = item;
    }

    public MenuItem getItem() {
        return item;
    }
    public void incQty()      {
        quantity++;
    }
    public int   getTotalPrice()   {
        return item.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return item.getName() + " | W " + item.getPrice()/100.0 + " | Qty " + quantity;
    }
}
