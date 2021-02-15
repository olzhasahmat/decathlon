package service;

import enums.Decathlon;

public interface CalculateEvent {
    int calculate(double score, Decathlon decathlon);
}
