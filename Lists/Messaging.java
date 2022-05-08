import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int sumOfDigits = 0;
            int[] digits = Arrays.stream(numbers.get(i).split("")).mapToInt(Integer::parseInt).toArray();
            for (int digit : digits) {
                sumOfDigits += digit;
            }
            numbers.set(i, String.valueOf(sumOfDigits));
        }

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int lengthOfInput = input.length();
        for (String number : numbers) {
            int index = Integer.parseInt(number) % lengthOfInput;
            output.append(input.substring(index, index + 1));
            input.delete(index, index + 1);
        }

        System.out.println(output);
    }
}
