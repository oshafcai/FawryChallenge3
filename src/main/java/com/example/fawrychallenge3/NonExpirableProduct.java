/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * Represents non-expiring products (e.g., digital goods).
 * Always returns false for isExpired().
 *
 * SOLID Principles:
 * - LSP: Can be used wherever Product is expected.
 */
package com.example.fawrychallenge3;
public class NonExpirableProduct extends Product {
    public NonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
