import java.util.Scanner;

public class CutStringInHalf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(firstHalfOfAString(str));

    }

    private static String firstHalfOfAString(String str) {
        return str.substring(str.length() / 2);
    }

}
