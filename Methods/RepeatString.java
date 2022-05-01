import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int multiply = Integer.parseInt(scanner.nextLine());
        System.out.println(multiplyString(input, multiply));
    }

    private static String multiplyString(String input, int multiply) {
        return String.valueOf(input).repeat(Math.max(0, multiply));
    }

}
