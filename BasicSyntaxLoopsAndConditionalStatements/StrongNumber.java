import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            int multiplication = 1;
            char number = input.charAt(i);
            for (int j = Character.getNumericValue(number); j > 0; j--) {
                multiplication *= j;
            }
            sum += multiplication;
        }
        if (num == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
