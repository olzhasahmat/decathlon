import entity.AthletePerformance;
import entity.AthleteResult;
import service.FileParser;
import service.GenerateFile;
import service.RankScores;
import service.ReadFile;
import service.generate.GenerateFileXml;
import service.parse.FileParserCsv;
import service.rank.RankScoresService;
import service.read.ReadFileCsv;

import java.util.List;

public class DecathlonApp {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFileCsv();
        FileParser fileParser = new FileParserCsv(readFile);
        RankScores rankScores = new RankScoresService();
        GenerateFile generateFile = new GenerateFileXml();

        String filePath = args[0];

        List<AthletePerformance> performances = fileParser.parse(filePath);
        List<AthleteResult> results = rankScores.rank(performances);
        generateFile.generate(results);
    }
}
