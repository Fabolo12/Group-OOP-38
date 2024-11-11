package module2.lecture2;

public class BmwFactory extends AbstractFactory {

    @Override
    public String getModel() {
        return "BMW X5";
    }

    @Override
    public String getColor() {
        return "Black";
    }

    @Override
    public int getYer() {
        return 2021;
    }
}
