package gerrymandering.calender;

import static java.lang.Math.*;

public class CalenderPrinter {
    // Zeller's congruence를 이용한 요일 찾기
    static int getDay(int year, int month) {
        int h = 0;                  // 요일(0~6 == 토~일)
        int q = 1;                  // 일
        double m = month;           // 월
        double K = (int)year % 100; // 연도 마지막 두 자리 (2015 -> 15)
        double J = (int)year / 100; // 세기

        if (m <= 2) {                   // 1월과 2월은 m에 12를 더해줌
            m += 12;
            K = (int)(year - 1) % 100;  // 연도는 1을 빼준값을 이용
            J = (int)(year - 1) / 100;
        }

        // Zeller's congruence
        h = (q +
                (int)floor((13 * (m + 1)) / 5) +
                (int)K +
                (int)floor(K / 4) +
                (int)floor(J / 4) -
                (int)(2 * J)
            ) % 7;

        if (h < 0) {    // 나머지 값 결과가 음수일 경우 값을 보정
            h += 7;
        }

        System.out.println("h = " + h);
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

    static int getEndDay(int year, int month) {
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

    void printCalender(int year, int month) {
        int dayOfTheWeek = getDay(year, month);
        int date = 1, skipper = 0, endDay = getEndDay(year, month);

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
