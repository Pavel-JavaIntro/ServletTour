package by.course.tourist.controller;

import by.course.tourist.model.User;
import by.course.tourist.repository.UserDao;
import by.course.tourist.service.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class TourServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("userId"));
    UserDao dao = new UserDaoImpl();
    User user = dao.getUserById(id);
    System.out.println(user);
    req.setAttribute("user", user);
    req.getRequestDispatcher("jsp/user_info.jsp").forward(req, resp);
  }
}
