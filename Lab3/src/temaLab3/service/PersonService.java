package temaLab3.service;

import temaLab3.daoservices.PersonRepositoryService;
import temaLab3.model.Person;
import temaLab3.model.Professor;
import temaLab3.model.Student;
import temaLab3.utils.FileManagement;

import java.sql.SQLException;
import java.util.Scanner;

import static temaLab3.utils.Constants.*;

public class PersonService {
    private PersonRepositoryService databaseService;

    public PersonService() throws SQLException {
        this.databaseService = new PersonRepositoryService();
    }

    public void create(Scanner scanner) {
        System.out.println("Enter type of person [student/profesor]:");
        String typeOfPerson = scanner.nextLine().toLowerCase();
        if(!typeOfPersonValidation(typeOfPerson)) { return; }
        try {
            personInit(scanner, typeOfPerson);
        } catch (SQLException e) {
            System.out.println("Persoana nu se poate crea " + e.getSQLState() + " " + e.getMessage());
        }
    }

    public void read(Scanner scanner) {
        System.out.println("name:");
        String name = scanner.nextLine();
        try {
            databaseService.getStudentByName(name);
            FileManagement.scriereFisierChar(AUDIT_FILE, "citire student " + name);
        } catch (SQLException e) {
            System.out.println("Student nu se poate gasi " + e.getSQLState() + " " + e.getMessage());
        }

        try{
            databaseService.getProfessorByName(name);
            FileManagement.scriereFisierChar(AUDIT_FILE, "citire profesor " + name);
        } catch (SQLException e) {
            System.out.println("Profesor nu se poate gasi " + e.getSQLState() + " " + e.getMessage());
        }
    }

    public void delete(Scanner scanner) {
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("typeOfPerson:");
        String typeOfPerson = scanner.nextLine();
        if(!typeOfPersonValidation(typeOfPerson)) { return; }
        try {
            databaseService.removePerson(typeOfPerson, name);
            FileManagement.scriereFisierChar(AUDIT_FILE, "stergere persoana " + name);
        } catch (SQLException e) {
            System.out.println("Persoana nu se poate stearsa " + e.getSQLState() + " " + e.getMessage());
        }
    }

    public void update(Scanner scanner) {
        System.out.println("typeOfPerson:");
        String typeOfPerson = scanner.nextLine();
        if(!typeOfPersonValidation(typeOfPerson)) { return; }
        System.out.println("name:");
        String name = scanner.nextLine();
        Person person = databaseService.getPerson(typeOfPerson, name);
        if (person == null) { return;}

        Person personGeneralInfo = setGeneralInfo(name, scanner);
        person.setName(name);
        person.setPhoneNumber(personGeneralInfo.getPhoneNumber());
        person.setEmailAddress(personGeneralInfo.getEmailAddress());
        if(typeOfPerson.equals(PROFESSOR)){
            professorInit(scanner, (Professor) person);
        }else{
            studentInit(scanner, (Student) person);
        }

        try {
            databaseService.update(person);
        }catch (SQLException e){
            System.out.println("Persoana nu se poate updata " + e.getSQLState() + " " + e.getMessage());
        }
    }

    public boolean typeOfPersonValidation(String typeOfPerson) {

        if(! typeOfPerson.equals(PROFESSOR) && !typeOfPerson.equals(STUDENT)){
            System.out.println("Wrong type");
            return false;
        }
        return true;
    }

    private void personInit(Scanner scanner, String typeOfPerson) throws SQLException {
        System.out.println("name:");
        String name = scanner.nextLine();

        if (typeOfPerson.equals(PROFESSOR) && databaseService.getProfessorByName(name) != null) {return;}
        if (typeOfPerson.equals(STUDENT) && databaseService.getStudentByName(name) != null) {return;}

        Person person = setGeneralInfo(name, scanner);
        if(typeOfPerson.equals(PROFESSOR)){
            Professor professor = new Professor(person);
            professorInit(scanner, professor);
            person = professor;
        } else {
            Student student = new Student(person);
            studentInit(scanner, student);
            person = student;
        }

        try {
            databaseService.addPerson(person);
            System.out.println("Created " + person);
            FileManagement.scriereFisierChar(AUDIT_FILE, "add persoana " + person.getName());
        } catch (SQLException e) {
            System.out.println("Cannot create " + person + " exception " + e.getSQLState() + " " + e.getMessage());
        }

    }

    private Person setGeneralInfo(String name, Scanner scanner) {
        System.out.println("phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("email:");
        String email = scanner.nextLine();
        return new Person(name, phoneNumber, email);
    }

    private void studentInit(Scanner scanner, Student student) {
        System.out.println("student number:");
        int studentNumber = scanner.nextInt();
        System.out.println("averageMark:");
        float averageMark = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("clasa:");
        String clasa = scanner.nextLine();

        student.setStudentNumber(studentNumber);
        student.setAverageMark(averageMark);
        student.setClasa(clasa);
    }

    private void professorInit(Scanner scanner, Professor professor) {
        System.out.println("course:");
        String course = scanner.nextLine();
        System.out.println("year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // asta va citi \n care nu este preluat de nextInt.
        // Daca nu e folosit, \n ramane in scanner si produce reluarea comenzii
        professor.setCourse(course);
        professor.setYear(year);
    }
}