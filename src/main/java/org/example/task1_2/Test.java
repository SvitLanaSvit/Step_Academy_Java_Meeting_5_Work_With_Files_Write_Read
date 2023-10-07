package org.example.task1_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Завдання 1:
        //Користувач з клавіатури вводить шлях до файлу. Після чого вміст файлу відображається на екрані.

        //Завдання 2:
        //До першого завдання додайте поекранний вивід, якщо вміст файлу не поміщається на екран.
        Scanner scanner = new Scanner(System.in);

        int linesPerPage = 10;

        System.out.print("Enter the file path: ");
        String filePath = scanner.next();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int lineNumber = 0;
            int page = 1;

            System.out.println("File Contents:");
            while ((line = bufferedReader.readLine()) != null) {
                if (lineNumber % linesPerPage == 0) {
                    System.out.println("Page " + page);
                    page++;
                }
                System.out.println(line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
