package shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() { return items; }

    public void add(Product p, int qty) {
        for (CartItem i : items) {
            if (i.product.getId().equals(p.getId())) {
                i.qty += qty;
                return;
            }
        }
        items.add(new CartItem(p, qty));
    }

    public double total() {
        return items.stream().mapToDouble(CartItem::total).sum();
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public void clear() { items.clear(); }
}