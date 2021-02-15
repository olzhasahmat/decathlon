package service.calculate;

import enums.Decathlon;
import service.CalculateEvent;

public class CalculateEventTrack implements CalculateEvent {
    @Override
    public int calculate(double score, Decathlon decathlon) {
        Double result = decathlon.getA() * Math.pow(decathlon.getB() - score, decathlon.getC());
        return result.intValue();
    }
}
