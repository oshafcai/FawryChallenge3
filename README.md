# E-Commerce System — Fawry Quantum Internship Challenge 3

**Author:** Nadra Mahmoud Saad  
**Date:** July 4, 2025

## Project Overview

This project simulates a modular and maintainable e-commerce system built in Java.
It supports various types of products, customer interactions with a shopping cart, 
and a checkout system that handles validation, payment, and shipping. The goal was
to design a clean, extensible solution following industry-standard Object-Oriented
Design and SOLID principles, as required by the Fawry Rise Journey Full Stack Internship Challenge.

## Key Features

- Define products with name, price, and quantity
- Support for expirable products like Cheese and Milk
- Support for shippable products with weight like TV and Biscuits
- Handle non-shippable, non-expirable products like Scratch Cards
- Customers can:
  - Add products to cart with quantity validation
  - Checkout with subtotal and shipping
  - Receive errors for expired items, stock issues, or insufficient balance
- Checkout console output includes:
  - Shipment notice with items and total weight
  - Receipt with subtotal, shipping cost, total amount, and remaining balance

## Object-Oriented Design Principles

The project strictly follows the SOLID principles of OOP for flexibility, readability, and maintainability.

### Single Responsibility Principle (SRP)
Each class has one responsibility:
- Product classes handle product data and rules
- Cart handles shopping cart operations
- Customer manages personal balance and purchasing power
- CheckoutService coordinates the overall checkout flow

### Open/Closed Principle (OCP)
The code is open for extension but closed for modification:
- New product types (like DigitalProduct) can be added without modifying existing logic
- Behavior is extended through subclassing and interfaces

### Liskov Substitution Principle (LSP)
Subtypes are usable wherever their parent types are expected:
- All subclasses of Product (expirable, non-expirable, shippable) work seamlessly in the system

### Interface Segregation Principle (ISP)
Interfaces are kept specific and minimal:
- The Shippable interface defines only the methods required for shipping

### Dependency Inversion Principle (DIP)
High-level modules do not depend on low-level concrete classes:
- CheckoutService depends on the Shippable interface rather than specific product implementations

---
