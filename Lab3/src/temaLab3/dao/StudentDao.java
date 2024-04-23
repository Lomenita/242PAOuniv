package temaLab3.dao;

import temaLab3.daoservices.DatabaseConnection;
import temaLab3.model.Student;
import java.sql.*;

public class StudentDao implements DaoInterface<Student>{

    private static StudentDao studentDao;
    private Connection connection = DatabaseConnection.getConnection();

    public StudentDao() throws SQLException {
    }

    public static StudentDao getInstance() throws SQLException {
        if(studentDao == null){
            studentDao = new StudentDao();
        }
        return studentDao;
    }

    @Override
    public void add(Student student) throws SQLException {
        String sql = "INSERT INTO proiectpao.student VALUES (?, ?, ?, ?, ?, ?);";

        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, student.getStudentNumber());
            statement.setFloat(2, student.getAverageMark());
            statement.setString(3, student.getClasa());
            statement.setString(4, student.getName());
            statement.setString(5, student.getPhoneNumber());
            statement.setString(6, student.getEmailAddress());
            statement.executeUpdate();
        }
    }

    @Override
    public Student read(String name) throws SQLException {
        String sql = "SELECT * FROM proiectpao.student s WHERE s.name = ?";
        ResultSet rs = null;
        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, name);
            rs = statement.executeQuery();

            while (rs.next()){
                Student s = new Student();
                s.setStudentNumber(rs.getInt("studentNumber"));
                s.setAverageMark(rs.getFloat("averageMark"));
                s.setClasa(rs.getString("clasa"));
                s.setName(rs.getString("name"));
                s.setPhoneNumber(rs.getString("phoneNumber"));
                s.setEmailAddress(rs.getString("emailAddress"));
                return  s;
            }
        }finally {
            if(rs != null) {
                rs.close();
            }
        }
        return null;
    }
    @Override
    public void delete(Student student) throws SQLException {
        String sql = "DELETE FROM proiectpao.student s WHERE s.name = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, student.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Student student)  throws SQLException{
        String sql = "UPDATE proiectpao.student a set a.studentNumber = ? , a.averageMark = ?" +
                " , a.phoneNumber = ? , a.emailAddress = ? where a.name = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, student.getStudentNumber());
            preparedStatement.setFloat(2, student.getAverageMark());
            preparedStatement.setString(3, student.getPhoneNumber());
            preparedStatement.setString(4, student.getEmailAddress());
            preparedStatement.setString(5, student.getName());
            preparedStatement.executeUpdate();
        }
    }
}
