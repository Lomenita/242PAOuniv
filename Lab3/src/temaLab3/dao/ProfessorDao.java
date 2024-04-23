package temaLab3.dao;

import temaLab3.daoservices.DatabaseConnection;
import temaLab3.model.Professor;
import java.sql.*;

public class ProfessorDao implements DaoInterface<Professor>{
    private static ProfessorDao professorDao;

    private Connection connection = DatabaseConnection.getConnection();

    private ProfessorDao() throws SQLException {}

    public static ProfessorDao getInstance() throws SQLException {
        if(professorDao == null){
            professorDao = new ProfessorDao();
        }
        return professorDao;
    }

    @Override
    public void add(Professor professor) throws SQLException {
        String sql = "INSERT INTO proiectpao.profesor VALUES (?, ?, ?, ?, ?);";

        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, professor.getYear());
            statement.setString(2, professor.getCourse());
            statement.setString(3, professor.getName());
            statement.setString(4, professor.getPhoneNumber());
            statement.setString(5, professor.getEmailAddress());
            statement.executeUpdate();
        }
    }

    @Override
    public Professor read(String name) throws SQLException {
        String sql = "SELECT * FROM proiectpao.profesor s WHERE s.name = ?";
        ResultSet rs = null;
        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, name);
            rs = statement.executeQuery();

            while (rs.next()){
                Professor professor = new Professor();
                professor.setCourse(rs.getString("course"));
                professor.setYear(rs.getInt("year"));
                professor.setName(rs.getString("name"));
                professor.setPhoneNumber(rs.getString("phoneNumber"));
                professor.setEmailAddress(rs.getString("emailAddress"));
                return  professor;
            }
        }finally {
            if(rs != null) {
                rs.close();
            }
        }
        return null;
    }

    @Override
    public void delete(Professor professor) throws SQLException {
        String sql = "DELETE FROM proiectpao.profesor s WHERE s.name = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, professor.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Professor professor)  throws SQLException{
        String sql = "UPDATE proiectpao.profesor set course = ? , year = ?" +
                " , phoneNumber = ? , emailAddress = ? where name = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, professor.getCourse());
            statement.setInt(2, professor.getYear());
            statement.setString(3, professor.getPhoneNumber());
            statement.setString(4, professor.getEmailAddress());
            statement.setString(5, professor.getName());
            statement.executeUpdate();
        }
    }
}
