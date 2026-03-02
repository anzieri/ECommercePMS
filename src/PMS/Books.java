package PMS;

public class Books extends Product{
    String author;
    String publisher;
    String isbn;

    public Books(String productId, String name, double price, int stockQuantity, String author, String publisher, String isbn) throws InvalidProductException {

        if(productId == null || name == null || price <= 0 || stockQuantity < 0){
            throw new InvalidProductException("Invalid Input");

        } else if(author.isEmpty() || publisher.isEmpty() || isbn.isEmpty()){
            throw new InvalidProductException("Author,ISBN and publisher cannot be empty");
        }
        super(productId, name, price, stockQuantity);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;

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
        return "Book";
    }

    public void displayProductInfo(){
        System.out.println("Books: [ Book ID: "+ productId + " Book name: " + name + " Price: "+ price + " StockQuantity: "+stockQuantity+ " Author: " +author+ " Publisher: " +publisher+ " ISBN: "+ isbn + "]");
    }

    public String toString(){
        return "Books: [ Book ID: "+ productId + " Book name: " + name + " Price: "+ price + " StockQuantity: "+stockQuantity+ " Author: " +author+ " Publisher: " +publisher+ " ISBN: "+ isbn + "]";
    }
}
