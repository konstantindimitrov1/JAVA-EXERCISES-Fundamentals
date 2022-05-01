import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        System.out.println(new DecimalFormat("0.####").format(mathPower(n1, n2)));
    }

    private static double mathPower(double n1, double n2) {
        return Math.pow(n1, n2);
    }
}
