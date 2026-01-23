public class Main {
    public static void main(String[] args) {
        try {
            CourseDao courseDao = new CourseDao();
            StudentDao studentDao = new StudentDao();

            System.out.println("=== ASSIGNMENT 3: JDBC CRUD DEMO ===");

            int c1 = courseDao.insert(new Course("Java Programming", 5));
            int c2 = courseDao.insert(new Course("Databases", 4));

            int uniId = 1; // because you inserted 1 university row in pgAdmin
            int s1 = studentDao.insert(new Student("Alice Brown", 2), uniId);

            System.out.println("\n--- AFTER INSERT ---");
            System.out.println("Courses: " + courseDao.findAll());
            System.out.println("Students: " + studentDao.findAll());

            courseDao.updateCredits(c1, 6);
            studentDao.updateYear(s1, 3);

            System.out.println("\n--- AFTER UPDATE ---");
            System.out.println("Courses: " + courseDao.findAll());
            System.out.println("Students: " + studentDao.findAll());

            courseDao.deleteById(c2);
            studentDao.deleteById(s1);

            System.out.println("\n--- AFTER DELETE ---");
            System.out.println("Courses: " + courseDao.findAll());
            System.out.println("Students: " + studentDao.findAll());

            System.out.println("\n DONE: CRUD works");

        } catch (Exception e) {
            System.out.println(" ERROR:");
            e.printStackTrace();
        }
    }
}
