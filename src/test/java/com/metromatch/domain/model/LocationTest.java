package com.metromatch.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void shouldCreateValidLocation() {
        Location location = new Location(-23.5505, -46.6333);

        assertEquals(-23.5505, location.latitude());
        assertEquals(-46.6333, location.longitude());
    }

    @Test
    void shouldRejectLatitudeGreaterThan90() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Location(91, -46.6333)
        );
    }

    @Test
    void shouldRejectLatitudeLowerThanMinus90() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Location(-91, -46.6333)
        );
    }

    @Test
    void shouldRejectLongitudeGreaterThan180() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Location(-23.5505, 181)
        );
    }

    @Test
    void shouldRejectLongitudeLowerThanMinus180() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Location(-23.5505, -181)
        );
    }
}