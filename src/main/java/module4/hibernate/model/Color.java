package module4.hibernate.model;

public enum Color {
    BLACK(255, 255, 255),
    WHITE(0, 0, 0);

    private int colorCodeRed;

    private int colorCodeGreen;

    private int colorCodeBlue;

    Color(final int colorCodeRed, final int colorCodeGreen, final int colorCodeBlue) {
        this.colorCodeRed = colorCodeRed;
        this.colorCodeGreen = colorCodeGreen;
        this.colorCodeBlue = colorCodeBlue;
    }


}
