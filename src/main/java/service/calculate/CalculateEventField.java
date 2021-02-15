package service.calculate;

import enums.Decathlon;
import service.CalculateEvent;

public class CalculateEventField implements CalculateEvent {
    @Override
    public int calculate(double score, Decathlon decathlon) {
        Double result = decathlon.getA() * Math.pow(score - decathlon.getB(), decathlon.getC());
        return result.intValue();
    }
}
