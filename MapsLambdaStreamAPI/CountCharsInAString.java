import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine().replaceAll(" ", "");

        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (charCount.containsKey(input.charAt(i))) {
                charCount.put(input.charAt(i), charCount.get(input.charAt(i)) + 1);
            } else {
                charCount.putIfAbsent(input.charAt(i), 1);
            }
        }

        charCount.forEach((key, value) -> System.out.printf("%c -> %d\n", key, value));
    }
}