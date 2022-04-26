import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long bestSnowball = 0;
        int snow = 0;
        int time = 0;
        int quality = 0;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long snowballValue = (long) Math.pow(snowballSnow / snowballTime, snowballQuality);
            if (snowballValue >= bestSnowball) {
                bestSnowball = snowballValue;
                snow = snowballSnow;
                time = snowballTime;
                quality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %d (%d)", snow, time, bestSnowball, quality);

    }
}
