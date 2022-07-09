package by.course.tourist.mapper;

import by.course.tourist.model.Tour;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class TourMapper implements RowMapper<Tour> {
    @Override
    public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tour tour = new Tour();
        tour.setId(rs.getInt("id"));
        tour.setStatusId(rs.getInt("status_id"));
        tour.setDescription(rs.getString("description"));
        tour.setCapacity(rs.getInt("capacity"));
        tour.setStartDate(rs.getDate("start_date"));
        tour.setEndDate(rs.getDate("end_date"));
        tour.setPrice(rs.getInt("price"));
        tour.setBooked(rs.getInt("booked"));
        tour.setTypeId(rs.getInt("type_id"));
        return tour;
    }
}
