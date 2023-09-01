<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.Student" %>
<%@ page import="com.studentmanagement.dao.StudentDAO" %>
<%@ page import="com.studentmanagement.dao.StudentDAOImpl" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>List Students</title>
    <style>
    
     .action-buttons {
        /* Remove the width and height properties */
    }
    .btn-group {
        display: flex;
    }
    .btn-group .btn {
        flex: 1;
        margin-right: 5px;
    }
        /* Add your custom styles here */
        body {
            background-image: url('images/Student.jpg'); /* Set the image path */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed; /* Prevent scrolling with the background image */
        }
        .navbar {
            background-color: transparent;
            color: white; /* White text color for nav links */
        }
        .navbar-nav .nav-link {
            color: blue; /* Blue text color for nav links */
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            border-radius: 10px;
            padding: 20px;
            margin-top: 50px;
        }
        .table {
            background-color: white;
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <!-- Add more navigation links if needed -->
                </ul>
                <!-- Add a search form or other elements here -->
            </div>
        </div>
    </nav>

    <div class="container">
        <h2>List of Students</h2>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Roll Number</th>
                <th>Contact</th>
                <th>Course</th>
                <th>Grade</th>
                <th>Actions</th>
            </tr>
            
<%
    StudentDAO studentDAO = new StudentDAOImpl(); // Create an instance of StudentDAO
    List<Student> studentList = studentDAO.getAllStudents(); // Get the list of students
     // Close the connection when done

    // Now you can use the studentList in your JSP

                // Import necessary Java classes
                
                // Replace with your DAO method
                for (Student student : studentList) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getRollNumber() %></td>
                <td><%= student.getContact() %></td>
                <td><%= student.getCourse() %></td>
                <td><%= student.getGrade() %></td>
    <td class="action-buttons">
        <div class="btn-group" role="group">
            <a href="editStudent.jsp?id=<%= student.getId() %>" class="btn btn-primary btn-sm">Edit</a>
            <a href="DeleteStudentServlet?id=<%= student.getId() %>" class="btn btn-danger btn-sm">Delete</a>
        </div>
        
        
        
        
    </td>
            </tr>
            <%
                }
            %>
        </table>

        <!-- New Student button with blue background -->
        <a href="addStudent.jsp" class="btn btn-primary">New Student</a>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
