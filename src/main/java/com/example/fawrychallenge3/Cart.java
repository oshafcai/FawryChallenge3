/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * This class represents a customer's shopping cart.
 * It holds multiple CartItem objects and provides methods
 * to calculate subtotal, shipping cost, total weight, and shippable items.
 *
 * SOLID Principles:
 * - SRP: Focused only on managing cart items and related calculations.
 * - OCP: Easily extended for coupons, discounts, etc.
 *
 * Corner Cases Handled:
 * - Prevents adding items if product is unavailable or expired.
 * - getShippingCost handles empty shippable list safely.
 */
package com.example.fawrychallenge3;
import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            throw new IllegalArgumentException("Product is expired or not enough stock.");
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double getShippingCost() {
        return getTotalWeight() * (27.27);
    }

    public double getTotalWeight() {
        return items.stream().mapToDouble(CartItem::getWeight).sum();
    }

    public List<CartItem> getShippableItems() {
        List<CartItem> shippables = new ArrayList<>();
        for (CartItem item : items) {
            if (item.isShippable()) shippables.add(item);
        }
        return shippables;
    }

    public void clear() {
        items.clear();
    }
}
