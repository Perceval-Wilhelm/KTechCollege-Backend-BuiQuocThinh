package Bai1;

import java.io.BufferedReader;
import java.io.File;

public class Remove implements Runnable{
    private String fileA;

    public Remove(String fileA) {
        this.fileA = fileA;
    }

    @Override
    public void run() {
        File myObj = new File(fileA);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
