package com.github.rezakaramad.tripslog.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.rezakaramad.tripslog.entity.Trip;
import com.github.rezakaramad.tripslog.repository.TripsRepository;

import java.util.List;

@Service
public class TripsService {

    private final TripsRepository tripsRepository;

    public TripsService(TripsRepository tripsRepository) {
        this.tripsRepository = tripsRepository;
    }

    public Trip createTrip(Trip trip) {
        return tripsRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripsRepository.findAll();
    }

    public List<Trip> searchTrips(String query) {
        if (query.isBlank()) {
            return getAllTrips();
        }
        return tripsRepository.findByTitleContainingIgnoreCase(query);
    }

    public Trip getTripById(String id) {
        return tripsRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Trip not found: " + id
                        )
                );
    }
}
