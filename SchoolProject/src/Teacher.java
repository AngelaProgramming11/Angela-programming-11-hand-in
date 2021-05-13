//stores data on a teacher including their name and subject
public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;

    //constructors
    Teacher(){
        firstName = "";
        lastName = "";
        subject = "";
    }

    Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    //setters and getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //display teacher info (name and subject)
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + " Subject: " + this.subject;
    }
}
