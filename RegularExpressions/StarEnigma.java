import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> destroyedPlanets = new ArrayList<>();
        List<String> attackedPlanets = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int decryptionKey = 0;
            Pattern decryptionKeyPattern = Pattern.compile("[starSTAR]");
            Matcher decryptionKeyMatcher = decryptionKeyPattern.matcher(input);
            while (decryptionKeyMatcher.find()) {
                decryptionKey++;
            }
            StringBuilder encryptedMessage = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                encryptedMessage.append((char) (input.charAt(j) - decryptionKey));
            }
            Pattern pattern = Pattern.compile("@(?<planet>[A-Za-z]+)[^-@!:>]*:(?<population>\\d+)[^-@!:>]*!(?<attack>[AD])![^-@!:>]*->(?<soldiers>\\d+)");
            Matcher matcher = pattern.matcher(encryptedMessage.toString());
            if (matcher.find()) {
                if (matcher.group("attack").equals("A")) {
                    attackedPlanets.add(matcher.group("planet"));
                } else {
                    destroyedPlanets.add(matcher.group("planet"));
                }
            }
        }

        System.out.printf("Attacked planets: %d\n", attackedPlanets.size());
        attackedPlanets.stream().sorted(String::compareTo)
                .forEach(e -> System.out.printf("-> %s\n", e));

        System.out.printf("Destroyed planets: %d\n", destroyedPlanets.size());
        destroyedPlanets.stream().sorted(String::compareTo)
                .forEach(e -> System.out.printf("-> %s\n", e));

    }
}