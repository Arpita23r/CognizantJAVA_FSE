package inventory.management;

// Class to represent a product
public class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor to initialize a product
    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString method to display product details
    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + 
               ", Quantity: " + quantity + ", Price: $" + price;
    }
}
