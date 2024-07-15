package Bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Write implements Runnable{
    private BufferedReader readFileA;
    private String fileBName;
    private ArrayList<String> arr;

    public Write(BufferedReader readFileA, String fileBName, ArrayList<String> arr) {
        this.readFileA = readFileA;
        this.fileBName = fileBName;
        this.arr = arr;
    }

    @Override
    public void run() {
        FileWriter fileB;
        Random rand = new Random();
        try
        {
            fileB = new FileWriter(fileBName);
            Scanner scanner = new Scanner(System.in);

            // Initializing BufferedWriter
            BufferedWriter writeFileB = new BufferedWriter(fileB);
            System.out.println("Buffered Writer start writing...");

            int count = 0;
            for (String line : arr) {
                if (count == rand.nextInt(0, arr.size() - 1)) {
                    int breakPoint = scanner.nextInt();
                    System.out.println("Breakpoint " + breakPoint);
                }
                writeFileB.write(line + "\n");
                count++;
            }

            writeFileB.close();
            System.out.println("Written successfully");
        }
        catch (IOException except)
        {
            except.printStackTrace();
        }
    }

    public BufferedReader getReadFileA() {
        return readFileA;
    }

    public void setReadFileA(BufferedReader readFileA) {
        this.readFileA = readFileA;
    }

    public String getFileBName() {
        return fileBName;
    }

    public void setFileBName(String fileBName) {
        this.fileBName = fileBName;
    }

    public ArrayList<String> getArr() {
        return arr;
    }

    public void setArr(ArrayList<String> arr) {
        this.arr = arr;
    }
}
