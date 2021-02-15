package enums;

import service.CalculateEvent;
import service.calculate.CalculateEventField;
import service.calculate.CalculateEventJump;
import service.calculate.CalculateEventTrack;

public enum Decathlon {
    _100_M(new CalculateEventTrack(), 25.4347, 18.0, 1.81),
    LONG_JUMP(new CalculateEventJump(), 0.14354, 220.0, 1.4),
    SHOT_PUT(new CalculateEventField(), 51.39, 1.5, 1.05),
    HIGH_JUMP(new CalculateEventJump(), 0.8465, 75.0, 1.42),
    _400_M(new CalculateEventTrack(), 1.53775, 82.0, 1.81),
    _110_M_HURDLES(new CalculateEventTrack(), 5.74352, 28.5, 1.92),
    DISCUS_THROW(new CalculateEventField(), 12.91, 4.0, 1.1),
    POLE_VAULT(new CalculateEventJump(), 0.2797, 100.0, 1.35),
    JAVELIN_THROW(new CalculateEventField(), 10.14, 7.0, 1.08),
    _1500_M(new CalculateEventTrack(), 0.03768, 480.0, 1.85);

    private CalculateEvent calculateEvent;
    private double a;
    private double b;
    private double c;

    Decathlon(CalculateEvent calculateEvent, double a, double b, double c) {
        this.calculateEvent = calculateEvent;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public int calculate(double score) {
        return calculateEvent.calculate(score, this);
    }
}
