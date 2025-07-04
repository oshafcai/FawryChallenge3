/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * Represents an item and quantity added to a cart.
 * Calculates total price and weight.
 *
 * SOLID Principles:
 * - SRP: Encapsulates cart-item-specific logic.
 *
 * Corner Cases Handled:
 * - Validates availability and expiry on creation.
 */
package com.example.fawrychallenge3;
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (!product.isAvailable(quantity)) throw new IllegalArgumentException("Unavailable or expired product.");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public double getTotalPrice() {
        return quantity * product.getPrice();
    }

    public boolean isShippable() {
        return product instanceof Shippable;
    }

    public double getWeight() {
        return isShippable() ? ((Shippable) product).getWeight() * quantity : 0;
    }

    public String getName() { return product.getName(); }
}

