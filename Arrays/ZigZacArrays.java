import java.util.Arrays;
import java.util.Scanner;

public class ZigZacArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[n];
        int[] array2 = new int[n];


        for (int i = 0; i < n; i++) {
            int[] arrayFromScan = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i % 2 == 0) {
                array1[i] = arrayFromScan[0];
                array2[i] = arrayFromScan[1];
            } else {
                array1[i] = arrayFromScan[1];
                array2[i] = arrayFromScan[0];
            }
        }
        for (int j : array1) {
            System.out.printf("%d ", j);
        }
        System.out.println();
        for (int j : array2) {
            System.out.printf("%d ", j);
        }
    }
}
