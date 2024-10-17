package module1.lecture12;

public class Box {
    private int width;

    private int height;

    public void setWidth(final int value) {
        if (value < 0) {
            width = 0;
        } else {
            width = value;
        }
    }

    public void setHeight(final int value) {
        height = value;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void print() {
        System.out.println("Width: " + width + ", Height: " + height);
    }
}
