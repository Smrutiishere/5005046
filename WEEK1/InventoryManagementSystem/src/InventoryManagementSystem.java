import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {

    // Product class to represent a product in the inventory
    public static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

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

        @Override
        public String toString() {
            return "Product{" +
                    "productId='" + productId + '\'' +
                    ", productName='" + productName + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    '}';
        }
    }

    // Inventory management class
    public static class Inventory {
        private Map<String, Product> productMap;

        public Inventory() {
            this.productMap = new HashMap<>();
        }

        // Method to add a product to the inventory
        public void addProduct(Product product) {
            productMap.put(product.getProductId(), product);
        }

        // Method to update a product in the inventory
        public void updateProduct(String productId, Product updatedProduct) {
            if (productMap.containsKey(productId)) {
                productMap.put(productId, updatedProduct);
            } else {
                System.out.println("Product with ID " + productId + " does not exist.");
            }
        }

        // Method to delete a product from the inventory
        public void deleteProduct(String productId) {
            if (productMap.remove(productId) == null) {
                System.out.println("Product with ID " + productId + " does not exist.");
            }
        }

        // Method to display all products in the inventory
        public void displayProducts() {
            for (Product product : productMap.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of Inventory
        Inventory inventory = new Inventory();

        // Add some products
        inventory.addProduct(new Product("1", "Laptop", 10, 799.99));
        inventory.addProduct(new Product("2", "Smartphone", 25, 499.99));

        // Display all products
        System.out.println("All products:");
        inventory.displayProducts();

        // Update a product
        inventory.updateProduct("1", new Product("1", "Laptop", 15, 749.99));

        // Delete a product
        inventory.deleteProduct("2");

        // Display all products after update and delete
        System.out.println("\nProducts after update and delete:");
        inventory.displayProducts();
    }
}

