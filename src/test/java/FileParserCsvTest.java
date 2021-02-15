import entity.AthletePerformance;
import org.junit.Test;
import service.FileParser;
import service.parse.FileParserCsv;
import service.read.ReadFileCsv;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileParserCsvTest {

    @Test
    public void shouldParseCsvFromResourcesFolder() {

        FileParser fileParser = new FileParserCsv(new ReadFileCsv());

        List<AthletePerformance> athletePerformances = fileParser.parse("src/main/resources/results.csv");

        assertEquals(4, athletePerformances.size());
        assertEquals("John Smith", athletePerformances.get(0).getName());
        assertEquals("Foo Bar", athletePerformances.get(3).getName());

    }

}
