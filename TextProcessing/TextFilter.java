import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            StringBuilder replace = new StringBuilder();
            replace.append("*".repeat(bannedWord.length()));
            text = text.replace(bannedWord, replace.toString());
        }

        System.out.println(text);
    }
}

