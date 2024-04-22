package temaLab3.model;

public class Student extends Person{
    private int studentNumber;
    private float averageMark;
    private String clasa;

    public Student() {}
    public Student(Person person) {
        super(person.getName(), person.getPhoneNumber(), person.getEmailAddress());
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber(){
        return studentNumber;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public float getAverageMark(){
        return averageMark;
    }
    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public String getClasa(){
        return clasa;
    }

    @Override
    public String toString() {
        return "Student{" +
                " name = '" + super.getName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", emailAddress='" + super.getEmailAddress() + '\'' +
                ", studentNumber= '" + studentNumber + '\'' +
                ", averageMark= '" + averageMark + '\'' +
                ", clasa=" + clasa +
                '}';
    }
}
