import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalIncome = 0;

        String input = scanner.nextLine();

        String regex = "%(?<name>[A-Z][a-z]+)%[^$.|%]*?<(?<product>\\w+)>[^$.|%]*?[|](?<quantity>\\d+)[|][^$.|%]*?(?<price>\\d+[.]?\\d+)[$]";

        while (!input.equals("end of shift")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double sumForCurrentPurchase = price * quantity;
                totalIncome += sumForCurrentPurchase;

                System.out.printf("%s: %s - %.2f\n", name, product, sumForCurrentPurchase);
            }


            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);

    }
}
