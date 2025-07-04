/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * This class is responsible for handling all shipping-related output.
 * It accepts a list of CartItems that implement the Shippable interface
 * and prints shipment details such as item weight and total weight.
 *
 * SOLID Principles:
 * - SRP: Only handles displaying shipment info.
 * - DIP: Depends on interface (Shippable), not concrete classes.
 *
 * Corner Cases Handled:
 * - Ignores shipping if list is empty.
 */
package com.example.fawrychallenge3;
import java.util.List;

public class ShippingService {
    public void ship(List<CartItem> items) {
        if (items.isEmpty()) return;
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (CartItem item : items) {
            double weight = ((Shippable) item.getProduct()).getWeight() * item.getQuantity();
            totalWeight += weight;
            System.out.printf("%dx %-12s %.0fg%n", item.getQuantity(), item.getProduct().getName(), weight * 1000);
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}

