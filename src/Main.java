import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Expected exactly 2 arguments: file names.");
        }
        String filePath = args[0];
        String outFilePath = args[1];
        FileProcessor.processFile(filePath, outFilePath);
    }
}