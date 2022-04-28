package gerrymandering.calendar;

import static java.lang.Math.*;

public class CalendarPrinter {
    static int getDay(int year, int month) {
        int h = 0, q = 1;               // h는 요일(0~6 == 토~일), q는 날짜
        double m, K, J;                 // m은 월, K는 연도 마지막 두자리, J는 세기

        if (month <= 2) {               // 1, 2월은 월에 12를 더하고 년도에 1을 빼서 계산
            m = month + 12;
            K = (int)(year - 1) % 100;
            J = (int)(year - 1) / 100;
        } else {
            m = month;
            K = (int)year % 100;        // 연도 마지막 두자리
            J = (int)year / 100;        // 세기
        }

        // Zeller's congruence
        h = (q +
                (int)floor((13 * (m + 1)) / 5) +
                (int)K +
                (int)floor(K / 4) +
                (int)floor(J / 4) -
                (int)(2 * J)
            ) % 7;

        if (h < 0) {                    // 나머지 값 결과가 음수일 경우 값을 보정
            h += 7;
        }

//        System.out.println("h = " + h);
        return h;
    }

    static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 400 != 0 && year % 100 == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    static int getEndDate(int year, int month) {
        if (isLeapYear(year) && month == 2) {
            return  29;
        } else {
            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    return 31;
                case 4: case 6: case 9: case 11:
                    return  30;
                case 2:
                    return  28;
                default:
                    System.out.println("달을 제대로 입력하시오!");
                    System.exit(0);
                    return 0;
            }
        }
    }

    void printCalendar(int year, int month) {
        int dayOfTheWeek = getDay(year, month);
        int date = 1, skipper = 0, endDay = getEndDate(year, month);

        if (dayOfTheWeek == 0) {
            skipper = 6;
        } else {
            skipper = dayOfTheWeek - 1;
        }

        System.out.printf("일\t월\t화\t수\t목\t금\t토\n" +
                "--------------------------\n");

        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++) {
                if (skipper > 0) {
                    System.out.printf("\t");
                    skipper -= 1;
                } else if (date > endDay) {
                    System.out.printf("\t");
                } else {
                    System.out.printf("%d\t", date);
                    date++;
                }
            }
            System.out.println();
        }
    }
}
