package format_date;

/*
Manipulating the input date string in format yyyy-mm-dd
 */
public class Main {
    public static void main(String[] args) {
        String date1 = "2021-12-05";
        String date2 = "2021-12-10";
        DateManipulator dm = new DateManipulator();
        System.out.printf("Short form of %s is %s%n",date1 , dm.shortDate(date1));
        System.out.printf("The flipped form of %s is %s%n", date2, dm.flipDayMonth(date2));
        System.out.printf("The difference between %s and %s is %d days", date1, date2, dm.calcDiff(date1, date2));
    }
}
