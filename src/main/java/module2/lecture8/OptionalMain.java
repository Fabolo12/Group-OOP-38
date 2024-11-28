package module2.lecture8;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        /*final Optional<String> s1 = method3(false);
        System.out.println(s1.toString());
        final Optional<String> s2 = method3(true);
        System.out.println(s2.toString());*/

        final Optional<String> optionalWithValue = getOptional("Hello");
        final Optional<String> optionalWithoutValue = getOptional(null);

//        getValue(optionalWithValue);
//        getValue(optionalWithoutValue);
//        ifPresentValue(optionalWithValue);
//        ifPresentValue(optionalWithoutValue);
//        orElse(optionalWithValue);
//        orElse(optionalWithoutValue);
//        orElseGet(optionalWithValue);
//        orElseGet(optionalWithoutValue);
//        orElseThrow(optionalWithValue);
//        orElseThrow(optionalWithoutValue);
//        or(optionalWithValue);
//        or(optionalWithoutValue);
//        filter(optionalWithValue);
//        filter(optionalWithoutValue);
//        map(optionalWithValue);
//        map(optionalWithoutValue);
//        flatMap(optionalWithValue);
//        flatMap(optionalWithoutValue);
        ifPresentOrElse(optionalWithValue);
        ifPresentOrElse(optionalWithoutValue);

    }

    private static void ifPresentOrElse(final Optional<String> optional) {
        optional.ifPresentOrElse(
                s -> System.out.println("Value: " + s),
                () -> System.out.println("No value")
        );

        optional.ifPresentOrElse(
                s -> {
                    // Do something with the value
                },
                () -> System.out.println("No value")
        );
    }

    private static void flatMap(final Optional<String> optional) {
        optional.flatMap(OptionalMain::method3)
                .ifPresent(System.out::println);
        optional.map(OptionalMain::method3)
                .ifPresent(System.out::println);
    }

    private static Optional<Integer> method3(final String line) {
        return Optional.of(line.length());
    }

    private static void map(final Optional<String> optional) {
        optional.map(String::length)
                .ifPresent(System.out::println);
    }

    private static void filter(final Optional<String> optional) {
        optional.filter(s -> s.length() > 3)
                .ifPresent(System.out::println);
    }

    private static void or(final Optional<String> optional) {
        final Optional<String> withDefaultValue = optional.or(() -> Optional.of("Default value"));
        withDefaultValue.ifPresent(System.out::println);
    }

    private static void orElseThrow(final Optional<String> optional) {
        final String value = optional.orElseThrow(() -> new IllegalArgumentException("No value"));
        System.out.println("Value: " + value);
    }

    private static void orElseGet(final Optional<String> optional) {
        final String value = optional.orElseGet(OptionalMain::getDefaultValue);
        System.out.println("Value: " + value);
    }

    private static String getDefaultValue() {
        return "Default value";
    }

    private static void orElse(final Optional<String> optional) {
        final String value = optional.orElse("Default value");
        System.out.println("Value: " + value);
    }

    private static void ifPresentValue(final Optional<String> optional) {
        optional.ifPresent(s -> System.out.println("Value: " + s));
        optional.ifPresent(System.out::println);
    }

    private static void getValue(final Optional<String> optional) {
        if (optional.isPresent()) {
            System.out.println("Value: " + optional.get());
        }
        if (optional.isEmpty()) {
            System.out.println("No value");
        }
    }

    private static Optional<String> getOptional(final String line) {
        return Optional.ofNullable(line);
    }

    private static Optional<String> method3(final boolean exit) {
        return exit ? Optional.empty() : Optional.of("Hello");
    }
}
