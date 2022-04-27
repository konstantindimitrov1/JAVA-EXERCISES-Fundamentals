import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.equals("(")) {
                count1++;
            } else if (input.equals(")")) {
                count2++;
            }
            if (count1<count2) {
                System.out.println("UNBALANCED");
                return;
            }
        }
        if (count1 == count2) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}