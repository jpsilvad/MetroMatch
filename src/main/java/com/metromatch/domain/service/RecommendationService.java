package com.metromatch.domain.service;

import com.metromatch.domain.model.CandidateLocation;
import com.metromatch.domain.model.Destination;
import com.metromatch.domain.model.Recommendation;

import java.util.Comparator;
import java.util.List;

public final class RecommendationService {

    private final CommuteCostCalculator commuteCostCalculator;

    public RecommendationService(CommuteCostCalculator commuteCostCalculator) {
        this.commuteCostCalculator = commuteCostCalculator;
    }

    public List<Recommendation> rank(
            List<CandidateLocation> candidateLocations,
            List<Destination> destinations
    ) {
        return candidateLocations.stream()
                .map(candidate -> new Recommendation(
                        candidate,
                        calculateTotalCost(candidate, destinations)
                ))
                .sorted(Comparator.comparingDouble(
                        Recommendation::commuteCost
                ))
                .toList();
    }

    private double calculateTotalCost(
            CandidateLocation candidateLocation,
            List<Destination> destinations
    ) {
        return destinations.stream()
                .mapToDouble(destination ->
                        commuteCostCalculator.calculateCost(
                                candidateLocation,
                                destination
                        )
                )
                .sum();
    }
}