import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> virus = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("3:1")) {

            if (input[0].equals("merge")) {
                int startIndex = indexValidationStart(input[1], virus.size());
                int endIndex = indexValidationEnd(input[2], virus.size());
                int concatenations = endIndex - startIndex;

                for (int i = 0; i < concatenations; i++) {
                    virus.set(startIndex, virus.get(startIndex) + virus.get(startIndex + 1));
                    virus.remove(startIndex + 1);
                }

            } else {
                int divideIndex = Integer.parseInt(input[1]);
                List<String> dividedIndex = Arrays.stream(virus.get(divideIndex).split("")).collect(Collectors.toList());

                int portions = Integer.parseInt(input[2]);
                int portionSize = dividedIndex.size() / portions;

                StringBuilder finalResult = new StringBuilder();

                for (int i = 0; i < portions; i++) {
                    for (int j = 0; j < portionSize; j++) {
                        finalResult.append(dividedIndex.get(j));
                    }
                    finalResult.append(" ");
                    if (portionSize > 0) {
                        dividedIndex.subList(0, portionSize).clear();
                    }
                }

                if (!dividedIndex.isEmpty()) {
                    finalResult.setLength(finalResult.length() - 1);
                    for (String index : dividedIndex) {
                        finalResult.append(index);
                    }
                }
                dividedIndex = Arrays.stream(finalResult.toString().split(" ")).collect(Collectors.toList());
                virus.addAll(divideIndex, dividedIndex);
                virus.remove(divideIndex + dividedIndex.size());

            }
            input = scanner.nextLine().split(" ");
        }
        System.out.println(virus.toString().replaceAll("[\\[\\],]", ""));
    }

    static int indexValidationStart(String startIndex, int arraySize) {
        int start = Integer.parseInt(startIndex);
        if (start >= arraySize || start < 0) {
            return 0;
        } else {
            return start;
        }
    }

    static int indexValidationEnd(String endIndex, int arraySize) {
        int end = Integer.parseInt(endIndex);
        if (end <= 0) {
            return 0;
        } else if (end >= arraySize) {
            return arraySize - 1;
        } else {
            return end;
        }
    }
}