package gerrymandering.calender;

import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalenderPrinter calenderPrinter = new CalenderPrinter();
//        DaysPrinter daysPrinter = new DaysPrinter();
        int month = 0;

        while (true) {
            System.out.print("달을 입력하시오 (종료는 -1) : ");
            month = sc.nextInt();
            if (month == -1) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                calenderPrinter.printCalender(month);
//                System.out.println(month + "월은 " + daysPrinter.printDays(month) +"일까지 있습니다.");
            }
        }

        sc.close();

/*        Scanner sc = new Scanner(System.in);
        DaysPrinter daysPrinter = new DaysPrinter();

        System.out.print("달을 입력하시오 : ");
        int month = sc.nextInt();

        System.out.println(month + "월은 " + daysPrinter.printDays(month) + "일까지 있습니다.");
        sc.close();*/

/*        Scanner sc = new Scanner(System.in);
        Adder adder = new Adder();

        System.out.print("두 수를 입력하시오 : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("두 수의 합은 " + adder.sum(a, b) + "입니다.");
        sc.close();*/
    }
}
