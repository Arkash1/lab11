import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Student[] students = new Student[3];
        students[0] = new Student(20, "Иванов Иван Иванович", "+79991234567", 2020, Calendar.SEPTEMBER, 1,  3, "Физика");
        students[1] = new Student(21, "Петров Петр Петрович", "+79992345678",2021, Calendar.SEPTEMBER, 1,   2, "Математика");
        students[2] = new Student(22, "Сидоров Сидор Сидорович", "+79993456789",2019, Calendar.SEPTEMBER, 1,  4, "Физика");
        for (Student student: students){
            student.DisplayInfo();
        }
        System.out.print("Задайте факультет: ");
        String assignedFaculty = in.nextLine();
        for (Student student: students) {
            if (Objects.equals(student.Faculty, assignedFaculty)){
                student.DisplayInfo();
            }
        }
        System.out.print("Задайте год: ");
        int assignedYear = in.nextInt();
        for (Student student: students){
            if (student.getDateOfYear() > assignedYear){
                student.DisplayInfo();
            }
        }
    }
}
class Person {
    private int Age;
    public String fullName;
    public String Phone;
    Person(int Age, String fullName, String Phone){
        this.Age = Age;
        this.fullName = fullName;
        this.Phone = Phone;
    }
    public void DisplayInfo(){
        System.out.println("ФИО студента: " + fullName + "; возраст студента: " + getAge());
    }
    public int getAge() {
        return Age;
    }
}
class Student extends Person {
    private Calendar DateOfEnrolment;
    public int Course;
    public String Faculty;

    Student(int Age, String fullName, String Phone, int year, int month, int day, int Course, String Faculty) {
        super(Age, fullName, Phone);
        this.DateOfEnrolment = Calendar.getInstance();
        this.DateOfEnrolment.set(year, month, day);
        this.Course = Course;
        this.Faculty = Faculty;
    }

    @Override
    public void DisplayInfo() {
        System.out.println("ФИО студента: " + fullName + " возраст студента: " + getAge());
    }
    public int getDateOfYear() {
        return DateOfEnrolment.get(Calendar.YEAR);
    }
}
