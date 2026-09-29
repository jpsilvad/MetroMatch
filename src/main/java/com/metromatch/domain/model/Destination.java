package com.metromatch.domain.model;

public record Destination(String name, Location location, int tripsPerWeek) { //destino da comutação recorrente do user
    public Destination{
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Destination name is null");
        }
        if(location()==null){
            throw new IllegalArgumentException("Destination location is null");
        }
        if(tripsPerWeek()<=0){
            throw new IllegalArgumentException("Trips per week is zero");
        }
    }
}
