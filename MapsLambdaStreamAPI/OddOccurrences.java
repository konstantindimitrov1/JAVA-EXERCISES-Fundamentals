import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).toList();

        Map<String, Integer> mapOfWords = new LinkedHashMap<>();

        for (String word : words) {
            if (mapOfWords.containsKey(word.toLowerCase())) {
                mapOfWords.put(word.toLowerCase(), mapOfWords.get(word.toLowerCase()) + 1);
            } else {
                mapOfWords.putIfAbsent(word.toLowerCase(), 1);
            }
        }

        StringBuilder finalString = new StringBuilder();

        for (Map.Entry<String, Integer> word : mapOfWords.entrySet()) {
            if (word.getValue() % 2 != 0) {
                finalString.append(word.getKey() + ", ");
            }
        }

        System.out.println(finalString.substring(0, finalString.length() - 2));

    }
}


