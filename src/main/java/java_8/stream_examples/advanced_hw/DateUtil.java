package java_8.stream_examples.advanced_hw;

import javassist.bytecode.LocalVariableAttribute;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DateUtil {
    public static void printBlackFridaySorted(int startYear, int endYear) {
        //IntStream.range(startYear, endYear)
        LocalDate startDate = LocalDate.of(startYear, 1, 1);
        LocalDate endDate = LocalDate.of(endYear, 12, 31);

        Map<Integer, Long> blackFridays = startDate.datesUntil(endDate)
                .filter(localDate -> localDate.getDayOfMonth() == 13 && localDate.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.groupingBy(LocalDate::getYear, Collectors.counting()));

        blackFridays.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

}
