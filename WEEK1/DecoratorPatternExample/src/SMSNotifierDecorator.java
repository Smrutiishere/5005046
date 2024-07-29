
public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the method of the base notifier
        sendSMS(message);    // Add SMS functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}
