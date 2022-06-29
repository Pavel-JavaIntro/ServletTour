package by.course.tourist.service;

import by.course.tourist.mapper.UserMapper;
import by.course.tourist.model.User;
import by.course.tourist.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

  private JdbcTemplate jdbcTemplate;
  private UserMapper userMapper;

  @Autowired
  public UserDaoImpl(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.userMapper = userMapper;
  }

  public UserDaoImpl() {
  }

  @Override
  public User getUserById(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", userMapper, id);
  }

  @Override
  public List<User> getAllUsers() {
    return jdbcTemplate.query("SELECT * FROM users", userMapper);
  }
}
