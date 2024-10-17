package module1.lecture10;

public class Main4 {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin";
        String jdk13 = "jdk-13";

        System.out.println("Original path: " + path);
        System.out.println("New path: " + changePath("/", path, jdk13));
    }

    private static String changePath(
            final String delimiter,
            final String path,
            final String jdkVersion
    ) {
        final String[] parts = path.split(delimiter);
        final int index = parts.length - 1;
        parts[index] = jdkVersion;
        return String.join(delimiter, parts);
    }
}
