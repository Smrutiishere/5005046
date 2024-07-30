public class SearchAlgorithms {

    // Linear search
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductId().equals(searchTerm) ||
                product.getProductName().equalsIgnoreCase(searchTerm) ||
                product.getCategory().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary search (assuming the array is sorted by productId)
    public static Product binarySearch(Product[] products, String searchTerm) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];

            // Compare product IDs
            int comparison = searchTerm.compareTo(midProduct.getProductId());
            if (comparison == 0) {
                return midProduct;
            }

            if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null; // Not found
    }
}
