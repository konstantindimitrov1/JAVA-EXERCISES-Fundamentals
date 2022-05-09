import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder finalArray = new StringBuilder();
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\|")).toList();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            finalArray.append(numbers.get(i));
            finalArray.append(" ");
        }

        System.out.println(finalArray.toString().replaceAll("\\s+" , " "));
    }
}
