import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double mark = Double.parseDouble(scanner.nextLine());

            if (!studentsGrades.containsKey(name)) {
                studentsGrades.put(name, new ArrayList<>());
            }
            studentsGrades.get(name).add(mark);
            studentsGrades.put(name, studentsGrades.get(name));
        }

        studentsGrades.entrySet().stream()
                .filter(e -> e.getValue().stream().mapToDouble(element -> element).average().orElse(0) >= 4.5)
                .sorted((e1, e2) -> Double.compare(e2.getValue().stream().mapToDouble(e3 -> e3).average().orElse(0), e1.getValue().stream().mapToDouble(e4 -> e4).average().orElse(0)))
                .forEach(e -> System.out.printf("%s -> %.2f\n", e.getKey(), e.getValue().stream().mapToDouble(z -> z).average().orElse(0)));

    }
}
