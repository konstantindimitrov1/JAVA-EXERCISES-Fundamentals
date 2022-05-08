import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String[] input = scanner.nextLine().split(":");

        while (!input[0].equals("course start")) {

            switch (input[0]) {
                case "Add":
                    if (!lessons.contains(input[1])) {
                        lessons.add(input[1]);
                    }
                    break;
                case "Insert":
                    if (!lessons.contains(input[1])) {
                        int index = Integer.parseInt(input[2]);
                        lessons.add(index, input[1]);
                    }
                    break;
                case "Remove":
                    if (lessons.contains(input[1]) && lessons.contains(input[1] + "-Exercise")) {
                        int index = lessons.indexOf(input[1]);
                        lessons.remove(index + 1);
                        lessons.remove(index);
                    } else {
                        lessons.remove(input[1]);
                    }
                    break;
                case "Swap":
                    if (lessons.contains(input[1]) && lessons.contains(input[2])) {
                        String temporary = input[1];
                        int index = lessons.indexOf(input[1]);
                        int index2 = lessons.indexOf(input[2]);
                        lessons.set(index, input[2]);
                        lessons.set(index2, temporary);
                        if (lessons.contains(input[1] + "-Exercise")) {
                            lessons.remove(input[1] + "-Exercise");
                            lessons.add(index2 + 1, input[1] + "-Exercise");
                        }
                        if (lessons.contains(input[2] + "-Exercise")) {
                            lessons.remove(input[2] + "-Exercise");
                            lessons.add(index + 1, input[2] + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    String temporary = "-Exercise";
                    if (lessons.contains(input[1]) && !lessons.contains(input[1] + temporary)) {
                        int index = lessons.indexOf(input[1]);
                        lessons.add(index + 1, input[1] + temporary);
                    } else if (!lessons.contains(input[1])) {
                        lessons.add(input[1]);
                        lessons.add(input[1] + temporary);
                    }
                    break;
            }

            input = scanner.nextLine().split(":");
        }

        for (int i = 1; i <= lessons.size(); i++) {
            System.out.println(i + "." + lessons.get(i - 1));
        }

    }
}
