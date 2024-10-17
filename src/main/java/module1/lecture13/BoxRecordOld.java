package module1.lecture13;

public class BoxRecordOld {
    private final int width;

    public BoxRecordOld(final int width) {
        this.width = width;
    }

    public BoxRecordOld() {
        this(10);
    }

    public int getWidth() {
        return width;
    }

    public int doubleWidth() {
        return width * 2;
    }
}
