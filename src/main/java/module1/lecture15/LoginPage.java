package module1.lecture15;

interface LoginSystemI {
    boolean isCorrect(String login, String password);
}

public class LoginPage {
    public static void main(String[] args) {
        final LoginSystemI loginSystem = new TokenLoginSystem();
        final boolean result = loginSystem.isCorrect("admin", "admin");
        System.out.println("Result: " + result);

        final boolean result2 = loginSystem.isCorrect("admin2", "admin2");
        System.out.println("Result2: " + result2);

        final boolean result3 = loginSystem.isCorrect("TOKEN:", null);
        System.out.println("Result3: " + result3);
    }
}

sealed class LoginSystem implements LoginSystemI permits TokenLoginSystem {
    public boolean isCorrect(final String login, final String password) {
        return login.equals("admin") && password.equals("admin");
    }
}

final class TokenLoginSystem extends LoginSystem {
    @Override
    public boolean isCorrect(final String login, final String password) {
        return login.startsWith("TOKEN:") || super.isCorrect(login, password);
    }
}


class FakeLoginSystem {
    public boolean isCorrect(final String login, final String password) {
        return true;
    }
}
