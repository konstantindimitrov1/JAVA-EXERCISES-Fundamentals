
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Random myRandomWords = new Random();

        while (!words.isEmpty()) {
            int randomWord = myRandomWords.nextInt(words.size());
            System.out.println(words.remove(randomWord));
        }
    }
}
