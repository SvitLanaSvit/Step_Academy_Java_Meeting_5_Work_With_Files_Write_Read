package org.example.task6;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Завдання 6:
        //Користувач з клавіатури вводить шлях до чотирьох файлів. Програма повинна вміст з трьох файлів
        //записати в четвертий файл. Після роботи програми на екран відображається звіт з інформацією про
        //кількість перенесених байт
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the first file: ");
        String filePath1 = scanner.next();
        System.out.print("Enter the path of the second file: ");
        String filePath2 = scanner.next();
        System.out.print("Enter the path of the third file: ");
        String filePath3 = scanner.next();

        System.out.print("Enter the path of the destination file: ");
        String destinationFilePath = scanner.next();

        int totalBytesTransferred = 0;

        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFilePath))){
            totalBytesTransferred += mergeFiles(filePath1, bufferedOutputStream);
            totalBytesTransferred += mergeFiles(filePath2, bufferedOutputStream);
            totalBytesTransferred += mergeFiles(filePath3, bufferedOutputStream);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Total bytes transferred: " + totalBytesTransferred);
    }

    private static int mergeFiles(String sourceFilePath, OutputStream outputStream){
        int bytesTransferred = 0;

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFilePath))){
            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = bufferedInputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
                bytesTransferred += bytesRead;
            }
        } catch (IOException e) {
            System.err.println("Error reading from source file: " + e.getMessage());
        }

        return bytesTransferred;
    }
}
