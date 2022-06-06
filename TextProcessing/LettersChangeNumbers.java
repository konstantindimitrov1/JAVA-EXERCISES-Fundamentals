import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        BigDecimal sum = new BigDecimal("0");

        for (int i = 0; i < input.length; i++) {
            String firstLetter = String.valueOf(input[i].charAt(0));
            String lastLetter = String.valueOf(input[i].charAt(input[i].length() - 1));
            int getFirstLetterPosition = firstLetter.toLowerCase().charAt(0) - 96;
            int getLastLetterPosition = lastLetter.toLowerCase().charAt(0) - 96;
            BigDecimal number = new BigDecimal(input[i].substring(1, input[i].length() - 1));

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
