package by.course.tourist.service;

import by.course.tourist.exception.NoSuchIDException;
import by.course.tourist.mapper.UserMapper;
import by.course.tourist.model.User;
import by.course.tourist.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

  @Override
  public User getUserById(int id) {
    try {
      User user =  jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", userMapper, id);
      return user;
    } catch (DataAccessException e) {
      e.printStackTrace();
      throw new NoSuchIDException("User with id = " + id + " is not found in the DB");
    }
  }

  @Override
  public List<User> getAllUsers() {
    return jdbcTemplate.query("SELECT * FROM users", userMapper);
  }

  @Override
  public int addUser(User user) {
    return jdbcTemplate.update(
        "INSERT INTO users (\"name\", surname, email, role_Id, login, password) "
            + "VALUES (?, ?, ?, ?, ?, ?)",
        user.getName(),
        user.getSurname(),
        user.getEmail(),
        user.getRoleId(),
        user.getLogin(),
        user.getPassword());
  }

  @Override
  public int updateUser(User user) {
    return jdbcTemplate.update("UPDATE users SET \"name\"=?, surname=?, email=?, role_Id=?, login=?, password=?"
            + "WHERE id=?", user.getName(), user.getSurname(), user.getEmail()
            , user.getRoleId(), user.getLogin(), user.getPassword(), user.getId());
  }

  @Override
  public int deleteUser(int id) {
    return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
  }
}
