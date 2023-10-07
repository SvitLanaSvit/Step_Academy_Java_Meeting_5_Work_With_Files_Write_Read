package org.example.task7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //Завдання 7:
        //Користувач з клавіатури вводить шлях до файлу і список заборонених слів.
        //Програма повинна вирізати заборонені слова із файлу.Після роботи програми на екран
        //відображаємо звіт з інформацією про кількість вирізаних слів з деталізацією по кожному слову
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.next();

        System.out.print("Enter prohibited words (comma-separated): ");
        String prohibitedWordsInput = scanner.next();

        String[] prohibitedWordsArray = prohibitedWordsInput.split(",");

        List<String> prohibitedWords = new ArrayList<>();
        for(var word : prohibitedWordsArray){
            prohibitedWords.add(word.trim());
        }

        int totalWordsRemoved = 0;
        List<String> removedWordsDetails = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if(prohibitedWords.contains(words[i])){
                        words[i] = "";
                        totalWordsRemoved++;
                        removedWordsDetails.add("Line: " + line + ", Word: " + words[i]);
                    }
                }

                String updatedLine = String.join(" ", words);
                System.out.println(updatedLine);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Total words removed: " + totalWordsRemoved);
        System.out.println("Details of removed words:");
        for(var details : removedWordsDetails){
            System.out.println(details);
        }
    }
}
