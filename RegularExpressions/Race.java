
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(", ");
        Map<String, Integer> competitors = new LinkedHashMap<>();
        for (String name : names) {
            competitors.put(name, 0);
        }

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            String regex = "[A-Za-z]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            StringBuilder matchedName = new StringBuilder();
            while (matcher.find()) {
                matchedName.append(matcher.group());
            }
            String matchedNameToString = matchedName.toString();
            if (competitors.containsKey(matchedNameToString)) {
                int sumKM = 0;
                Pattern patternKM = Pattern.compile("[0-9]");
                Matcher matcherKM = patternKM.matcher(input);
                while (matcherKM.find()) {
                    sumKM += Integer.parseInt(matcherKM.group());
                }
                competitors.put(matchedNameToString, sumKM + competitors.get(matchedNameToString));
            }


            input = scanner.nextLine();
        }

        List<String> top3 = competitors.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(Map.Entry::getKey).toList();

        System.out.printf("1st place: %s\n2nd place: %s\n3rd place: %s", top3.get(0), top3.get(1), top3.get(2));
    }
}