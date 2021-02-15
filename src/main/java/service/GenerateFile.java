package service;

import entity.AthleteResult;

import java.util.List;

public interface GenerateFile {
    void generate(List<AthleteResult> results);
}
