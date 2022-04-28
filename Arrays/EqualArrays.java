import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");

        int[] arr1 = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int index;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                index = i;
                System.out.printf("Arrays are not identical. Found difference at %d index.", index);
                return;
            } else {
                sum += arr1[i];
            }
        }
        System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}