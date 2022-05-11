import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> words = Arrays.stream(input.split(" ")).filter(word -> word.length() % 2 == 0).toList();

        for (String word : words) {
            System.out.println(word);
        }
    }
}
