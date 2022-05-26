
import java.util.Scanner;

public class SignOfIntegerNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        sign(number);

    }

    public static void sign(int n) {
        if (n < 0) {
            System.out.printf("The number %d is negative.", n);
        } else if (n == 0) {
            System.out.printf("The number %d is zero.", n);
        } else {
            System.out.printf("The number %d is positive.", n);
        }
    }

}
