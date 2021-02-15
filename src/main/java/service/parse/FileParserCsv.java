package service.parse;

import entity.AthletePerformance;
import service.FileParser;
import service.ReadFile;
import util.StringConverterUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FileParserCsv implements FileParser {

    private ReadFile readFile;

    public FileParserCsv(ReadFile readFile) {
        this.readFile = readFile;
    }

    @Override
    public List<AthletePerformance> parse(String filePath) {
        List<String> strings = readFile.read(filePath);
        return strings.stream().map(this::map).collect(Collectors.toList());
    }

    private AthletePerformance map(String line) {

        String[] values = line.split(";");

        return new AthletePerformance.Builder(values[0])
                .sprint100m(StringConverterUtils.toDouble(values[1]))
                .longJump(StringConverterUtils.toDouble(values[2]))
                .shotPut(StringConverterUtils.toDouble(values[3]))
                .highJump(StringConverterUtils.toDouble(values[4]))
                .sprint400m(StringConverterUtils.toDouble(values[5]))
                .sprint110mHurdles(StringConverterUtils.toDouble(values[6]))
                .discusThrow(StringConverterUtils.toDouble(values[7]))
                .poleVault(StringConverterUtils.toDouble(values[8]))
                .javelinThrow(StringConverterUtils.toDouble(values[9]))
                .sprint1500m(StringConverterUtils.timeToSeconds(values[10]))
                .build();
    }
}
