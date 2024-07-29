// WebApp.java
public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " WebApp: Stock " + stockName + " updated to $" + stockPrice);
    }
}
