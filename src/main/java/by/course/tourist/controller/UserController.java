package by.course.tourist.controller;

import by.course.tourist.model.User;
import by.course.tourist.service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDaoImpl dao;

    @GetMapping("/users")
    public String showUsers(ModelMap map) {
        List<User> users = dao.getAllUsers();
        map.addAttribute("users", users);
        return "user_info";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable int id, ModelMap map) {
        User user = dao.getUserById(id);
        map.addAttribute(user);
        return "user_info";
    }

    @PostMapping("/users")
    public String addUser(String name, String surname, String email, int roleId, String login,
                          int password, ModelMap map) {
        dao.addUser(name, surname, email, roleId, login, password);
        map.addAttribute("users", dao.getAllUsers());
        return "user_info";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id, ModelMap map) {
        dao.deleteUser(id);
        map.addAttribute("users", dao.getAllUsers());
        return "user_info";
    }

}
