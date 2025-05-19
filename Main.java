package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        // Регулярное выражение для корректного IPv4-адреса
        String ipRegex = "\\b((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"
                + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\b";

        Pattern pattern = Pattern.compile(ipRegex);
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        System.out.println("Найденные IP-адреса:");
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Корректных IP-адресов не найдено.");
        }
    }
}