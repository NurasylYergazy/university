import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {
    private String name;
    private String city;

    private List<Course> courses = new ArrayList<>();
    private List<Person> people = new ArrayList<>();

    public University(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person findPersonByName(String name) {
        for (Person p : people) {
            if (p.getFullName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public void sortCoursesByCredits() {
        courses.sort(Comparator.comparingInt(Course::getCredits));
    }

    @Override
    public String toString() {
        return "University{name='" + name +
                "', city='" + city +
                "', people=" + people +
                ", courses=" + courses + "}";
    }
}
