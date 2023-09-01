package com.studentmanagement.servlets;

import com.studentmanagement.model.Student;
import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.dao.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/ListStudentsServlet")
public class ListStudentsServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAOImpl(); // Initialize the DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of students from the database
        List<Student> students = studentDAO.getAllStudents();

        // Set the list of students as an attribute and forward to the listStudents.jsp page
        request.setAttribute("students", students);
        request.getRequestDispatcher("listStudents.jsp").forward(request, response);
    }
}


