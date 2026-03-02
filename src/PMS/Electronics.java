package PMS;

public class Electronics extends Product{
    int warrantyPeriod;
    double powerConsumption;

    public Electronics(String productId, String name, double price, int stockQuantity, int warrantyPeriod, double powerConsumption) throws InvalidProductException {

        if(productId == null || name == null){
            throw new InvalidProductException("Invalid Input. Please reevalute productID and name. Cannot be null");
        } else if(warrantyPeriod<0 || powerConsumption<0 || price <= 0 || stockQuantity < 0){
            throw new InvalidProductException("Invalid price, stockQuantity , warranty period or power consumption. Cannot be zero or less than zero");
        }else if(powerConsumption>2400){
            throw new InvalidProductException("Invalid powerConsumption. Wattage cannot be greater than 2400");
        } else if (warrantyPeriod>5) {
            throw new InvalidProductException("Invalid warrantyPeriod. Warranty period can only range from 1 to 5years");
        }
        super(productId, name, price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
        this.powerConsumption = powerConsumption;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
    public double getPowerConsumption() {
        return powerConsumption;
    }
    public int getWarrantyPeriod() {
        return warrantyPeriod;
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
        return "Electronics";
    }

    @Override
    public void displayProductInfo(){
        System.out.println("Electronics: [ Electronic ID: " + productId + " Product Name: " + name + " Price: " + price + " Stock Quantity: " + stockQuantity + "Warranty Period: "+ warrantyPeriod + "Power Consumption: " + powerConsumption + "]" );
    }

    @Override
    public String toString() {
        return "Electronics: [ Electronic ID: " + productId + " Product Name: " + name + " Price: " + price + " Stock Quantity: " + stockQuantity + "Warranty Period: "+ warrantyPeriod + "Power Consumption: " + powerConsumption + "]";
    }
}
