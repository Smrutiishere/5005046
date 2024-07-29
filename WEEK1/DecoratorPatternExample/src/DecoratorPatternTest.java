// DecoratorPatternTest.java
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create a base email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Add SMS functionality to the email notifier
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Add Slack functionality to the SMS and email notifier
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a notification through all channels
        slackNotifier.send("Hello, this is a test message!");
    }
}

