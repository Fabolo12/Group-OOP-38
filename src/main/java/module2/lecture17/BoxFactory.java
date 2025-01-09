package module2.lecture17;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BoxFactory {

    private final List<FieldInfo> fieldsCondition;

    public BoxFactory() {
        fieldsCondition = initFieldsCondition();
    }

    public static void main(String[] args) {
        final BoxFactory boxFactory = new BoxFactory();
        Stream.of(
                new Box(0, 1, 1, "Test"),
                new Box(1, -1, 1, "Test"),
                new Box(1, 1, 0, "Test"),
                new Box(1, 1, 1, null),
                new Box(1, 1, 1, "Test")
        ).forEach(box -> {
            try {
                boxFactory.check(box);
                System.out.println("Box is valid");
            } catch (Exception e) {
                System.out.println("Box is invalid: " + e.getMessage());
            }
        });
    }

    public void check(Box box) {
        fieldsCondition.forEach(fieldInfo -> {
            try {
                switch (fieldInfo.fieldType()) {
                    case "int" -> checkIntCondition(fieldInfo, box);
                    case "String" -> checkStringCondition(fieldInfo, box);
                    default -> throw new IllegalArgumentException("Unsupported type: " + fieldInfo.fieldType());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void checkIntCondition(
            final FieldInfo fieldInfo,
            final Box box
    ) throws IllegalAccessException {
        final Field field = fieldInfo.field();
        final int additional = fieldInfo.additional();
        final String rule = fieldInfo.rule();

        switch (rule) {
            case "!=" -> {
                if (field.getInt(box) == additional) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is " + additional);
                }
            }
            case ">=" -> {
                if (field.getInt(box) < additional) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is less"
                            + " than " + additional);
                }
            }
            case ">" -> {
                if (field.getInt(box) <= additional) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is less"
                            + " than or equal to " + additional);
                }
            }
            default -> throw new IllegalArgumentException("Unsupported rule: " + rule);
        }
    }

    private void checkStringCondition(
            final FieldInfo fieldInfo,
            final Box box
    ) throws IllegalAccessException {
        final Field field = fieldInfo.field();
        final String rule = fieldInfo.rule();
        switch (rule) {
            case "is not null" -> {
                if (field.get(box) == null) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is null");
                }
            }
            case "is null" -> {
                if (field.get(box) != null) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is not null");
                }
            }
            default -> throw new IllegalArgumentException("Unsupported rule: " + rule);
        }
    }

    private List<FieldInfo> initFieldsCondition() {
        final Class<Box> boxClass = Box.class;
        return Arrays.stream(boxClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Checker.class))
                .map(field -> {
                    field.setAccessible(true);
                    final Checker annotation = field.getAnnotation(Checker.class);
                    return new FieldInfo(
                            field,
                            annotation.rule(),
                            annotation.additional(),
                            field.getType().getSimpleName()
                    );
                })
                .toList();
    }

    record FieldInfo(
            Field field,
            String rule,
            int additional,
            String fieldType
    ) {
    }
}
