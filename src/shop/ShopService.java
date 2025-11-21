package shop;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private final List<Product> products = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private final OrderProcessor processor;

    public ShopService(OrderProcessor processor) {
        this.processor = processor;

        products.add(new Product("p1", "Phone", 500));
        products.add(new Product("p2", "Laptop", 900));
        products.add(new Product("p3", "Book", 20));
    }

    public List<Product> getProducts() { return products; }

    public Product find(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Order createOrder(Cart cart) {
        double total = cart.total() + cart.total() * Constants.TAX;
        Order o = new Order(new ArrayList<>(cart.getItems()), total);
        orders.add(o);
        cart.clear();
        return o;
    }

    public void processOrder(String id) {
        orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .ifPresent(processor::process);
    }

    public Order track(String id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    public void returnOrder(String id) {
        orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .ifPresent(o -> o.setStatus(OrderStatus.RETURNED));
    }
}
