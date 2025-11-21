package shop;

public class CartItem {
    public final Product product;
    public int qty;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public double total() {
        return product.getPrice() * qty;
    }
}