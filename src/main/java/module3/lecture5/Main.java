package module3.lecture5;

import lombok.SneakyThrows;
import module3.lecture4.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    @SneakyThrows
    public static void main(String[] args) {

        final List<Object> objects = new ArrayList<>();
        objects.add(1);
        LOGGER.debug("Ini state: {}", objects.size());
        clearIncorrect(objects);
        clearDuplication(objects);

//        final Object o = objects.get(10);

//        System.out.println(o);
    }

    private static void clearIncorrect(final List<Object> objects) {
        LOGGER.info("Init state before clear incorrect: {}", objects.size());
        // TODO 03.02.2025
        LOGGER.info("Init state after clear incorrect: {}", objects.size());
    }

    private static void clearDuplication(final List<Object> objects) {
        LOGGER.info("Init state before clear duplication: {}", objects.size());
        // TODO 03.02.2025
        LOGGER.info("Init state after clear duplication: {}", objects.size());
    }
}
