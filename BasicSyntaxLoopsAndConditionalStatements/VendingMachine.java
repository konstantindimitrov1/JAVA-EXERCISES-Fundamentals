import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;
        double moneySpent = 0;

        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);

            if (money == 2) {
                sum += 2;
            } else if (money == 1) {
                sum += 1;
            } else if (money == 0.5) {
                sum += 0.5;
            } else if (money == 0.2) {
                sum += 0.2;
            } else if (money == 0.1) {
                sum += 0.1;
            } else {
                System.out.printf("Cannot accept %.2f\n", money);
            }
            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("End")) {

            switch (input2) {
                case "Nuts":
                    moneySpent += 2;
                    if (moneySpent > sum) {
                        System.out.println("Sorry, not enough money");
                        moneySpent -= 2;
                    } else {
                        System.out.println("Purchased Nuts");
                    }
                    break;
                case "Water":
                    moneySpent += 0.7;
                    if (moneySpent > sum) {
                        System.out.println("Sorry, not enough money");
                        moneySpent -= 0.7;
                    } else {
                        System.out.println("Purchased Water");
                    }
                    break;
                case "Crisps":
                    moneySpent += 1.5;
                    if (moneySpent > sum) {
                        System.out.println("Sorry, not enough money");
                        moneySpent -= 1.5;
                    } else {
                        System.out.println("Purchased Crisps");
                    }
                    break;
                case "Soda":
                    moneySpent += 0.8;
                    if (moneySpent > sum) {
                        System.out.println("Sorry, not enough money");
                        moneySpent -= 0.8;
                    } else {
                        System.out.println("Purchased Soda");
                    }
                    break;
                case "Coke":
                    moneySpent += 1;
                    if (moneySpent > sum) {
                        System.out.println("Sorry, not enough money");
                        moneySpent -= 1;
                    } else {
                        System.out.println("Purchased Coke");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            input2 = scanner.nextLine();

        }
        System.out.printf("Change: %.2f", sum - moneySpent);
    }
}
