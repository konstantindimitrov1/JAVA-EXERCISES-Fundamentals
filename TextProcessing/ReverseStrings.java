
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            StringBuilder reversedWord = new StringBuilder();
            reversedWord.append(input);
            reversedWord.reverse();
            System.out.println(input + " = " + reversedWord);
            input = scanner.nextLine();
        }
    }
}
