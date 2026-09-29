package com.metromatch.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestinationTest {

    private final Location location =
            new Location(-23.5505, -46.6333);

    @Test
    void shouldCreateValidDestination() {
        Destination destination =
                new Destination("Work", location, 3);

        assertEquals("Work", destination.name());
        assertEquals(location, destination.location());
        assertEquals(3, destination.tripsPerWeek());
    }

    @Test
    void shouldRejectBlankName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Destination("", location, 3)
        );
    }

    @Test
    void shouldRejectNullLocation() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Destination("Work", null, 3)
        );
    }

    @Test
    void shouldRejectZeroTripsPerWeek() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Destination("Work", location, 0)
        );
    }

    @Test
    void shouldRejectNegativeTripsPerWeek() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Destination("Work", location, -1)
        );
    }
}