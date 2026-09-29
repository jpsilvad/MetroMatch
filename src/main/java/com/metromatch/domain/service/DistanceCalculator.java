package com.metromatch.domain.service;

import com.metromatch.domain.model.Location;

public interface DistanceCalculator {
    double calculateDistance(Location origin, Location destination);
}
