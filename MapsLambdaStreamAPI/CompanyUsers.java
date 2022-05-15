import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> companies = new TreeMap<>();

        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<>());
            }
            if (!companies.get(company).contains(employeeID)) {
                companies.get(company).add(employeeID);
            }

            input = scanner.nextLine();
        }

        companies.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(e -> System.out.printf("-- %s\n", e));
        });

    }
}
