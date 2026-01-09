package com.github.rezakaramad.tripslog.controller;
// package com.jysk.triplog.controller;

// import com.jysk.triplog.entity.Trip;
// import com.jysk.triplog.service.TripService;

// import java.util.List;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class HomeController {

//     private final TripService tripService;

//     public HomeController(TripService tripService) {
//         this.tripService = tripService;
//     }

//     @GetMapping("/")
//     public String home(
//             @RequestParam(value = "q", required = false) String query,
//             Model model
//     ) {
//         List<Trip> trips;

//         if (query == null || query.isBlank()) {
//             trips = tripService.getAllTrips();
//         } else {
//             trips = tripService.searchTrips(query);
//         }

//         model.addAttribute("trips", trips);
//         model.addAttribute("query", query);

//         return "home";
//     }
// }
