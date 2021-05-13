public class Main {
    public static void main(String[] args) {
        School REMountain = new School();
        //add 3 teachers
        REMountain.addTeacher("Vivienne", "Robertson", "Math");
        REMountain.addTeacher("Macie", "Foster", "Science");
        REMountain.addTeacher("Federico", "Mckenzie", "English");

        //add 10 students
        REMountain.addStudent("Shanai", "Mcculloughh", 8);
        REMountain.addStudent("Abbas", "Synder", 4);
        REMountain.addStudent("Ellie", "Acosta", 7);
        REMountain.addStudent("Ava", "Rangel", 5);
        REMountain.addStudent("Caleb", "Burt", 9);
        REMountain.addStudent("Peyton", "Hubbard", 3);
        REMountain.addStudent("Aiysha", "Yates", 8);
        REMountain.addStudent("Cory", "Mcnamara", 2);
        REMountain.addStudent("Liliana", "Hall", 7);
        REMountain.addStudent("Julia", "Cortez", 4);

        //display lists
        REMountain.showAllTeachers();
        REMountain.showAllStudents();

        //remove 1 teacher
        REMountain.removeTeacher(1);

        //remove 2 students
        REMountain.removeStudent(3);
        REMountain.removeStudent(7);

        //display new lists
        REMountain.showAllTeachers();
        REMountain.showAllStudents();
    }
}
