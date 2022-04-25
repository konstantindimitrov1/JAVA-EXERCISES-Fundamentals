import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magicNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int number;

        for (int i = 1; i <= magicNumber; i++) {
            number = i;
            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
            sum = 0;
        }
    }
}