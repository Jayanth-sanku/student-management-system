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
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAOImpl(); // Initialize the DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));

        // Retrieve the student by ID using the getStudentById method
        Student student = studentDAO.getStudentById(studentId);

        // Set the retrieved student as an attribute and forward to the editStudent.jsp page
        request.setAttribute("student", student);
        request.getRequestDispatcher("editStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String rollNumber = request.getParameter("rollNumber");
        String contact = request.getParameter("contact");
        String course = request.getParameter("course");
        String grade = request.getParameter("grade");

        // Create a new Student object with the updated details
        Student updatedStudent = new Student(studentId, name, rollNumber, contact, course, grade);

        // Update the student in the database
        studentDAO.updateStudent(updatedStudent);

        // Redirect to the listStudents page after the update
        response.sendRedirect(request.getContextPath() + "/listStudents.jsp");
    }
}
