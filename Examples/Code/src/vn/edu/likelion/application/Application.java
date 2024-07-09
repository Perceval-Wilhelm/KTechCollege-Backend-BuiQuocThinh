package vn.edu.likelion.application;

import vn.edu.likelion.model.Father;
import vn.edu.likelion.model.Person;
import vn.edu.likelion.model.Son;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Application {

    public static void getPerson(Person person) {

        System.out.println("toi ten la: " + person.getName());
        System.out.println("toi nam nay " + person.getAge() + " tuoi");
    }

    public static void main(String[] args) throws FileNotFoundException {

        Father father = new Father("Cha");
        Son son = new Son();
        son.goiAnCom();
    }

    /**
     * @param chuoi
     * @return
     * @throws NumberFormatException
     */
    static int convertStringToInt(String chuoi) throws NumberFormatException {
        int i = 0;
        try {
            i = Integer.parseInt(chuoi);
        } catch (NumberFormatException e) {

        }
        return i;
    }

    static void readFile() throws FileNotFoundException {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("abc."));
            throw new FileNotFoundException();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
