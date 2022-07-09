package by.course.tourist.service;

import by.course.tourist.mapper.TourMapper;
import by.course.tourist.mapper.UserMapper;
import by.course.tourist.model.Tour;
import by.course.tourist.model.User;
import by.course.tourist.repository.TourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourDaoImpl implements TourDao {
  private JdbcTemplate jdbcTemplate;
  private TourMapper tourMapper;

  @Autowired
  public TourDaoImpl(JdbcTemplate jdbcTemplate, TourMapper tourMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.tourMapper = tourMapper;
  }

  @Override
  public Tour getTourById(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM tours WHERE id=?", tourMapper, id);
  }

  @Override
  public List<Tour> getAllTours() {
    return jdbcTemplate.query("SELECT * FROM tours", tourMapper);
  }

  @Override
  public int addTour(Tour tour) {
    return jdbcTemplate.update(
        "INSERT INTO tours (status_id, description, capacity, start_date, end_date, price, booked, status_id) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
        tour.getStatusId(),
        tour.getDescription(),
        tour.getCapacity(),
        tour.getStartDate(),
        tour.getEndDate(),
        tour.getPrice(),
        tour.getBooked(),
        tour.getTypeId());
  }

  @Override
  public int updateTour(Tour tour) {
    return jdbcTemplate.update(
        "UPDATE tours SET status_id=?, description=?, capacity=?, start_date=?, end_date=?"
            + ", price=?, booked=?, type_id=?"
            + "WHERE id=?",
        tour.getStatusId(),
        tour.getDescription(),
        tour.getCapacity(),
        tour.getStartDate(),
        tour.getEndDate(),
        tour.getPrice(),
        tour.getBooked(),
        tour.getTypeId(),
        tour.getId());
  }

  @Override
  public int deleteTour(int id) {
    return jdbcTemplate.update("DELETE FROM tours WHERE id=?", id);
  }
}
