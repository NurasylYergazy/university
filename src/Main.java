public class Main {
    public static void main(String[] args) {

        Course c1 = new Course("Java Programming", 5);
        Course c2 = new Course("Web Development", 4);

        Professor p = new Professor("Dr. John Smith", "Computer Science");
        University u = new University("Astana IT University", "Astana");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(p);
        System.out.println(u);

        if (c1.getCredits() > c2.getCredits()) {
            System.out.println(c1.getName() + " has more credits");
        } else {
            System.out.println(c2.getName() + " has more credits");
        }
    }
}