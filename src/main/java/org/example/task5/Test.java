package org.example.task5;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Завдання 5:
        //Користувач з клавіатури вводить шлях до файлу, слово пошуку і слово для заміни.
        //Програма шукає слово для пошуку і проводить заміну на друге слово.
        //Після роботи програми на екран відображається звіт з інформацією про кількість замін.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.next();
        System.out.print("Enter a word to search in the file: ");
        String wordToSearch = scanner.next();
        System.out.print("Enter a word to replace in the file: ");
        String wordToReplace = scanner.next();

        int replacements = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))){
            String line;

            while((line = reader.readLine()) != null){
                line = line.replaceAll(wordToSearch, wordToReplace);
                writer.write(line + System.getProperty("line.separator"));
                if(line.contains(wordToReplace)){
                    replacements++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        System.out.println("Number of replacements: " + replacements);
    }
}
