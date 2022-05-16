import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> userPoints = new TreeMap<>();

        Map<String, Integer> submissions = new TreeMap<>();

        while (!input.equals("exam finished")) {
            String username = input.split("-")[0];
            String language = input.split("-")[1];
            if (language.equals("banned")) {
                userPoints.remove(username);
            } else {
                int points = Integer.parseInt(input.split("-")[2]);
                if ((submissions.containsKey(language))) {
                    submissions.put(language, submissions.get(language) + 1);
                }
                submissions.putIfAbsent(language, 1);
                if (userPoints.containsKey(username)) {
                    if (userPoints.get(username) < points) {
                        userPoints.put(username, points);
                    }
                } else {
                    userPoints.put(username, points);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");

        userPoints.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> System.out.printf("%s | %d\n", e.getKey(), e.getValue()));

        System.out.println("Submissions:");

        submissions.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> System.out.printf("%s - %d\n", e.getKey(), e.getValue()));
    }
}
