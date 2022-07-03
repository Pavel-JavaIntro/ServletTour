package by.course.tourist.controller;

import by.course.tourist.model.User;
import by.course.tourist.service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

  @Autowired UserDaoImpl dao;

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
  public String addUser(
      @RequestParam String name,
      @RequestParam String surname,
      @RequestParam String email,
      @RequestParam("roleId") String role,
      @RequestParam String login,
      @RequestParam("password") String pass,
      ModelMap map) {
    int roleId = Integer.parseInt(role);
    int password = Integer.parseInt(pass);
              dao.addUser(name, surname, email, roleId, login, password);
              map.addAttribute("users", dao.getAllUsers());
    return "user_info";
  }

  @PostMapping("/users/{id}")
  public String updateUser(@PathVariable @RequestParam int id,
                           @RequestParam("gname") String name,
                           @RequestParam("gsurname") String surname,
                           @RequestParam("gemail") String email,
                           @RequestParam("groleId") String role,
                           @RequestParam("glogin") String login,
                           @RequestParam("gpassword") String pass,
                           ModelMap map) {
    int roleId = Integer.parseInt(role);
    int password = Integer.parseInt(pass);
    dao.updateUser(id, name, surname, email, roleId, login, password);
    map.addAttribute("users", dao.getAllUsers());
    return "user_info";
  }

  //    public String addUser(@RequestBody User user) {
  //        dao.addUser(user);
  //        return "user_info";
  //    }

  @DeleteMapping("/users/{id}")
  public String deleteUser(@PathVariable int id, ModelMap map) {
    dao.deleteUser(id);
    map.addAttribute("users", dao.getAllUsers());
    return "user_info";
  }

}
