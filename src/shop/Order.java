package shop;

import java.util.List;
import java.util.UUID;

public class Order {
    private final String id = UUID.randomUUID().toString();
    private final List<CartItem> items;
    private final double total;
    private OrderStatus status = OrderStatus.CREATED;

    public Order(List<CartItem> items, double total) {
        this.items = items;
        this.total = total;
    }

    public String getId() { return id; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus s) { this.status = s; }

    @Override
    public String toString() {
        return "Order " + id + " | status=" + status + " | total=" + total;
    }
}