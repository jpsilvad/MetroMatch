package com.metromatch.domain.service;

import com.metromatch.domain.model.CandidateLocation;
import com.metromatch.domain.model.Destination;

public final class CommuteCostCalculator {
    private final DistanceCalculator distanceCalculator;

    public CommuteCostCalculator(DistanceCalculator distanceCalculator){
        this.distanceCalculator = distanceCalculator;
    }

    public double calculateCost (CandidateLocation candidateLocation, Destination destination){
        double distance = distanceCalculator.calculateDistance(candidateLocation.location(), destination.location());
        return distance * destination.tripsPerWeek();
    }
}
