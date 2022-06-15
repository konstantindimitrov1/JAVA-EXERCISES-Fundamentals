import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = ">>(?<furniture>\\w+)<<(?<price>\\d+[.]?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> furnitureBought = new ArrayList<>();
        double sum = 0;

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
                sum += price;
                furnitureBought.add(furniture);
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furnitureBought.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);

    }
}
