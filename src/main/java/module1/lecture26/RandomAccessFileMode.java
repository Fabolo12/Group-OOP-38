package module1.lecture26;

public enum RandomAccessFileMode {
    READ_WRITE("rw"),
    READ_ONLY("r");

    private final String mode;

    RandomAccessFileMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return mode;
    }
}
