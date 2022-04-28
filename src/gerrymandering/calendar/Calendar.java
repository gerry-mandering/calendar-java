package gerrymandering.calendar;

import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalendarPrinter calendarPrinter = new CalendarPrinter();
        int month, year = 0;

        while (true) {
            System.out.println("종료하려면 -1을 입력하시오.");
            System.out.print("년도를 입력하시오 : ");
            year = sc.nextInt();
            if (detectMinusOne(year)) break;

            System.out.print("달을 입력하시오 : ");
            month = sc.nextInt();
            if (detectMinusOne(month)) break;

            calendarPrinter.printCalendar(year, month);
        }
        sc.close();
    }

    private static boolean detectMinusOne(int year) {
        if (year == -1) {
            System.out.println("프로그램을 종료합니다.");
            return true;
        }
        return false;
    }
}
