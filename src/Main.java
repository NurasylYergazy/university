public class Main {
    public static void main(String[] args) {

        University u = new University("Astana IT University", "Astana");

        Course c1 = new Course("Java Programming", 5);
        Course c2 = new Course("Web Development", 4);

        Professor p = new Professor("Dr. John Smith", "Computer Science");
        Student s = new Student("Alice Brown", 2);

        u.addCourse(c1);
        u.addCourse(c2);

        u.addPerson(p);
        u.addPerson(s);

        System.out.println(u);

        System.out.println("Search person: " +
                u.findPersonByName("Alice Brown"));

        u.sortCoursesByCredits();
        System.out.println("After sorting:");
        System.out.println(u);
    }
}
