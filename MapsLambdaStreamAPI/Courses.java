import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" : ");

        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input[0].equals("end")) {
            String course = input[0];
            String studentName = input[1];
            List<String> students = new ArrayList<>();

            if (courses.containsKey(course)) {
                students = courses.get(course);
            }
            students.add(studentName);
            Collections.sort(students);
            courses.put(course, students);

            input = scanner.nextLine().split(" : ");
        }

        courses.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().forEach(student -> System.out.println("-- " + student));
                });

    }
}
