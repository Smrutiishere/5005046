// StrategyPatternTest.java
public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Test Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "Saismruti");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(100.00);

        System.out.println();

        // Test PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("saismruti.123@gmail.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(200.00);
    }
}
