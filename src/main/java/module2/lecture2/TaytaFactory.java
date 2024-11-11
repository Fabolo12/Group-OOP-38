package module2.lecture2;

public class TaytaFactory extends AbstractFactory {

    @Override
    public String getModel() {
        return "Tayta Corolla";
    }

    @Override
    public String getColor() {
        return "White";
    }

    @Override
    public int getYer() {
        return 2021;
    }
}
