import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int startIndexOfName = input.lastIndexOf('\\');
        int startIndexOfExtension = input.lastIndexOf('.');

        String name = input.substring(startIndexOfName + 1, startIndexOfExtension);
        String extension = input.substring(startIndexOfExtension + 1);

        System.out.printf("File name: %s\nFile extension: %s", name, extension);
    }
}
