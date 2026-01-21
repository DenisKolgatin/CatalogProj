package shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    // Принцип S (Single Responsibility) — класс отвечает только за управление содержимым корзины

    public List<CartItem> getItems() { return items; }

    public void add(Product p, int qty) {
        for (CartItem i : items) { //избегание магических чисел
            if (i.product.getId().equals(p.getId())) {
                i.qty += qty;    // предотвращаем дубликаты товаров в корзине
                return;
            }
        }
        items.add(new CartItem(p, qty));
    }
    // DRY + выразительность — используем stream вместо ручного цикла суммирования
    public double total() {
        return items.stream().mapToDouble(CartItem::total).sum();
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public void clear() { items.clear(); }
}