import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demons = Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).sorted().toList();

        for (String demon : demons) {
            int demonHP = 0;
            Pattern patternForHP = Pattern.compile("[^-0-9+*/.]");
            Matcher matcherForHP = patternForHP.matcher(demon);
            while (matcherForHP.find()) {
                demonHP += matcherForHP.group().charAt(0);
            }

            double demonDMG = 0;
            Pattern patternForDMG = Pattern.compile("-?\\d+[.]?\\d*");
            Matcher matcherForDmG = patternForDMG.matcher(demon);
            while (matcherForDmG.find()) {
                demonDMG += Double.parseDouble(matcherForDmG.group());
            }
            Pattern patternForMultiply = Pattern.compile("[*]");
            Matcher matcherForMultiply = patternForMultiply.matcher(demon);
            while (matcherForMultiply.find()) {
                demonDMG *= 2;
            }
            Pattern patternForDivide = Pattern.compile("[/]");
            Matcher matcherForDivide = patternForDivide.matcher(demon);
            while (matcherForDivide.find()) {
                demonDMG /= 2;
            }
            System.out.printf("%s - %d health, %.2f damage\n", demon, demonHP, demonDMG);
        }
    }
}
