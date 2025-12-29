public class Student extends Person {
    private int year;

    public Student(String fullName, int year) {
        super(fullName);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
