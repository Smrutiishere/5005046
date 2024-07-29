// ProxyPatternTest.java
public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image is loaded and displayed only when needed
        System.out.println("First request:");
        image1.display(); // Image will be loaded from server

        System.out.println("\nSecond request:");
        image1.display(); // Image will be displayed from cache

        System.out.println("\nThird request:");
        image2.display(); // New image is loaded from server
    }
}


