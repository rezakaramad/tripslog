package com.github.rezakaramad.tripslog.controller;

import org.springframework.web.bind.annotation.*;

import com.github.rezakaramad.tripslog.entity.Trip;
import com.github.rezakaramad.tripslog.service.TripsService;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripsController {
    private final TripsService tripService;
    public TripsController(TripsService tripService) {
        this.tripService = tripService;
    }
    @GetMapping
    public List<Trip> getTrips(
            @RequestParam(value = "q", required = false) String query
    ) {
        if (query == null || query.isBlank()) {
            return tripService.getAllTrips();
        }
        return tripService.searchTrips(query);
    }
    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable String id) {
        return tripService.getTripById(id);
    }
    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }
}
