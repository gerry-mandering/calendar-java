package gerrymandering.calender;

import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaysPrinter daysPrinter = new DaysPrinter();

        System.out.print("달을 입력하시오 : ");
        int month = sc.nextInt();

        System.out.println(month + "월은 " + daysPrinter.printDays(month) + "일까지 있습니다.");

/*        Scanner sc = new Scanner(System.in);
        Adder adder = new Adder();

        System.out.print("두 수를 입력하시오 : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("두 수의 합은 " + adder.sum(a, b) + "입니다.");
        sc.close();*/

/*        System.out.println("일  월  화  수  목  금  토\n" +
                "--------------------\n" +
                " 1  2  3  4  5  6  7\n" +
                " 8  9 10 11 12 13 14\n" +
                "15 16 17 18 19 20 21\n" +
                "22 23 24 25 26 27 28");*/
    }
}
