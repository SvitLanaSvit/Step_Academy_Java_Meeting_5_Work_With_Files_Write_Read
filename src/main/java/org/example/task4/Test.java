package org.example.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Завдання 4:
        //Користувач з клавіатури вводить шлях до файлу. Після роботи програми на екран відображається
        //кількість букв, чисел і розділових знаків в файлі.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.next();

        int letterCount = 0;
        int digitCount = 0;
        int punctuationCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        letterCount++;
                    } else if (Character.isDigit(c)) {
                        digitCount++;
                    } else if (Character.isWhitespace(c)) {
                        //ignore
                    } else {
                        punctuationCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        System.out.println("Letter count: " + letterCount);
        System.out.println("Digit count: " + digitCount);
        System.out.println("Punctuation count: " + punctuationCount);
    }
}
