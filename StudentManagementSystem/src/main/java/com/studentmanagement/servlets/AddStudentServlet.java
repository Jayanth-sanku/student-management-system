package com.studentmanagement.servlets;

import com.studentmanagement.model.Student;
import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.dao.StudentDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAOImpl(); // Initialize the DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String rollNumber = request.getParameter("rollNumber");
        String contact = request.getParameter("contact");
        String course = request.getParameter("course");
        String grade = request.getParameter("grade");

        // Create a new Student object with the provided data
        Student newStudent = new Student(0, name, rollNumber, contact, course, grade);

        // Add the new student to the database
        studentDAO.addStudent(newStudent);

        // Redirect back to the list of students
        response.sendRedirect("listStudents.jsp");
    }
}
