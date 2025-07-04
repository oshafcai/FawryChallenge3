package com.example.fawrychallenge3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;

@SpringBootApplication
public class FawryChallenge3Application {

    public static void main(String[] args) {
        Customer customer = new Customer("Nadra", 1000);

        Product cheese = new ShippableProduct("Cheese", 100, 5, 0.2);     // 200g each
        Product biscuits = new ShippableProduct("Biscuits", 150, 2, 0.7); // 700g

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        CheckoutService checkout = new CheckoutService();
        checkout.checkout(customer, cart);
    }

  /* public static void main(String[] args) {
       System.out.println("====== CASE 1: Empty Cart ======");
       try {
           Customer customer1 = new Customer("Nadra", 1000);
           Cart emptyCart = new Cart();
           CheckoutService checkout = new CheckoutService();
           checkout.checkout(customer1, emptyCart);
       } catch (Exception e) {
           System.out.println("Expected error: " + e.getMessage());
       }

       System.out.println("\n====== CASE 2: Insufficient Balance ======");
       try {
           Customer customer2 = new Customer("LowBalanceUser", 50);
           Product cheese = new ShippableProduct("Cheese", 100, 5, 0.2);
           Cart cart = new Cart();
           cart.add(cheese, 1);
           CheckoutService checkout = new CheckoutService();
           checkout.checkout(customer2, cart);
       } catch (Exception e) {
           System.out.println("Expected error: " + e.getMessage());
       }

       System.out.println("\n====== CASE 3: Expired Product ======");
       try {
           Customer customer3 = new Customer("TestUser", 1000);
           Product expiredMilk = new ExpirableProduct("Milk", 50, 10, LocalDate.of(2023, 1, 1));
           Cart cart = new Cart();
           cart.add(expiredMilk, 1); // should throw on add
       } catch (Exception e) {
           System.out.println("Expected error: " + e.getMessage());
       }

       System.out.println("\n====== CASE 4: Quantity Exceeds Stock ======");
       try {
           Customer customer4 = new Customer("TestUser", 1000);
           Product tv = new ShippableProduct("TV", 500, 2, 7);
           Cart cart = new Cart();
           cart.add(tv, 3);
       } catch (Exception e) {
           System.out.println("Expected error: " + e.getMessage());
       }
   }
   */

}
