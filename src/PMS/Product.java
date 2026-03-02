package PMS;

import java.util.Comparator;

public abstract class Product {
    protected String productId;
    protected String name;
    protected double price;
    protected int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity)
    throws InvalidProductException
    {
        if(productId == null || name == null || price <= 0 || stockQuantity < 0){
            throw new InvalidProductException("Invalid Input");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public static Comparator<Product> NameComparator = Comparator.comparing(Product::getName);

    public void setName(String name) {
        this.name = name;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getProductId() {
        return productId;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }

    public abstract double calculateDiscount();
    public abstract String getProductType();

    public void reduceStock(int quantity) throws OutOfStockException, InvalidProductException{
        if(quantity == 0){
            throw new InvalidProductException("Quantity to be reduced by cannot be less than or equal to zero");
        }
        if(stockQuantity <= 0 || stockQuantity < quantity){
            throw new OutOfStockException("Not enough Inventory to reduce stock");
        }
        stockQuantity -= quantity;
        System.out.println("Stock has successfully been reduced");
    }

    public void applyTax(){
        //Asumption: Tax applied will be 6.5% of the initial price for all products
        double newPrice = price * 1.065;
        price = newPrice;
        System.out.println("Tax has been applied. New Price: " + newPrice);
    }

    public void displayProductInfo(){
        System.out.println("Product: [Product ID: "+ productId + " Product Name: " + name + " Price: " + price + " Stock Quantity: " + stockQuantity + "]");
    }

    public String toString(){
        return "Product{productId: " + productId + " name: " + name + " price: " + price + " stockQuantity: " + stockQuantity + "}";
    }
}
