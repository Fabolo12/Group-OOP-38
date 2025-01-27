package module2.module;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configure {
    public static final Map<Creature, Map<Creature, Integer>> eatMapping = new HashMap<>();

    public Configure() {
        addWolfConfigure();
        addRabbitConfigure();

        Properties prop = new Properties();
        initProp(prop);

        System.out.println("Wolf will eat rabbit with " + eatMapping.get(Creature.WOLF).get(Creature.RABBIT) + " probability");
        System.out.println("Wolf will eat rabbit with " + prop.getProperty("wolf.rabbit") + " probability");
    }

    public static void main(String[] args) {
        new Configure();
    }

    private void initProp(final Properties prop) {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/module2/eatconfig.properties")) {
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private void addWolfConfigure() {
        Map<Creature, Integer> wolfMap = new HashMap<>();
        wolfMap.put(Creature.RABBIT, 60);
        eatMapping.put(Creature.WOLF, wolfMap);
    }

    private void addRabbitConfigure() {
        Map<Creature, Integer> grassMap = new HashMap<>();
        grassMap.put(Creature.GRASS, 100);
        eatMapping.put(Creature.RABBIT, grassMap);
    }
}
