import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = new String[7];
        daysOfWeek[0] = "Monday";
        daysOfWeek[1] = "Tuesday";
        daysOfWeek[2] = "Wednesday";
        daysOfWeek[3] = "Thursday";
        daysOfWeek[4] = "Friday";
        daysOfWeek[5] = "Saturday";
        daysOfWeek[6] = "Sunday";

        int dayOfWeek = Integer.parseInt(scanner.nextLine());
        if (dayOfWeek <= 7 && dayOfWeek >= 1) {
            System.out.println(daysOfWeek[dayOfWeek - 1]);
        } else {
            System.out.println("Invalid day!");
        }

    }
}
