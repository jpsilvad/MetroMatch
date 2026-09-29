package com.metromatch.domain.model;

public record Location(double latitude, double longitude) { //posicao geografica
    public Location{
        if(latitude<-90 || latitude>90) throw new IllegalArgumentException("Latitude is not between -90 and 90.");
        if(longitude<-180 || longitude>180) throw new IllegalArgumentException("Longitude is not between -180 and 180.");
    }
}
