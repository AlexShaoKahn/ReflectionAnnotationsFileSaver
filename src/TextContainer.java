import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SaveTo
public class TextContainer {
    private final String hello = "Hello world!";

    @Saver
    private void save(String filename) throws IOException {
        Path path = Paths.get(filename);
        byte[] strToBytes = hello.getBytes();
        Files.write(path, strToBytes);
    }
}
