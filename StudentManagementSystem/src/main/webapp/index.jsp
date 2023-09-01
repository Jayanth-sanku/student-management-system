<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Student Management System</title>
    <style>
    
    
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
            color: white; /* White text color for nav links */
            margin-right: 10px; /* Add some spacing between links */
        }
        .navbar-toggler-icon {
            background-color: white; /* White color for the toggler icon */
        }
        .nav-link {
            background-color: #87CEFA; /* Light blue background color for the buttons */
            color: white !important; /* White text color for the buttons */
            border-radius: 5px; /* Add rounded corners */
            padding: 8px 15px; /* Add some padding */
            width: 150px; /* Set the width */
            text-align: center; /* Center the text */
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Student Management System</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="listStudents.jsp">List Students</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                    <!-- Add more navigation links if needed -->
                </ul>
                <!-- Add a search form or other elements here -->
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <!-- Your main content here -->
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
