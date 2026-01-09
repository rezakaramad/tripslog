package com.github.rezakaramad.tripslog.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.rezakaramad.tripslog.entity.Trip;
import com.github.rezakaramad.tripslog.repository.TripsRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class TripsDataInitializer implements CommandLineRunner {

    private final TripsRepository tripsRepository;

    public TripsDataInitializer(TripsRepository tripsRepository) {
        this.tripsRepository = tripsRepository;
    }

@Override
    public void run(String... args) {
        if (tripsRepository.count() > 0) {
            return;
        }
        
        Iterable<Trip> trips = List.of(
          createTrip("Winter in Japan", "Tokyo, Kyoto, Osaka",
                  LocalDate.of(2025, 12, 5), LocalDate.of(2025, 12, 20)),

          createTrip("Weekend in Berlin", "Food, museums, nightlife",
                  LocalDate.of(2025, 3, 8), LocalDate.of(2025, 3, 10)),

          createTrip("Nordic Capitals Tour", "Copenhagen, Stockholm, Oslo",
                  LocalDate.of(2025, 5, 2), LocalDate.of(2025, 5, 12)),

          createTrip("Road Trip Across Spain", "Barcelona, Valencia, Madrid",
                  LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 28)),

          createTrip("Greek Islands Escape", "Santorini, Naxos, Paros",
                  LocalDate.of(2025, 7, 3), LocalDate.of(2025, 7, 17)),

          createTrip("New York City Food Tour", "Manhattan, Brooklyn, Queens",
                  LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 16)),

          createTrip("Hiking in the Alps", "Zermatt, Chamonix",
                  LocalDate.of(2025, 8, 5), LocalDate.of(2025, 8, 18)),

          createTrip("Portugal Coastline", "Lisbon, Porto, Algarve",
                  LocalDate.of(2025, 6, 20), LocalDate.of(2025, 7, 2)),

          createTrip("Scotland Whisky Trail", "Edinburgh, Islay, Skye",
                  LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 10)),

          createTrip("Iceland Ring Road", "Reykjavik, Vik, Akureyri",
                  LocalDate.of(2025, 8, 25), LocalDate.of(2025, 9, 8)),

          createTrip("Morocco Cultural Journey", "Marrakech, Fes, Chefchaouen",
                  LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 12)),

          createTrip("Canadian Rockies Adventure", "Banff, Jasper, Lake Louise",
                  LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 14)),

          createTrip("South Korea Highlights", "Seoul, Busan, Jeju",
                  LocalDate.of(2025, 11, 5), LocalDate.of(2025, 11, 18)),

          createTrip("Vietnam Backpacking", "Hanoi, Hue, Ho Chi Minh City",
                  LocalDate.of(2025, 2, 10), LocalDate.of(2025, 3, 1)),

          createTrip("California National Parks", "Yosemite, Sequoia, Zion",
                  LocalDate.of(2025, 5, 18), LocalDate.of(2025, 5, 30)),

          createTrip("Dubai City Break", "Downtown, Desert Safari",
                  LocalDate.of(2025, 1, 20), LocalDate.of(2025, 1, 25)),

          createTrip("Mexico Yucatán Route", "Cancún, Tulum, Mérida",
                  LocalDate.of(2025, 6, 5), LocalDate.of(2025, 6, 16)),

          createTrip("Sri Lanka Explorer", "Colombo, Kandy, Ella",
                  LocalDate.of(2025, 3, 15), LocalDate.of(2025, 3, 28)),

          createTrip("Australia East Coast", "Sydney, Brisbane, Gold Coast",
                  LocalDate.of(2025, 11, 20), LocalDate.of(2025, 12, 5))
        );

        tripsRepository.saveAll(trips);
    }

    private Trip createTrip(
            String title,
            String description,
            LocalDate start,
            LocalDate end
    ) {
        Trip trip = new Trip();
        trip.setTitle(title);
        trip.setDescription(description);
        trip.setStartDate(start);
        trip.setEndDate(end);
        return trip;
    }
}
