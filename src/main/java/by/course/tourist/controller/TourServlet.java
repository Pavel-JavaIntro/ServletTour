package by.course.tourist.controller;

import by.course.tourist.config.Config;
import by.course.tourist.mapper.UserMapper;
import by.course.tourist.model.User;
import by.course.tourist.repository.UserDao;
import by.course.tourist.service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/controller")
public class TourServlet extends HttpServlet {

//  @Override
//  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//      throws ServletException, IOException {
//    int id = Integer.parseInt(req.getParameter("userId"));
//    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//    UserDao userDao = context.getBean(UserDaoImpl.class);
//    if (id > 0) {
//      User user = userDao.getUserById(id);
//      req.setAttribute("user", user);
//    } else {
//      List<User> userList = userDao.getAllUsers();
//      req.setAttribute("userList", userList);
//    }
//    req.getRequestDispatcher("jsp/user_info.jsp").forward(req, resp);
//  }
}
