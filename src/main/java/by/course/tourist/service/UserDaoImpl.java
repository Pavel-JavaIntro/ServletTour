package by.course.tourist.service;

import by.course.tourist.model.User;
import by.course.tourist.repository.UserDao;

import java.sql.*;

public class UserDaoImpl implements UserDao {
  public static final String URL = "jdbc:postgresql://localhost:5432/tourism";
  public static final String USER = "postgres";
  public static final String PASS = "pavel";

  @Override
  public User getUserById(int id) {
    User user = null;
    try {
      Class.forName("org.postgresql.Driver");
      Connection connection = DriverManager.getConnection(URL, USER, PASS);
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
      statement.setInt(1, id);
      System.out.println(statement.toString());
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        user = new User();
        user.setName(result.getString("name"));
        user.setSurname(result.getString("surname"));
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return user;
  }
}
