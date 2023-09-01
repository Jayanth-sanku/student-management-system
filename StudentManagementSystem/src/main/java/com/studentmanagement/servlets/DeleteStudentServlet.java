package com.studentmanagement.servlets;

import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.dao.StudentDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAOImpl(); // Initialize the DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));

        // Delete the student from the database
        studentDAO.deleteStudent(studentId);

        // Redirect back to the list of students
        response.sendRedirect(request.getContextPath() + "/listStudents.jsp");
    }
}
