import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removingString = scanner.nextLine();
        String input = scanner.nextLine();


        while (input.contains(removingString)) {
            input = input.replace(removingString, "");
        }
        System.out.println(input);
    }
}
