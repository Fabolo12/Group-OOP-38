package module1.lecture20;

import java.time.LocalDate;

public class Person {
    private final String name;

    private final LocalDate interaction;

    public Person(final String name) {
        this.name = name;
        this.interaction = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public LocalDate getInteraction() {
        return interaction;
    }
}
