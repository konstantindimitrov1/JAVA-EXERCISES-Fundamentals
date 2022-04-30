import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kegsTotal = Integer.parseInt(scanner.nextLine());
        double biggestKeg = Integer.MIN_VALUE;
        String name = "";

        for (int i = 0; i < kegsTotal; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > biggestKeg) {
                biggestKeg = volume;
                name = model;
            }
        }
        System.out.println(name);
    }
}
