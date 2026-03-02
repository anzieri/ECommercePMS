package PMS;

public class Clothing extends Product{
    int size;
    String material;
    String color;

    public Clothing(String productId, String name, double price,
                    int stockQuantity, int size ,String material, String color) throws InvalidProductException {
        if(productId == null || name == null || price <= 0 || stockQuantity < 0){
            throw new InvalidProductException("Invalid Input");

        } else if(size <0 || material == null || material == "" || color == null){
            throw new InvalidProductException("Size, color and material cannot be less than zero, null or empty respectively.");
        }
        super(productId, name, price, stockQuantity);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    @Override
    public double calculateDiscount() {
        if(stockQuantity <= 10){
            price = price * 0.9;
        }else if(stockQuantity <= 20){
            price = price * 0.6;
        }
        return price;
    }

    @Override
    public String getProductType() {
        return "Clothing";
    }

    public void displayProductInfo(){
        System.out.println("Clothing: [ Clothing ID: "+ productId +  " Product Name: " + name + " Price: " + price + " Stock Quantity: " + stockQuantity + " Size: "+ size + " Material: "+ material + " Color: "+ color + "]");
    }

    @Override
    public String toString() {
        return "Clothing: [ Clothing ID: "+ productId +  " Product Name: " + name + " Price: " + price + " Stock Quantity: " + stockQuantity + " Size: "+ size + " Material: "+ material + " Color: "+ color + "]";
    }
}
