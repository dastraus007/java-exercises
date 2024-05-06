import java.util.ArrayList;
import java.util.Arrays;

public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();
    public static void sortSeasonable(Comparable[] seasonables) {
        Arrays.sort(seasonables);
    }

public static String reportAll(Seasonable[] seasonables) {
    String report = new String();

    for (Seasonable seasonable : seasonables) {
        if (seasonable != null) {
            report+= seasonable.toString() + '\n';
        }
    }
    return report.toString();
}

    }
