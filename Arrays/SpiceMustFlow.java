import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int cropNextDay = 0;
        int totalCrop = 0;
        int days = 0;

        while (startingYield >= 100) {
            days++;
            totalCrop += startingYield;
            totalCrop -= 26;
            startingYield -= 10;
        }
        totalCrop -= 26;
        if (totalCrop < 0) {
            totalCrop = 0;
        }
        System.out.println(days);
        System.out.println(totalCrop);
    }
}
