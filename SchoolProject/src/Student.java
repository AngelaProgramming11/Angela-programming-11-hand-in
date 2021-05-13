//stores data on a student including their name, grade and student number
public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNumber;
    static int numberOfStudents = 1;

    //constructors
    Student(){
        firstName = "";
        lastName = "";
        grade = 1;
        studentNumber = numberOfStudents;
        numberOfStudents++;
    }

    Student(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.setGrade(this.grade);
        studentNumber = numberOfStudents;
        numberOfStudents++;
    }

    //setters and getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public static int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
        if(grade < 1){
            this.grade = 1;
        }
        else if (grade > 12){
            this.grade = 12;
        }
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public static void setNumberOfStudents(int numberOfStudents) {
        Student.numberOfStudents = numberOfStudents;
    }

    //display student info (name and grade)
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + " Grade: " + this.grade;
    }
}
