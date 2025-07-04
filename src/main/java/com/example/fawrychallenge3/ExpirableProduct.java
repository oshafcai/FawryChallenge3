package com.example.fawrychallenge3;

/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * This class represents products that have an expiration date (e.g., Cheese).
 * It overrides isExpired() to compare against the current date.
 *
 * SOLID Principles:
 * - SRP: Handles only expiry-related logic.
 * - OCP: Easily extendable with different expiry rules.
 *
 * Corner Cases Handled:
 * - Checks if product is expired before allowing purchase.
 */
import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
