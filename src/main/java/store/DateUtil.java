package store;

import camp.nextstep.edu.missionutils.DateTimes;

public class DateUtil {
    public static String getCurrentDate() {
        String fullDateTime = DateTimes.now().toString();
        return extractDate(fullDateTime);
    }

    private static String extractDate(String fullDateTime) {
        return fullDateTime.substring(0, 10);
    }
}
