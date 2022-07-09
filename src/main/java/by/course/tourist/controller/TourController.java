package by.course.tourist.controller;

import by.course.tourist.model.Tour;
import by.course.tourist.model.User;
import by.course.tourist.service.TourDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController {
    @Autowired
    TourDaoImpl dao;

    @GetMapping("/")
    public ResponseEntity<List<Tour>> getTours() {
        List<Tour> tours = dao.getAllTours();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTour(@PathVariable int id) {
        Tour tour = dao.getTourById(id);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Tour> updateTour(@RequestBody Tour tour) {
        dao.updateTour(tour);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {
        dao.addTour(tour);
        return new ResponseEntity<>(tour, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTour(@PathVariable int id) {
        dao.deleteTour(id);
        return HttpStatus.NO_CONTENT;
    }
}
