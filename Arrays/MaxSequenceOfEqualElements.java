import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int times = 1;
        int number = 0;

        for (int i = 0; i < numbers.length; i++) {
            int temp = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    temp++;
                } else {
                    break;
                }
            }
            if (temp > times) {
                times = temp;
                number = numbers[i];
            }
        }
        for (int i = 0; i < times; i++) {
            System.out.print(number + " ");
        }
    }
}
