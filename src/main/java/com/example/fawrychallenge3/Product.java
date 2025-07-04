
/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * Product is an abstract base class that represents any item in the store.
 * It holds shared properties like name, price, and quantity.
 * It defines an abstract method isExpired(), which subclasses must implement
 * to determine if the product is valid for purchase.
 *
 * SOLID Principles:
 * - SRP: This class focuses only on shared product attributes.
 * - OCP: We can extend this with expirable/non-expirable types.
 *
 * Corner Cases Handled:
 * - Prevents creation with negative price or quantity.
 */
package com.example.fawrychallenge3;
public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        if (price < 0 || quantity < 0) throw new IllegalArgumentException("Invalid product data.");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract boolean isExpired();

    public boolean isAvailable(int requestedQuantity) {
        return quantity >= requestedQuantity && !isExpired();
    }

    public void reduceQuantity(int amount) {
        if (amount > quantity) throw new IllegalStateException("Not enough stock.");
        quantity -= amount;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }
}
