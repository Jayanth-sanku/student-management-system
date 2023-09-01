<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.studentmanagement.model.Student" %>
<%@ page import="com.studentmanagement.dao.StudentDAO" %>
<%@ page import="com.studentmanagement.dao.StudentDAOImpl" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2>Edit Student</h2>
        <%
            String studentIdParam = request.getParameter("id");
            if (studentIdParam != null) {
                int studentId = Integer.parseInt(studentIdParam);
                StudentDAO studentDAO = new StudentDAOImpl();
                Student student = studentDAO.getStudentById(studentId);
                if (student != null) {
        %>
    <!-- Other content -->
    <form action="EditStudentServlet" method="post">
    
        <!-- Hidden field to pass the student's ID to the updateStudent servlet -->
        <input type="hidden" name="id" value="<%= student.getId() %>">
        
        <!-- Input fields for editing student's data -->
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= student.getName() %>">
        </div>
        
        <div class="form-group">
            <label for="rollNumber">Roll Number:</label>
            <input type="text" class="form-control" id="rollNumber" name="rollNumber" value="<%= student.getRollNumber() %>">
        </div>
        
        <div class="form-group">
            <label for="contact">Contact:</label>
            <input type="text" class="form-control" id="contact" name="contact" value="<%= student.getContact() %>">
        </div>
        
        <div class="form-group">
            <label for="course">Course:</label>
            <input type="text" class="form-control" id="course" name="course" value="<%= student.getCourse() %>">
        </div>
        
        <div class="form-group">
            <label for="grade">Grade:</label>
            <input type="text" class="form-control" id="grade" name="grade" value="<%= student.getGrade() %>">
        </div>
        
        <!-- Submit button to update the student -->
        <button type="submit" class="btn btn-primary">Update Student</button>
    </form>
    <!-- Rest of the content -->
            <%
                } else {
        %>
        <p>Student not found.</p>
        <%
                }
            } else {
        %>
        <p>Invalid student ID.</p>
        <%
            }
        %>
    </div>
        
</body>



</html>
