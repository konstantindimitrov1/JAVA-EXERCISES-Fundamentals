import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> usernames = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        for (int i = 0; i < usernames.size(); i++) {
            String username = usernames.get(i);
            boolean length = checkLength(username);
            boolean symbols = checkSymbols(username);

            if (!length || !symbols) {
                usernames.remove(i);
                i--;
            }
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }

    private static boolean checkSymbols(String username) {
        for (int i = 0; i < username.length(); i++) {
            char check = username.charAt(i);
            if (!Character.isLetterOrDigit(check)) {
                if (!(check == '-')) {
                    if (!(check == '_')) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkLength(String username) {
        return username.length() >= 3 && username.length() <= 16;
    }
}