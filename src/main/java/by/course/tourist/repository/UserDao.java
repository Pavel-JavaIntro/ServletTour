package by.course.tourist.repository;

import by.course.tourist.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUserById(int id);
    List<User> getAllUsers();
    int addUser(User user);
    int addUser(String name, String surname, String email, int roleId, String login, int password);
    int updateUser(int id, String name, String surname, String email, int roleId, String login, int password);
    int deleteUser(int id);
}
