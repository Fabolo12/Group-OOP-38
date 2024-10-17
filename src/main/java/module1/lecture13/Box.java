package module1.lecture13;

import java.util.Objects;

public class Box {
    private String title;

    private int width;

    private int height;

    private int weight;

    private Box innerBox;

    public Box() {
        this(10, 10, 10);
    }

    public Box(
            final int height
    ) {
        this(height, 1, 1);
    }

    public Box(
            final int height,
            final int weight
    ) {
        this(height, weight, 1);
    }

    public Box(
            final int height,
            final int weight,
            final int width
    ) {
        this.height = getValueOrZero(height);
        this.weight = getValueOrZero(weight);
        this.width = getValueOrZero(width);
        this.title = "BoxObject";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = getValueOrZero(width);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = getValueOrZero(height);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = getValueOrZero(weight);
    }

    private int getValueOrZero(final int value) {
//        return value < 0 ? 0 : value;
        return Math.max(value, 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Box box) {
//            BoxObject box = (BoxObject) obj;
            return this.height == box.height
                    && this.weight == box.weight
                    && this.width == box.width;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight, width);
    }
}
