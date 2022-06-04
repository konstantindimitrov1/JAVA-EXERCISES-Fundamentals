import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, String> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String key = scanner.nextLine();
            String value = scanner.nextLine();
            if (synonyms.containsKey(key)) {
                synonyms.put(key, synonyms.get(key) + ", " + value);
            }
            synonyms.putIfAbsent(key, value);
        }

        for (Map.Entry<String, String> stringStringEntry : synonyms.entrySet()) {
            System.out.printf("%s - %s\n", stringStringEntry.getKey(), stringStringEntry.getValue());
        }

    }
}
