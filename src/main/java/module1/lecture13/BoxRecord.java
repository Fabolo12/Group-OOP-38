package module1.lecture13;

public record BoxRecord(int width) {

    public BoxRecord(final int width) {
        this.width = width;
    }

    public BoxRecord() {
        this(10);
    }

    public int doubleWidth() {
        return width * 2;
    }
}
