// ObserverPatternTest.java
public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create a StockMarket (subject)
        StockMarket stockMarket = new StockMarket("AAPL", 150.00);

        // Create observers
        Observer mobileApp = new MobileApp("John's");
        Observer webApp = new WebApp("Jane's");

        // Register observers with the StockMarket
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price and notify observers
        System.out.println("Updating stock price...");
        stockMarket.setStockPrice(155.50);

        // Deregister an observer and update stock price again
        stockMarket.deregisterObserver(webApp);
        System.out.println("Updating stock price again...");
        stockMarket.setStockPrice(160.00);
    }
}

