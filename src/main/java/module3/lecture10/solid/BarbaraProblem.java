package module3.lecture10.solid;

import java.util.Random;

public class BarbaraProblem {
    public static void main(String[] args) {
        final ParentSender sender = new Random().nextBoolean() ? new ParentSender() : new ChildSenderCorrect();

        System.out.println("Notification was send by email: " + sender.sendNotificationByEmail());
        System.out.println("Notification was send by sms: " + sender.sendNotificationBySms());
    }

    static class ParentSender {
        public boolean sendNotificationByEmail() {
            System.out.println("Email sent");
            return true;
        }

        public boolean sendNotificationBySms() {
            System.out.println("Sms sent");
            return true;
        }
    }

    static class ChildSender extends ParentSender {
        @Override
        public boolean sendNotificationByEmail() {
            System.out.print("***\n");
            super.sendNotificationByEmail();
            System.out.print("***\n");
            return true;
        }

        @Override
        public boolean sendNotificationBySms() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    static class ChildSenderCorrect extends ParentSender {
        @Override
        public boolean sendNotificationByEmail() {
            System.out.print("***\n");
            super.sendNotificationByEmail();
            System.out.print("***\n");
            return true;
        }

        @Override
        public boolean sendNotificationBySms() {
            return false;
        }
    }
}
