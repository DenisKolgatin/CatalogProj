package shop;

public class SimpleOrderProcessor extends OrderProcessor {
    @Override
    protected void pay(Order order) {
        order.setStatus(OrderStatus.PAID);
    }
}