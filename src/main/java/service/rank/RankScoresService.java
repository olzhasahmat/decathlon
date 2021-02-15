package service.rank;

import entity.AthletePerformance;
import entity.AthleteResult;
import service.RankScores;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankScoresService implements RankScores {
    private Map<Integer, Integer> mapScoreOrder;

    @Override
    public List<AthleteResult> rank(List<AthletePerformance> athletesPerformance) {
        mapScoreOrder = new HashMap<>();
        athletesPerformance
                .sort(Comparator
                        .comparing(AthletePerformance::decathlon)
                        .reversed());
        return athletesPerformance
                .stream()
                .map(this::mapResult)
                .collect(Collectors.toList());
    }

    private AthleteResult mapResult(AthletePerformance athletePerformance) {
        int decathlon = athletePerformance.decathlon();

        if (! mapScoreOrder.containsKey(decathlon)) {
            mapScoreOrder.put(decathlon, mapScoreOrder.size() + 1);
        }

        return new AthleteResult(athletePerformance.getName(), decathlon, mapScoreOrder.get(decathlon));
    }
}
