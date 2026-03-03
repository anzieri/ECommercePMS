package PMS;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ProductJUnitTest {

    private Electronics validLaptop;
    private Books validBook;
    private Clothing validShirt;

    @Before
    public void setUp() throws InvalidProductException {
        validLaptop = new Electronics("E001", "Laptop", 1000.0, 15, 2, 500.0);
        validBook = new Books("B001", "Java Fundamentals", 50.0, 8, "Duke", "TechPress", "1234567890");
        validShirt = new Clothing("C001", "T-Shirt", 20.0, 25, 42, "Cotton", "Blue");
    }

    @Test
    public void testValidProductCreation() {
        assertEquals("Laptop", validLaptop.getName());
        assertEquals(1000.0, validLaptop.getPrice(), 0.001);
        assertEquals("Book", validBook.getProductType());
    }

    @Test(expected = InvalidProductException.class)
    public void testInvalidProductExceptionThrownForNullName() throws InvalidProductException {
        new Electronics("E002", null, 500.0, 10, 1, 100.0);
    }

    @Test(expected = InvalidProductException.class)
    public void testInvalidProductExceptionThrownForHighPowerConsumption() throws InvalidProductException {
        new Electronics("E003", "Heater", 100.0, 10, 1, 2500.0);
    }

    @Test
    public void testReduceStockSuccess() throws InvalidProductException, OutOfStockException {
        validLaptop.reduceStock(5);
        assertEquals(10, validLaptop.getStockQuantity());
    }

    @Test(expected = OutOfStockException.class)
    public void testOutOfStockExceptionThrownWhenReducingTooMuch() throws InvalidProductException, OutOfStockException {
        validLaptop.reduceStock(20);
    }

    @Test(expected = InvalidProductException.class)
    public void testReduceStockThrowsExceptionForZeroQuantity() throws InvalidProductException, OutOfStockException {
        validLaptop.reduceStock(0);
    }

    @Test
    public void testCalculateDiscountApplies10Percent() {
        double discountedPrice = validBook.calculateDiscount();
        assertEquals(45.0, discountedPrice, 0.001);
    }

    @Test
    public void testNameComparatorSorting() {
        List<Product> products = Arrays.asList(validShirt, validBook, validLaptop);
        Collections.sort(products, Product.NameComparator);

        assertEquals("Java Fundamentals", products.get(0).getName());
        assertEquals("Laptop", products.get(1).getName());
        assertEquals("T-Shirt", products.get(2).getName());
    }
}