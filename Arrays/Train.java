import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());
        int[] people = new int[wagons];

        for (int i = 0; i < wagons; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());
        }

        int totalPassengers = 0;
        for (int i : people) {
            System.out.print(i + " ");
            totalPassengers += i;
        }
        System.out.println();
        System.out.println(totalPassengers);
    }
}
