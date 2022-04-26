package gerrymandering.calender;

public class CalenderPrinter {
    private final String day31 = ("일  월  화  수  목  금  토\n" +
            "--------------------\n" +
            " 1  2  3  4  5  6  7\n" +
            " 8  9 10 11 12 13 14\n" +
            "15 16 17 18 19 20 21\n" +
            "22 23 24 25 26 27 28\n" +
            "29 30 31");

    private final String day30 = ("일 월 화 수 목 금 토\n" +
            "--------------------\n" +
            " 1  2  3  4  5  6  7\n" +
            " 8  9 10 11 12 13 14\n" +
            "15 16 17 18 19 20 21\n" +
            "22 23 24 25 26 27 28\n" +
            "29 30");

    private final String day28 = ("일 월 화 수 목 금 토\n" +
            "--------------------\n" +
            " 1  2  3  4  5  6  7\n" +
            " 8  9 10 11 12 13 14\n" +
            "15 16 17 18 19 20 21\n" +
            "22 23 24 25 26 27 28");

    private final String day29 = ("일 월 화 수 목 금 토\n" +
            "--------------------\n" +
            " 1  2  3  4  5  6  7\n" +
            " 8  9 10 11 12 13 14\n" +
            "15 16 17 18 19 20 21\n" +
            "22 23 24 25 26 27 28\n" +
            "29");

    static boolean classifyLeapYear(int year) {
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

    void printCalender(int year, int month) {
        if (classifyLeapYear(year) && month == 2) {
            System.out.println(day29);
        } else {
            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    System.out.println(day31);
                    break;
                case 4: case 6: case 9: case 11:
                    System.out.println(day30);
                    break;
                case 2:
                    System.out.println(day28);
                    break;
                default:
                    System.out.println("달을 제대로 입력하시오!");
                    System.exit(0);
            }
        }
    }
}
