import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int sumOdd = 0;
        int sumEven = 0;

        String[] toArr = input.split(" ");
        int[] numbers = Arrays.stream(toArr).mapToInt(Integer::parseInt).toArray();
        for (int number : numbers) {
            if (number % 2 == 0) {
                sumEven += number;
            } else {
                sumOdd += number;
            }
        }
        int result = sumEven - sumOdd;
        System.out.println(result);
    }
}
