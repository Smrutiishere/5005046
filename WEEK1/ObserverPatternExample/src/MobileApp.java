// MobileApp.java
public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " MobileApp: Stock " + stockName + " updated to $" + stockPrice);
    }
}
