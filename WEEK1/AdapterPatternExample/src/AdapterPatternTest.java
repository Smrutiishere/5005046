
// AdapterPatternTest.java
public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of the third-party gateways
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Create adapters for the gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        // Process payments using the adapters
        System.out.println("Testing PayPal Adapter:");
        payPalAdapter.processPayment(100.00);

        System.out.println("\nTesting Stripe Adapter:");
        stripeAdapter.processPayment(200.00);
    }
}
