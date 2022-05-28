import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstRowOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondRowOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> finalResult;

        int index = 0;
        if (firstRowOfNumbers.size() > secondRowOfNumbers.size()) {
            index = 1;
            for (Integer secondRowOfNumber : secondRowOfNumbers) {
                firstRowOfNumbers.add(index, secondRowOfNumber);
                index += 2;
            }
            finalResult = firstRowOfNumbers;

        } else {
            for (Integer firstRowOfNumber : firstRowOfNumbers) {
                secondRowOfNumbers.add(index, firstRowOfNumber);
                index += 2;
            }
            finalResult = secondRowOfNumbers;

        }


        System.out.println(finalResult.toString().replaceAll("[\\[\\]]", ""));
    }
}
