import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String firstString = input.split(" ")[0];
        String secondString = input.split(" ")[1];

        int totalSum = 0;

        int firstStringLength = firstString.length();
        int secondStringLength = secondString.length();

        int multiplyChars = Integer.min(firstStringLength, secondStringLength);
        for (int i = 0; i < multiplyChars; i++) {
            totalSum += multiplyChar(firstString.charAt(i), secondString.charAt(i));
        }

        if (firstStringLength != secondStringLength) {
            if (firstStringLength > secondStringLength) {
                totalSum += sumRest(firstString, multiplyChars);
            } else {
                totalSum += sumRest(secondString, multiplyChars);

            }
        }

        System.out.println(totalSum);
    }

    private static int sumRest(String string, int multiplyChars) {
        String restChars = string.substring(multiplyChars);
        int result = 0;
        for (int i = 0; i < restChars.length(); i++) {
            result += restChars.charAt(i);
        }
        return result;
    }

    private static int multiplyChar(char charAt, char charAt1) {
        return charAt * charAt1;
    }
}
