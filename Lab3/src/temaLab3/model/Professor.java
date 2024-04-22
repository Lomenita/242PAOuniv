package temaLab3.model;

public class Professor extends Person{

    private String course;
    private int year;

    public Professor(){
    }
    public Professor(Person person){
        super(person.getName(), person.getPhoneNumber(), person.getEmailAddress());
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse(){
        return course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear(){
        return year;
    }
    @Override
    public String toString() {
        return "Professor{" +
                " name= '" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", course='" + course + '\'' +
                ", year=" + year +
                '}';
    }
}
