package shop;

public class SimpleOrderProcessor extends OrderProcessor {
    // Принцип L (Liskov Substitution) — подкласс можно использовать вместо базового класса без нарушения поведения
    @Override
    protected void pay(Order order) {
        order.setStatus(OrderStatus.PAID);
    }
}