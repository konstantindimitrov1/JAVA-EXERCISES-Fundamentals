import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magicNumber = Integer.parseInt(scanner.nextLine());
        printTopNumber(magicNumber);
    }

    private static void printTopNumber(int magicNumber) {
        for (int i = 1; i <= magicNumber; i++) {
            if (isOddDigitPresent(i) && isSumDivisibleByEight(i)) {
                System.out.println(i);
            }

        }
    }

    static boolean isOddDigitPresent(int i) {
        while (i != 0) {
            int digit = i;
            digit %= 10;
            if (digit % 2 != 0) {
                return true;
            }
            i /= 10;
        }
        return false;
    }

    static boolean isSumDivisibleByEight(int i) {
        int sum = 0;
        while (i != 0) {
            int digit = i;
            sum += digit % 10;
            i /= 10;
        }
        return sum % 8 == 0;
    }
}
