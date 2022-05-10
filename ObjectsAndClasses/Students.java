import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentData = scanner.nextLine();

        List<Student> studentList = new ArrayList<>();

        while (!studentData.equals("end")) {
            String[] splitByData = studentData.split(" ");
            Student student = new Student();
            student.setFirstName(splitByData[0]);
            student.setLastName(splitByData[1]);
            student.setAge(Integer.parseInt(splitByData[2]));
            student.setHometown(splitByData[3]);
            studentList.add(student);

            studentData = scanner.nextLine();
        }

        String city = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getHometown().equals(city)) {
                String formattedString = String.format("%s %s is %d years old", student.getFirstName(), student.getLastName(), student.getAge());
                System.out.println(formattedString);
            }
        }
    }
}

class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}