package module3.lecture12;

import java.util.stream.Stream;

public class Command {

    public static void main(String[] args) {
        //Creating the receiver object
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem("Windows");

        Stream.of(new OpenFileCommand(fs), new WriteFileCommand(fs), new CloseFileCommand(fs))
                .forEach(Commands::execute);
    }

    interface FileSystemReceiver {
        void openFile();

        void writeFile();

        void closeFile();
    }

    interface Commands {
        void execute();
    }

    static class UnixFileSystemReceiver implements FileSystemReceiver {

        @Override
        public void openFile() {
            System.out.println("Opening file in unix OS");
        }

        @Override
        public void writeFile() {
            System.out.println("Writing file in unix OS");
        }

        @Override
        public void closeFile() {
            System.out.println("Closing file in unix OS");
        }
    }

    static class WindowsFileSystemReceiver implements FileSystemReceiver {

        @Override
        public void openFile() {
            System.out.println("Opening file in Windows OS");

        }

        @Override
        public void writeFile() {
            System.out.println("Writing file in Windows OS");
        }

        @Override
        public void closeFile() {
            System.out.println("Closing file in Windows OS");
        }
    }

    static class OpenFileCommand implements Commands {

        private FileSystemReceiver fileSystem;

        public OpenFileCommand(FileSystemReceiver fs) {
            this.fileSystem = fs;
        }

        @Override
        public void execute() {
            //open command is forwarding request to openFile method
            this.fileSystem.openFile();
        }
    }

    static class CloseFileCommand implements Commands {

        private FileSystemReceiver fileSystem;

        public CloseFileCommand(FileSystemReceiver fs) {
            this.fileSystem = fs;
        }

        @Override
        public void execute() {
            this.fileSystem.closeFile();
        }
    }

    static class WriteFileCommand implements Commands {

        private FileSystemReceiver fileSystem;

        public WriteFileCommand(FileSystemReceiver fs) {
            this.fileSystem = fs;
        }

        @Override
        public void execute() {
            this.fileSystem.writeFile();
        }
    }

    static class FileInvoker {

        public Commands command;

        public FileInvoker(Commands c) {
            this.command = c;
        }

        public void execute() {
            this.command.execute();
        }
    }

    static class FileSystemReceiverUtil {

        public static FileSystemReceiver getUnderlyingFileSystem(final String osName) {
            System.out.println("Underlying OS is:" + osName);
            if (osName.contains("Windows")) {
                return new WindowsFileSystemReceiver();
            } else {
                return new UnixFileSystemReceiver();
            }
        }

    }
}
