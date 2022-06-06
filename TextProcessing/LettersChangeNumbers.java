import java.math.BigDecimal;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        BigDecimal sum = new BigDecimal("0");

        for (String s : input) {
            String firstLetter = String.valueOf(s.charAt(0));
            String lastLetter = String.valueOf(s.charAt(s.length() - 1));
            int getFirstLetterPosition = firstLetter.toLowerCase().charAt(0) - 96;
            int getLastLetterPosition = lastLetter.toLowerCase().charAt(0) - 96;
            BigDecimal number = new BigDecimal(s.substring(1, s.length() - 1));

            if (Character.isLowerCase(firstLetter.charAt(0))) {
                number = number.multiply(BigDecimal.valueOf(getFirstLetterPosition));
            } else {
                double newDecimal = number.doubleValue() / getFirstLetterPosition;
                number = new BigDecimal(String.valueOf(BigDecimal.valueOf(newDecimal)));
            }

            if (Character.isLowerCase(lastLetter.charAt(0))) {
                number = number.add(BigDecimal.valueOf(getLastLetterPosition));
            } else {
                number = number.subtract(BigDecimal.valueOf(getLastLetterPosition));
            }

            sum = sum.add(number);
        }


        System.out.printf("%.2f", sum);
    }
}
