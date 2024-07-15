package Bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileA = "StudentsList.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file B name: ");
        String fileBName = scanner.nextLine();

        if (!new File(fileA).exists()) {
            System.out.println("File A does not exist.");
            return;
        }

        FileReader fileReader = null;
        BufferedReader readFileA  = null;
        ArrayList<String> arr = new ArrayList<>();

        try {
            fileReader = new FileReader(fileA);
            readFileA = new BufferedReader(fileReader);

            String line = readFileA.readLine();
            System.out.println("Buffered Reader start reading...");

            while (line != null) {
                arr.add(line);
                line = readFileA.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                fileReader.close();
                readFileA.close();
                System.out.println("Read successfully");
            } catch (IOException io2) {
                io2.printStackTrace();
            }
        }

        Runnable write = new Write(readFileA, fileBName, arr);
        Thread thread1 = new Thread(write);
        Runnable remove = new Remove(fileA);
        Thread thread2 = new Thread(remove);
        thread1.start();
        thread2.start();
    }
}
