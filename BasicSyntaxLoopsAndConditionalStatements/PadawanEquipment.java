import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsabrePrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int beltsFree = students / 6;
        double lightsabresTotal = Math.ceil(students * 1.1);
        double totalSum = (students - beltsFree) * beltPrice + robePrice * students + lightsabresTotal * lightsabrePrice;

        if (totalSum > money) {
            System.out.printf("George Lucas will need %.2flv more.", totalSum - money);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        }

    }
}