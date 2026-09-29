package com.metromatch.domain.model;

public record CandidateLocation(String name, Location location) { //lugar a ser avaliado
    public CandidateLocation{
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Candidate Location name is null");
        }
        if(location()==null){
            throw new IllegalArgumentException("Candidate Location location is null");
        }
    }
}
