import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Map<String, String> register = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String user = input[1];
            if (command.equals("register")) {
                String licensePlateNumber = input[2];
                if (register.containsKey(user)) {
                    System.out.printf("ERROR: already registered with plate number %s\n", register.get(user));
                } else {
                    register.put(user, licensePlateNumber);
                    System.out.println(user + " registered " + licensePlateNumber + " successfully");
                }
            } else {
                if (register.containsKey(user)) {
                    register.remove(user);
                    System.out.println(user + " unregistered successfully");
                } else {
                    System.out.println("ERROR: user " + user + " not found");
                }
            }
        }

        for (Map.Entry<String, String> entry : register.entrySet()) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }

    }
}
