import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbersByOccurrence = new TreeMap<>();

        for (double number : numbers) {
            if (!numbersByOccurrence.containsKey(number)) {
                numbersByOccurrence.put(number, 1);
            } else {
                numbersByOccurrence.put(number, numbersByOccurrence.get(number) + 1);
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> doubleIntegerEntry : numbersByOccurrence.entrySet()) {
            System.out.printf("%s -> %d\n", decimalFormat.format(doubleIntegerEntry.getKey()), doubleIntegerEntry.getValue());
        }
    }
}