package com.company;

import java.util.Scanner;

class Person {
    public String fullName;
    public String phone;
    private int age;

    public Person(String fullName, String phone, int age) {
        this.fullName = fullName;
        this.phone = phone;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class Student extends Person {
    public int course;
    public String faculty;
    private int admissionYear;

    public Student(String fullName, String phone, int age, int course, String faculty, int admissionYear) {
        super(fullName, phone, age);
        this.course = course;
        this.faculty = faculty;
        this.admissionYear = admissionYear;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];

        // Ввод данных студентов
        for (int i = 0; i < students.length; i++) {
            System.out.println("Введите данные для студента #" + (i + 1));

            System.out.print("ФИО: ");
            String fullName = scanner.nextLine();

            System.out.print("Телефон: ");
            String phone = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Курс: ");
            int course = Integer.parseInt(scanner.nextLine());

            System.out.print("Факультет: ");
            String faculty = scanner.nextLine();

            System.out.print("Год поступления: ");
            int admissionYear = Integer.parseInt(scanner.nextLine());

            students[i] = new Student(fullName, phone, age, course, faculty, admissionYear);
            System.out.println();
        }

        // а) ФИО и возраст всех студентов
        System.out.println("а) ФИО и возраст всех студентов:");
        for (Student s : students) {
            System.out.println(s.fullName + " — " + s.getAge() + " лет");
        }

        // б) Список студентов заданного факультета
        System.out.print("\nб) Введите факультет для фильтрации: ");
        String searchFaculty = scanner.nextLine();
        System.out.println("Студенты факультета \"" + searchFaculty + "\":");
        for (Student s : students) {
            if (s.faculty.equalsIgnoreCase(searchFaculty)) {
                System.out.println(s.fullName);
            }
        }

        // в) Список студентов, поступивших после заданного года
        System.out.print("\nв) Введите год для фильтрации (поступившие после): ");
        int yearFilter = Integer.parseInt(scanner.nextLine());
        System.out.println("Студенты, поступившие после " + yearFilter + ":");
        for (Student s : students) {
            if (s.getAdmissionYear() > yearFilter) {
                System.out.println(s.fullName);
            }
        }
    }
}
