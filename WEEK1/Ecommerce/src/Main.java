import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create some products
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Desk", "Furniture")
        };

        // Display the products
        System.out.println("Original Product List:");
        for (Product product : products) {
            System.out.println(product);
        }

        // Linear Search Example
        System.out.println("\nLinear Search Results:");
        Product linearResult = SearchAlgorithms.linearSearch(products, "Smartphone");
        System.out.println("Search Result: " + linearResult);

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        // Display sorted products
        System.out.println("\nSorted Product List:");
        for (Product product : products) {
            System.out.println(product);
        }

        // Binary Search Example
        System.out.println("\nBinary Search Results:");
        Product binaryResult = SearchAlgorithms.binarySearch(products, "P002");
        System.out.println("Search Result: " + binaryResult);

        // Binary Search for a non-existing product
        Product notFoundResult = SearchAlgorithms.binarySearch(products, "P999");
        System.out.println("Search Result for non-existing product: " + notFoundResult);
    }
}
