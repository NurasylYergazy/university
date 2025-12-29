import java.util.Objects;

public abstract class Person {
    private String fullName;

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + "{fullName='" + fullName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return fullName.equals(person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
