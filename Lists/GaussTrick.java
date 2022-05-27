import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        if (numbers.size() % 2 == 0) {
            sumEvenSizeList(numbers);
        } else {
            sumOddSizeList(numbers);
        }
        printResult(numbers);
    }

    static void sumEvenSizeList(List<Integer> numbers) {
        for (int i = 0; i <= numbers.size() / 2; i++) {
            numbers.add(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(i + 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    static void sumOddSizeList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() / 2; i++) {
            numbers.add(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(i + 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    static void printResult(List<Integer> numbers) {
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
