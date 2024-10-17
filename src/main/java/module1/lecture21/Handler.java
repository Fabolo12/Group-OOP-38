package module1.lecture21;

public class Handler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(final Thread t, final Throwable e) {
        System.out.println("An exception has been captured");
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace();
    }
}
