package vn.edu.likelion;

import java.util.Calendar;

public class DateAndTime {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println(cal.getTime());
        System.out.println(Calendar.YEAR);
        System.out.println(Calendar.MONTH);
        System.out.println(Calendar.DATE);

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (j==2) {
                    break;
                }
                System.out.println("j = " + j);
            }
            System.out.println("i = " + i);
        }

    }

}
