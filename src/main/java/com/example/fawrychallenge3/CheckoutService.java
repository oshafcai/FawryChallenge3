/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * This class coordinates the full checkout process.
 * It validates the cart and customer, performs stock checks,
 * calculates totals, processes shipping, and prints receipts.
 *
 * SOLID Principles:
 * - SRP: Focused on orchestrating checkout only.
 * - DIP: Relies on ShippingService (which uses interface).
 *
 * Corner Cases Handled:
 * - Empty cart → error.
 * - Expired or unavailable product → error.
 * - Insufficient balance → error.
 * - Skips shipping if no shippable items.
 */
package com.example.fawrychallenge3;
import java.util.List;

public class CheckoutService {
    private ShippingService shippingService = new ShippingService();

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty.");

        for (CartItem item : cart.getItems()) {
            if (!item.getProduct().isAvailable(item.getQuantity())) {
                throw new IllegalStateException("Product unavailable or expired: " + item.getProduct().getName());
            }
        }

        double subtotal = cart.getSubtotal();
        double shipping = cart.getShippingCost();
        double total = subtotal + shipping;

        if (!customer.canPay(total)) {
            throw new IllegalStateException("Insufficient balance.");
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        List<CartItem> toShip = cart.getShippableItems();
        shippingService.ship(toShip);

        customer.deduct(total);

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", shipping);
        System.out.printf("Amount           %.0f%n", total);
        System.out.printf("Balance          %.0f%n", customer.getBalance());

        cart.clear();
    }
}
