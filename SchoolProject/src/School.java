import java.util.ArrayList;
/*store data of a school: school name, mascot and ranking. It also keeps track of the teachers and students in
the school, having the ability to add and remove them, and display a list of them*/
public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> courses = new ArrayList<>();
    private String name;
    private String mascot;
    private int ranking;
    //constructors
    School(){
        name = "";
        mascot = "";
        ranking = 0;
    }

    School(String name, String mascot, int ranking){
        this.name = name;
        this.mascot = mascot;
        this.ranking = ranking;
    }
    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    //display list of teachers
    public void showAllTeachers(){
        System.out.println("Teachers:");
        for(int i = 0; i < 30; i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i = 0; i < teachers.size(); i++){
            System.out.println(teachers.get(i).getFirstName() + " " + teachers.get(i).getLastName());
        }
        System.out.print("\n");
    }

    //display list of students
    public void showAllStudents(){
        System.out.println("Students:");
        for(int i = 0; i < 30; i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).getFirstName() + " " + students.get(i).getLastName());
        }
        System.out.print("\n");
    }

    //add a teacher to the teachers array
    public void addTeacher(String firstName, String lastName, String subject){
        Teacher teacher = new Teacher(firstName, lastName, subject);
        teachers.add(teacher);
    }

    //add a student to the student array
    public void addStudent(String firstName, String lastName, int grade){
        Student student = new Student(firstName, lastName, grade);
        students.add(student);
    }

    //remove a teacher from the teacher array
    public void removeTeacher(int index){
        teachers.remove(index);
    }

    //remove a student from the student array
    public void removeStudent(int index){
        students.remove(index);
    }
}
