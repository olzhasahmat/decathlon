package service;

import entity.AthletePerformance;
import entity.AthleteResult;

import java.util.List;

public interface RankScores {
    List<AthleteResult> rank(List<AthletePerformance> athletesPerformance);
}
