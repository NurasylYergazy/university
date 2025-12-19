public class Professor {
    private String fullName;
    private String department;

    public Professor(String fullName, String department) {
        this.fullName = fullName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor{fullName='" + fullName + "', department='" + department + "'}";
    }
}
