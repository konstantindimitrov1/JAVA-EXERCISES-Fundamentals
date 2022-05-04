import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "exchange":
                    if (workNumber(command) < array.length && workNumber(command) >= 0) {
                        array = exchange(array, command);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (command[1].equals("even")) {
                        if (maxEven(array) >= 0) {
                            System.out.println(maxEven(array));
                        } else {
                            System.out.println("No matches");
                        }
                    } else if (command[1].equals("odd")) {
                        if (maxOdd(array) >= 0) {
                            System.out.println(maxOdd(array));
                        } else {
                            System.out.println("No matches");
                        }
                    }
                    break;
                case "min":
                    if (command[1].equals("even")) {
                        if (minEven(array) >= 0) {
                            System.out.println(minEven(array));
                        } else {
                            System.out.println("No matches");
                        }
                    } else if (command[1].equals("odd")) {
                        if (minOdd(array) >= 0) {
                            System.out.println(minOdd(array));
                        } else {
                            System.out.println("No matches");
                        }
                    }
                    break;
                case "first":
                    if (command[2].equals("even")) {
                        firstEven(array, command);
                    } else if (command[2].equals("odd")) {
                        firstOdd(array, command);
                    }
                    break;
                case "last":
                    if (command[2].equals("even")) {
                        lastEven(array, command);
                    } else if (command[2].equals("odd")) {
                        lastOdd(array, command);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(array));
    }

    static void lastEven(int[] array, String[] command) {
        int count = workNumber(command);
        StringBuilder lastNumbers = new StringBuilder();
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] % 2 == 0) {
                    lastNumbers.append(array[i]);
                    lastNumbers.append(" ");
                    count--;
                }
                if (count == 0) {
                    break;
                }
            }
            if (count == workNumber(command)) {
                System.out.println("[]");
            } else {
                int[] numbers = Arrays.stream(lastNumbers.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] printLastNumbers = new int[numbers.length];
                int count2 = 0;
                for (int i = numbers.length - 1; i >= 0; i--) {
                    printLastNumbers[i] = numbers[count2];
                    count2++;
                }
                System.out.println(Arrays.toString(printLastNumbers));
            }
        }
    }

    static void lastOdd(int[] array, String[] command) {
        int count = workNumber(command);
        StringBuilder lastNumbers = new StringBuilder();
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] % 2 != 0) {
                    lastNumbers.append(array[i]);
                    lastNumbers.append(" ");
                    count--;
                }
                if (count == 0) {
                    break;
                }
            }
            if (count == workNumber(command)) {
                System.out.println("[]");
            } else {
                int[] numbers = Arrays.stream(lastNumbers.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] printLastNumbers = new int[numbers.length];
                int count2 = 0;
                for (int i = numbers.length - 1; i >= 0; i--) {
                    printLastNumbers[i] = numbers[count2];
                    count2++;
                }
                System.out.println(Arrays.toString(printLastNumbers));
            }
        }
    }


    static void firstOdd(int[] array, String[] command) {
        int count = workNumber(command);
        StringBuilder numbers = new StringBuilder();
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            for (int j : array) {
                if (j % 2 != 0) {
                    numbers.append(j);
                    numbers.append(" ");
                    count--;
                }
                if (count == 0) {
                    break;
                }
            }
            if (count == workNumber(command)) {
                System.out.println("[]");
            } else {
                int[] numbersArray = Arrays.stream(numbers.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(Arrays.toString(numbersArray));
            }
        }
    }

    static void firstEven(int[] array, String[] command) {
        int count = workNumber(command);
        StringBuilder numbers = new StringBuilder();
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            for (int j : array) {
                if (j % 2 == 0) {
                    numbers.append(j);
                    numbers.append(" ");
                    count--;
                }
                if (count == 0) {
                    break;
                }
            }
            if (count == workNumber(command)) {
                System.out.println("[]");
            } else {
                int[] numbersArray = Arrays.stream(numbers.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(Arrays.toString(numbersArray));
            }
        }
    }


    static int minOdd(int[] array) {
        int index = -1;
        int minOddNumber = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] <= minOddNumber) {
                minOddNumber = array[i];
                index = i;
            }
        }
        return index;
    }

    static int minEven(int[] array) {
        int index = -1;
        int minEvenNumber = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] <= minEvenNumber) {
                minEvenNumber = array[i];
                index = i;
            }
        }
        return index;
    }


    static int maxOdd(int[] array) {
        int index = -1;
        int maxOddNumber = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] >= maxOddNumber) {
                maxOddNumber = array[i];
                index = i;
            }
        }
        return index;
    }

    static int maxEven(int[] array) {
        int index = -1;
        int maxEvenNumber = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] >= maxEvenNumber) {
                maxEvenNumber = array[i];
                index = i;
            }
        }
        return index;
    }

    static int[] exchange(int[] array, String[] command) {
        int[] finalArray = new int[array.length];
        int arraySecondPart = 0;
        for (int i = 0; i < array.length; i++) {
            if (i + workNumber(command) + 1 < array.length) {
                finalArray[i] = array[i + workNumber(command) + 1];
            } else {
                finalArray[i] = array[arraySecondPart];
                arraySecondPart++;
            }
        }
        return finalArray;
    }

    static int workNumber(String[] command) {
        return Integer.parseInt(command[1]);
    }

}