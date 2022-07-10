package by.course.tourist.controller;

import by.course.tourist.annotation.LogAnnotation;
import by.course.tourist.exception.IncorrectData;
import by.course.tourist.exception.NoSuchIDException;
import by.course.tourist.model.User;
import by.course.tourist.service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired UserDaoImpl dao;

  @GetMapping("/")
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = dao.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable int id) {
    User user = dao.getUserById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PutMapping("/")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    dao.updateUser(user);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @LogAnnotation
  @PostMapping("/")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    dao.addUser(user);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public HttpStatus deleteUser(@PathVariable int id) {
    int rows = dao.deleteUser(id);
    if (rows == 0) {
      throw new NoSuchIDException("This User id is not in the DB");
    }
    return HttpStatus.NO_CONTENT;
  }
}
