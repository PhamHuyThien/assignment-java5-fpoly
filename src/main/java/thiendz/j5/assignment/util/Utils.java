package thiendz.j5.assignment.util;

import java.util.Random;

public class Utils {

    public static Random random = new Random();

    public static double numberFormatMoney(double money) {
        return (double) Math.round(money * 10) / 10;
    }
}
