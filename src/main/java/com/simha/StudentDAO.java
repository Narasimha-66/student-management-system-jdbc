package com.simha;

import java.sql.*;

public class StudentDAO {

    // Add Student
    public void addStudent(Student s) {

        String sql = "INSERT INTO students VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setDouble(4, s.getMarks());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent(int rollNo) {

        String sql = "DELETE FROM students WHERE roll_no = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    // Update Student
    public void updateStudent(int rollNo,
                              String name,
                              int age,
                              double marks) {

        String sql =
                "UPDATE students SET name=?, age=?, marks=? WHERE roll_no=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, marks);
            ps.setInt(4, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // View All Students
    public void viewAll() {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n===== Student Records =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("roll_no")
                                + " | "
                                + rs.getString("name")
                                + " | "
                                + rs.getInt("age")
                                + " | "
                                + rs.getDouble("marks")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    // Search Student by Rollno
    public void searchStudent(int rollNo) {

        String sql = "SELECT * FROM students WHERE roll_no = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rollNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== Student Found =====");

                System.out.println(
                        rs.getInt("roll_no")
                                + " | "
                                + rs.getString("name")
                                + " | "
                                + rs.getInt("age")
                                + " | "
                                + rs.getDouble("marks"));

            } else {
                System.out.println("Student Not Found!");
            }

        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }
}