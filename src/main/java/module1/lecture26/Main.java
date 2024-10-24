package module1.lecture26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

public class Main {
    private static final String PATH = "src/main/java/module1/lecture26/text.txt";

    public static void main(String[] args) {
//        tryWithResources();
//        nioExample();
//        pathExample();
//        fileExample();
        readFromRecourse();
        readFromRecourseProperties();
    }

    private static void readFromRecourseProperties() {
        final Properties prop = new Properties();
        final String configPath = "config/configuration.properties";
        try (final InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream(configPath)) {
            prop.load(resourceAsStream);

            System.out.println(prop.getProperty("name"));
            System.out.println(prop.getProperty("group"));
            System.out.println(prop.getProperty("module"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void readFromRecourse() {
        // non static - this.getClass().getClassLoader();
        final ClassLoader classLoader = Main.class.getClassLoader();
        final String configPath = "config/configuration.properties";
        try (
                final InputStream resourceAsStream = classLoader.getResourceAsStream(configPath);
                final InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
                final BufferedReader reader = new BufferedReader(inputStreamReader)
        ) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileExample() {
        final File file = Path.of(PATH).toFile();
        System.out.println("File: " + file);
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is exists: " + file.exists());

        final File root = new File("src/main/java");
        printFileSystem(root, "");
    }

    private static void printFileSystem(final File root, final String prefix) {
        if (root.isDirectory()) {
            System.out.println(prefix + " " + root.getName() + "/");
            final File[] files = root.listFiles();
            if (files != null) {
                final List<File> listOfFiles = new ArrayList<>(List.of(files));
                listOfFiles.sort(new FileComparator());

                for (File f : listOfFiles) {
                    printFileSystem(f, prefix + "-");
                }
            }
        } else {
            System.out.println(prefix + " " + root.getName());
        }
    }

    private static void pathExample() {
        final Path path = Path.of(PATH);
        System.out.println("Path: " + path);
        System.out.println("File name: " + path.getFileName());
        System.out.println("Is absolute: " + path.isAbsolute());
    }

    private static void nioExample() {
        try (RandomAccessFile aFile = new RandomAccessFile(PATH, RandomAccessFileMode.READ_ONLY.toString())) {
            final FileChannel inChannel = aFile.getChannel();
            final ByteBuffer buf = ByteBuffer.allocate(100);
            int bytesRead = inChannel.read(buf);

            while (bytesRead > 0) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tryWithResources() {
        // try-with-resources
        try (
                final BufferedReader fileReader = new BufferedReader(new FileReader(PATH));
                final Resource resource = new Resource(new InnerResource())
        ) {
            while (fileReader.ready()) {
                final String line = fileReader.readLine();
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Resource implements AutoCloseable {
        private final InnerResource innerResource;

        public Resource(final InnerResource innerResource) {
            this.innerResource = innerResource;
        }

        @Override
        public void close() {
            innerResource.close();
            System.out.println("Resource closed");
        }
    }

    static class InnerResource implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Inner resource closed");
        }
    }

    static class FileComparator implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            if (o1.isFile()) {
                return -1;
            }
            if (o2.isFile()) {
                return 0;
            }

            if (o1.isDirectory()) {
                return 1;
            }
            if (o2.isDirectory()) {
                return 0;
            }

            return -1;
        }
    }
}
