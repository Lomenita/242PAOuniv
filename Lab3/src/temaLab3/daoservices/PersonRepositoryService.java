package temaLab3.daoservices;

import temaLab3.model.Person;
import temaLab3.dao.ProfessorDao;
import temaLab3.dao.StudentDao;
import temaLab3.model.Professor;
import temaLab3.model.Student;
import java.sql.SQLException;

import static temaLab3.utils.Constants.PROFESSOR;

public class PersonRepositoryService {

    private ProfessorDao professorDao = ProfessorDao.getInstance();
    private StudentDao studentDao = StudentDao.getInstance();

    public PersonRepositoryService() throws SQLException {}

    public Student getStudentByName(String name) throws SQLException {
        Student student = studentDao.read(name);
        if(student != null){
            System.out.println(student);
        }else {
            System.out.println("No student having this name");
        }

        return student;
    }

    public Professor getProfessorByName(String name)  throws SQLException{
        Professor professor = professorDao.read(name);
        if(professor != null){
            System.out.println(professor);
        }else {
            System.out.println("No professor having this name");
        }
        return professor;
    }

    public void removePerson(String typeOfPerson, String name) throws SQLException {
        Person person = getPerson(typeOfPerson, name);
        if (person == null) return;

        switch (person){
                case Professor professor -> professorDao.delete(professor);
                case Student student -> studentDao.delete(student);
                default -> throw new IllegalStateException("Unexpected value: " + person);
        }

        System.out.println("Removed " + person);
    }

    public void addPerson(Person person) throws SQLException {
        if(person != null){
            switch (person){
                case Professor professor-> professorDao.add(professor);
                case Student student -> studentDao.add(student);
                default -> throw new IllegalStateException("Unexpected value: " + person);
            }
        }
    }

    public Person getPerson(String typeOfPerson, String name) {
        Person person = null;
        try {
            if(typeOfPerson.equals(PROFESSOR)){
                person = getProfessorByName(name);
            }else{
                person = getStudentByName(name);
            }
            if(person == null) {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getSQLState() + " " + e.getMessage());
        }

        return person;
    }

    public void update(Person person) throws SQLException {
        if(person != null){
            switch (person){
                case Professor professor-> professorDao.update(professor);
                case Student student -> studentDao.update(student);
                default -> throw new IllegalStateException("Unexpected value: " + person);
            }
        }
    }
}
