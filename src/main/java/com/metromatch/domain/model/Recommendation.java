package com.metromatch.domain.model;

public record Recommendation(CandidateLocation candidateLocation, double commuteCost) {
    public Recommendation{
        if(candidateLocation==null){
            throw new IllegalArgumentException("Candidate Location is null");
        }
        if(commuteCost<0){
            throw new IllegalArgumentException("commute Cost is less than zero");
        }
    }

}
