package service;

import entity.AthletePerformance;

import java.util.List;

public interface FileParser {
    List<AthletePerformance> parse(String filePath);
}
