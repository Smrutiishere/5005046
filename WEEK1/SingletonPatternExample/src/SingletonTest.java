public class SingletonTest {
        public static void main(String[] args) {
            Logger logger1 = Logger.getInstance();
            Logger logger2 = Logger.getInstance();
    
            // Both logger1 and logger2 should refer to the same instance
            System.out.println(logger1 == logger2); // Expected output: true
    
            logger1.log("Hello, World!");
            logger2.log("This is another log message.");
        }
    }

