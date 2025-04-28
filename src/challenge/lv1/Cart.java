package challenge.lv1;
public class Cart {
    private final MenuItem item;
    private int quantity;

    public Cart(MenuItem item) {
        this.item = item;
        this.quantity = 1;
    }
    public MenuItem getItem()   {
        return item;
    }
    public void incQty()        {
        quantity++;
    }

    public int getTotalPrice()      {
        return item.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return item.getName() + " | W " + (item.getPrice()) + " | Qty " + quantity;
    }
}
