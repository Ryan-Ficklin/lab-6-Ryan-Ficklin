import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileProcessor {
    public static void processFile(String filePath, String outFilePath) throws IOException {
        File infile = new File(filePath);
        FileWriter outFileWriter = new FileWriter(outFilePath);
        List<Point> points = new ArrayList<>();
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                points.add(new Point(line));
            }
            List<Point> noiselessPoints = points.stream()
                    .filter((p) -> p.getZ() <= 2)
                    .map((p) -> p.scale(0.5))
                    .map((p) -> p.translate(-150, -37))
                    .collect(Collectors.toList());
            for(Point point: noiselessPoints){
                outFileWriter.write(point.toString() + "\n");
            }
            outFileWriter.close();
            System.out.println("Successfully wrote to file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
