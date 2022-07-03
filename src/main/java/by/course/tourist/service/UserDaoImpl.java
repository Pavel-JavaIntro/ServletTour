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

  public UserDaoImpl() {}

  @Override
  public User getUserById(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", userMapper, id);
  }

  @Override
  public List<User> getAllUsers() {
    return jdbcTemplate.query("SELECT * FROM users", userMapper);
  }

  @Override
  public int addUser(User user) {
    return jdbcTemplate.update(
        "INSERT INTO users (name, surname, email, role_Id, login, password) "
            + "VALUES (user.getName(), user.getSurname(), user.getEmail(), user.getRoleId(), user.getLogin()"
            + ", user.getPassword())");
  }

  @Override
  public int addUser(
      String name, String surname, String email, int roleId, String login, int password) {
    return jdbcTemplate.update(
        "INSERT INTO users (\"name\", surname, email, role_Id, login, password) "
            + "VALUES (?,?,?,?,?,?)",
        name,
        surname,
        email,
        roleId,
        login,
        password);
  }

  @Override
  public int updateUser(
      int id, String name, String surname, String email, int roleId, String login, int password) {
    int result = jdbcTemplate.update(
        "UPDATE users SET \"name\"=?, surname=?, email=?, role_Id=?, login=?, password=?"
            + "WHERE id=?",
        name,
        surname,
        email,
        roleId,
        login,
        password,
        id);
    System.out.println("QUERY MADE");
    return result;
  }

  @Override
  public int deleteUser(int id) {
    return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
  }
}
