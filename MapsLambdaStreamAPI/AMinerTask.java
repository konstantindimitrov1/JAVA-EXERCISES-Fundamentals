import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(input)) {
                resources.put(input, resources.get(input) + quantity);
            } else {
                resources.putIfAbsent(input, quantity);
            }

            input = scanner.nextLine();
        }

        resources.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
