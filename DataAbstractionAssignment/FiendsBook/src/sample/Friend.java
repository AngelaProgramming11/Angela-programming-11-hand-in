package sample;

public class Friend {
    private String firstName;
    private String lastName;
    private int age;
    private String favoriteColor;

    //contructors
    Friend(){
        firstName = "";
        lastName = "";
        age = 0;
        favoriteColor = "";
    }
    Friend(String firstName, String lastName, int age, String favoriteColor){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favoriteColor = favoriteColor;
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    //to string override
    @Override
    public String toString() {
        return this.firstName;
    }
}
