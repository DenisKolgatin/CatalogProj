package shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ShopService shop = new ShopService(new SimpleOrderProcessor());
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Товары\n2. Добавить в корзину\n3. Корзина\n4. Оформить\n5. Трекинг\n6. Вернуть\n0. Выход");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "1":
                    shop.getProducts().forEach(System.out::println);
                    break;

                case "2":
                    System.out.print("ID: ");
                    Product p = shop.find(sc.nextLine());
                    if (p != null) {
                        cart.add(p, Constants.DEFAULT_QTY);
                        System.out.println("Добавлено");
                    } else System.out.println("Нет товара");
                    break;

                case "3":
                    cart.getItems().forEach(i -> System.out.println(i.product + " x" + i.qty));
                    System.out.println("Итого: " + cart.total());
                    break;

                case "4":
                    if (cart.isEmpty()) {
                        System.out.println("Корзина пуста");
                        break;
                    }
                    Order o = shop.createOrder(cart);
                    System.out.println("Создан заказ: " + o.getId());
                    shop.processOrder(o.getId());
                    break;

                case "5":
                    System.out.print("ID: ");
                    System.out.println(shop.track(sc.nextLine()));
                    break;

                case "6":
                    System.out.print("ID: ");
                    shop.returnOrder(sc.nextLine());
                    System.out.println("Возврат оформлен");
                    break;

                case "0":
                    return;
            }
        }
    }
}
