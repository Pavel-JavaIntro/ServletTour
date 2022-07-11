package by.course.tourist.controller.browser;

import by.course.tourist.exception.NoSuchIDException;
import by.course.tourist.model.Tour;
import by.course.tourist.service.TourDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tours")
public class TourController {
    @Autowired
    TourDaoImpl dao;

    @GetMapping("")
    public String getTours(ModelMap map) {
        List<Tour> tours = dao.getAllTours();
        map.addAttribute("users", tours);
        return "user_info";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTour(@PathVariable int id) {
        Tour tour = dao.getTourById(id);
        if (tour == null) {
            throw new NoSuchIDException("No such Tour ID exists");
        }
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Tour> updateTour(@RequestBody Tour tour) {
        dao.updateTour(tour);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {
        dao.addTour(tour);
        return new ResponseEntity<>(tour, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTour(@PathVariable int id) {
        //TODO probably needs check for id out of range, like in UserController
        dao.deleteTour(id);
        return HttpStatus.NO_CONTENT;
    }
}
