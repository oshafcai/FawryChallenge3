/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * Interface for items that can be shipped.
 * Used by ShippingService.
 *
 * SOLID Principles:
 * - ISP: Defines only the methods required for shipping.
 */
package com.example.fawrychallenge3;
public interface Shippable {
    String getName();
    double getWeight();
}
