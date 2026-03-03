package PMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Assessment 3: Mid-Term Practical Test
 * Student: Amara Nyanzi
 * Date: 31/01/2026
 * Problem:  Integrated System
 *
 * Key Features:
 * - Inheritance, Abstraction, Polymorphism, Encapsulation
 * - Checked and Unchecked Exceptions handled
 * - Basic logic implemented
 */
public class ProductTest {
    public static void main(String[] args) {
        // Test scenario that might throw multiple exceptions
        try {
            Product laptop = new Electronics("E001", "Laptop", 200, 100, 5,65);
            Product book = new Books("B002", "Who Moved My Cheese", 1800, 280, "John Snow", "Fast Publishers", "820276398D");
            laptop.reduceStock(15); // More than available stock
            laptop.calculateDiscount();
            laptop.applyTax();
            System.out.println(laptop.getProductType());
            laptop.displayProductInfo();
            List<Product> products = new ArrayList<>();
            products.add(book);
            products.add(laptop);
            System.out.println("Before: " + products);

            Collections.sort(products, Product.NameComparator);
            System.out.println("After: " +products);
        } catch (InvalidProductException | OutOfStockException e){
            System.out.println(e.getMessage());
        }
    }
}
