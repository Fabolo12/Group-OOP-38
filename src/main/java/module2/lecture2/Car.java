package module2.lecture2;

public class Car {
    private String model;
    private String color;
    private int year;

    public void setModel(final String model) {
        this.model = model;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
