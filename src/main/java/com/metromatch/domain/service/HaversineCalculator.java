package com.metromatch.domain.service;

import com.metromatch.domain.model.Location;
public final class HaversineCalculator implements DistanceCalculator{
   private static final double EARTH_RADIUS_KM = 6371.0;

   double haversine(double val){
       return Math.pow(Math.sin(val/2),2);
   }

    @Override
    public double calculateDistance(Location origin, Location destination) {
        double longitudeDifference = Math.toRadians(destination.longitude() - origin.longitude());
        double latitudeDifference = Math.toRadians(destination.latitude() - origin.latitude());
        double originLatitudeRadius = Math.toRadians(origin.latitude());
        double destinationLatitudeRadius = Math.toRadians(destination.latitude());

        double a = haversine(latitudeDifference) + Math.cos(originLatitudeRadius) *
                Math.cos(destinationLatitudeRadius) * haversine(longitudeDifference);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return EARTH_RADIUS_KM * c;
    }
}
