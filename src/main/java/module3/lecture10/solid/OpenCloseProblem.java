package module3.lecture10.solid;

public class OpenCloseProblem {
    public void sendNotificationByEmail() {
        System.out.println("Email sent");
    }

    public void sendNotificationBySms() {
        System.out.println("Sms sent");
    }

    public void sendNotificationByPush() {
        System.out.println("Push sent");
    }
}

interface NotificationSender {
    void sendNotification();
}

class EmailNotificationSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Email sent");
    }
}

class SmsNotificationSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Sms sent");
    }
}

class PushNotificationSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Push sent");
    }
}

class NotificationService {
    public void sendNotification() {
        final String notificationType = System.getProperty("notificationType");
        NotificationSender sender =  switch (notificationType) {
            case "email" -> new EmailNotificationSender();
            case "sms" -> new SmsNotificationSender();
            case "push" -> new PushNotificationSender();
            default -> throw new IllegalArgumentException("Invalid notification type");
        };
        sender.sendNotification();
    }
}