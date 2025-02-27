package module3.lecture10.solid;

public class SingleResponsibilityProblem {
    public String createEmailBody() {
        return "Email body";
    }

    public void sendEmail(final String emailBody) {
        System.out.println("Email sent: " + emailBody);
    }
}

class EmailBuilder {
    public String createEmailBody() {
        return "Email body";
    }
}

class EmailSender {
    public void sendEmail(final String emailBody) {
        System.out.println("Email sent: " + emailBody);
    }
}

class EmailService {
    public void sendEmail() {
        final EmailBuilder emailBuilder = new EmailBuilder();
        final EmailSender emailSender = new EmailSender();
        final String emailBody = emailBuilder.createEmailBody();
        emailSender.sendEmail(emailBody);
    }
}