package pl.strangelove.objects.dayNames;

import java.util.ArrayList;
import java.util.List;

public class createDayNames {

    public static List<DayNames> generateDaysOfWeek() {
        List<DayNames> daysOfWeek = new ArrayList<>();

        // Assuming a week starts from Sunday
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < dayNames.length; i++) {
            DayNames day = new DayNames();
            day.setOrderDay(i + 1);  // Assuming order starts from 1
            day.setName(dayNames[i]);

            daysOfWeek.add(day);
        }

        return daysOfWeek;
    }
    public static void main(String[] args) {

        generateDaysOfWeek();
    }
}
