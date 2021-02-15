import entity.AthletePerformance;
import entity.AthleteResult;
import org.junit.Test;
import service.RankScores;
import service.rank.RankScoresService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RankServiceTest {

    @Test
    public void shouldHaveTwoFirstPlace() {

        List<AthletePerformance> athletePerformances = Arrays.asList(
                DataLoader.with3099Decathlon(),
                DataLoader.with4203Decathlon(),
                DataLoader.with4374Decathlon(),
                DataLoader.with4374Decathlon()
        );

        RankScores service = new RankScoresService();

        List<AthleteResult> athleteResults = service.rank(athletePerformances);

        assertEquals(4, athleteResults.size());
        assertEquals(1, athleteResults.get(0).getRanking());
        assertEquals(1, athleteResults.get(1).getRanking());
        assertEquals(4374, athleteResults.get(0).getScore());
        assertEquals(4374, athleteResults.get(1).getScore());
    }

}
