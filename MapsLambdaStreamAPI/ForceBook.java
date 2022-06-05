import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> forceSides = new TreeMap<>();

        while (!input.equals("Lumpawaroo")) {
            String side = fillSide(input);
            String user = fillUser(input);

            boolean isUserExistent = isUserHere(forceSides, user);

            if (!forceSides.containsKey(side)) {
                forceSides.put(side, new ArrayList<>());
            }

            if (input.contains(" | ")) {
                if (!isUserExistent) {
                    forceSides.get(side).add(user);
                    forceSides.put(side, forceSides.get(side));
                }
            } else {
                if (isUserExistent) {
                    for (Map.Entry<String, List<String>> entry : forceSides.entrySet()) {
                        entry.getValue().remove(user);
                    }
                }
                forceSides.get(side).add(user);
                forceSides.put(side, forceSides.get(side));
                System.out.println(user + " joins the " + side + " side!");
            }

            input = scanner.nextLine();
        }

        forceSides.entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d\n", e.getKey(), e.getValue().size());
                    e.getValue().stream().sorted(String::compareTo)
                            .forEach(element -> System.out.printf("! %s\n", element));
                });
    }

    private static boolean isUserHere(Map<String, List<String>> forceSides, String user) {
        for (Map.Entry<String, List<String>> entry : forceSides.entrySet()) {
            if (entry.getValue().contains(user)) {
                return true;
            }
        }
        return false;
    }

    private static String fillUser(String input) {
        if (input.contains(" -> ")) {
            return input.split(" -> ")[0];
        } else {
            return input.split(" \\| ")[1];
        }
    }

    private static String fillSide(String input) {
        if (input.contains(" -> ")) {
            return input.split(" -> ")[1];
        } else {
            return input.split(" \\| ")[0];
        }

    }


}