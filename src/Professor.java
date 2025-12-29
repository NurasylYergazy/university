public class Professor extends Person {
    private String department;

    public Professor(String fullName, String department) {
        super(fullName);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public String toString() {
        return "Professor{fullName='" + getFullName() +
                "', department='" + department + "'}";
    }
}
