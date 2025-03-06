package module3.lecture12;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy());

        //pay by credit card
        cart.pay(new CreditCardStrategy());
    }

    interface PaymentStrategy {
        void pay(int amount);
    }

    static class CreditCardStrategy implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid with credit/debit card");
        }
    }

    static class PaypalStrategy implements PaymentStrategy {

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid using Paypal.");
        }
    }


    record Item(String upcCode, int price) {

    }

    static class ShoppingCart {

        //List of items
        List<Item> items;

        public ShoppingCart() {
            this.items = new ArrayList<>();
        }

        public void addItem(Item item) {
            this.items.add(item);
        }

        public void removeItem(Item item) {
            this.items.remove(item);
        }

        public int calculateTotal() {
            int sum = 0;
            for (Item item : items) {
                sum += item.price();
            }
            return sum;
        }

        public void pay(PaymentStrategy paymentMethod) {
            int amount = calculateTotal();
            paymentMethod.pay(amount);
        }
    }
}
