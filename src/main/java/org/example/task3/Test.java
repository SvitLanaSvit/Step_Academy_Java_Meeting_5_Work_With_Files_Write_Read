package org.example.task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Завдання 3:
        //Користувач з клавіатури вводить шлях до файлу і слово для пошуку. Після роботи програми на
        //екран відображається кількість разів скільки слово зустрічалося в файлі.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.next();
        System.out.print("Enter a word to search in the file: ");
        String wordToSearch = scanner.next();

        int countWord = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (var wordFromLine : words) {
                    if (wordFromLine.equals(wordToSearch)) {
                        countWord++;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        System.out.println("The word '" + wordToSearch + "' appears " + countWord + " times in the file.");
    }
}
