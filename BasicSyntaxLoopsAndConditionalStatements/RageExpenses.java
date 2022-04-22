import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gamesLost = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetTrash = 0;
        int mouseTrash = 0;
        int keyboardTrash = 0;

        for (int i = 1; i <= gamesLost; i++) {
            if (i % 2 == 0) {
                headsetTrash++;
            }
            if (i % 3 == 0) {
                mouseTrash++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboardTrash++;
            }
        }

        int displayTrash = keyboardTrash / 2;

        double totalCost = headsetPrice * headsetTrash + mousePrice * mouseTrash + keyboardPrice * keyboardTrash + displayPrice * displayTrash;

        System.out.printf("Rage expenses: %.2f lv.", totalCost);
    }
}