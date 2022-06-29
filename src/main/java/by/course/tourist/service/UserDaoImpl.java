package by.course.tourist.service;

import by.course.tourist.mapper.UserMapper;
import by.course.tourist.model.User;
import by.course.tourist.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service("impl")
public class UserDaoImpl implements UserDao {
//  public static final String URL = "jdbc:postgresql://localhost:5432/tourism";
//  public static final String USER = "postgres";
//  public static final String PASS = "pavel";
  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private UserMapper userMapper;

  @Override
  public User getUserById(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", userMapper, id);
  }

  @Override
  public List<User> getAllUsers() {
    return jdbcTemplate.query("SELECT * FROM users", userMapper);
  }
}
