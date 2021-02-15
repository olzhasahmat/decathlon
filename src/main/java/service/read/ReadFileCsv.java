package service.read;

import service.ReadFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileCsv implements ReadFile {
    @Override
    public List<String> read(String filePath) {
        try (Stream<String> stream = stream(Optional.ofNullable(filePath).orElse(""))) {
            return stream
                    .filter(x -> x != null && ! x.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Stream<String> stream(String filePath) throws IOException, URISyntaxException {
        Path path = Paths.get(filePath);

        if (Files.exists(path) && !Files.isDirectory(path)) {
            System.out.println("File exists : " + path);
            return Files.lines(Paths.get(filePath));
        }

        return Files.lines(Paths.get(getClass().getResource("/results.csv").toURI()));
    }
}
