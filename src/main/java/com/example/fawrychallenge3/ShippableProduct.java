/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * Represents a product that must be shipped.
 * Implements the Shippable interface and provides weight.
 *
 * SOLID Principles:
 * - ISP: Separates shipping concern from other classes.
 * - SRP: Only handles shipping-related product logic.
 *
 * Corner Cases Handled:
 * - Validates positive weight.
 */
package com.example.fawrychallenge3;
public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        if (weight <= 0) throw new IllegalArgumentException("Invalid weight.");
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public double getWeight() { return weight; }
}
