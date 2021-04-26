import java.time.LocalDate;
import java.time.Period;

public class DateManipulator {

    // Returns the short form of the year
    public String shortDate(String str){
        return str.substring(2);
    }

    // Receives yyyy-mm-dd and returns yyyy-dd-mm
    public String flipDayMonth(String str){
        LocalDate date = LocalDate.parse(str);
        LocalDate dateFlipped = LocalDate.of(date.getYear(), date.getDayOfMonth(), date.getMonthValue());
        return dateFlipped.toString();
    }

    // Returns a different number of days
    public int calcDiff(String str1, String str2) {
        Period period = Period.between(LocalDate.parse(str1), LocalDate.parse(str2));
        return period.getDays();
    }
}
