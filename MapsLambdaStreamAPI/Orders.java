import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split(" ");

        while (!tokens[0].equals("buy")) {
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (!productsPrice.containsKey(product)) {
                productsQuantity.put(product, quantity);
            } else {
                productsQuantity.put(product, productsQuantity.get(product) + quantity);
            }
            productsPrice.put(product, price);

            tokens = scanner.nextLine().split(" ");
        }

        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {
            for (Map.Entry<String, Double> doubleEntry : productsPrice.entrySet()) {
                if (entry.getKey().equals(doubleEntry.getKey())) {
                    System.out.printf("%s -> %.2f\n", entry.getKey(), entry.getValue() * doubleEntry.getValue());
                    break;
                }
            }
        }
    }
}
