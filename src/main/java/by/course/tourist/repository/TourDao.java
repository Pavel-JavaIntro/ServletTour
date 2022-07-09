package by.course.tourist.repository;

import by.course.tourist.model.Tour;
import by.course.tourist.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourDao {
    Tour getTourById(int id);
    List<Tour> getAllTours();
    int addTour(Tour tour);
    int updateTour(Tour tour);
    int deleteTour(int id);
}
