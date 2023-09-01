package com.studentmanagement.dao;

import com.studentmanagement.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/database1";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Jayanth@mysql";

    private Connection connection;
    

    public StudentDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try {
            String query = "SELECT * FROM Student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String rollNumber = resultSet.getString("rollNumber");
                    String contact = resultSet.getString("contact");
                    String course = resultSet.getString("course");
                    String grade = resultSet.getString("grade");

                    Student student = new Student(id, name, rollNumber, contact, course, grade); // Include ID
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO Student (name, rollNumber, contact, course, grade) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getRollNumber());
                preparedStatement.setString(3, student.getContact());
                preparedStatement.setString(4, student.getCourse());
                preparedStatement.setString(5, student.getGrade());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            String query = "UPDATE Student SET name = ?, rollNumber = ?, contact = ?, course = ?, grade = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getRollNumber());
                preparedStatement.setString(3, student.getContact());
                preparedStatement.setString(4, student.getCourse());
                preparedStatement.setString(5, student.getGrade());
                preparedStatement.setInt(6, student.getId()); // Include ID

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            String query = "DELETE FROM Student WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    @Override
    public Student getStudentById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            String sql = "SELECT * FROM Student WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String rollNumber = resultSet.getString("rollNumber");
                String contact = resultSet.getString("contact");
                String course = resultSet.getString("course");
                String grade = resultSet.getString("grade");

                student = new Student(id, name, rollNumber, contact, course, grade);
                student.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return student;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
