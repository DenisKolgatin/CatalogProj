package shop;

public abstract class OrderProcessor {

    public final void process(Order order) {
        validate(order);
        pay(order);
        ship(order);
        finish(order);
    }

    protected void validate(Order order) {
        if (order == null) throw new IllegalStateException("Order is null");
    }

    protected abstract void pay(Order order);

    protected void ship(Order order) {
        order.setStatus(OrderStatus.SHIPPED);
    }

    protected void finish(Order order) {
        order.setStatus(OrderStatus.DELIVERED);
    }
}
