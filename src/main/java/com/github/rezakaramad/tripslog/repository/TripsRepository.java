package com.github.rezakaramad.tripslog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.rezakaramad.tripslog.entity.Trip;

public interface TripsRepository extends MongoRepository<Trip, String> {
    List<Trip> findByTitleContainingIgnoreCase(String title);
}
