import Factory.AbstractFactory;
import Factory.BallPenFactory;
import Factory.BlackPenFactory;
import Factory.Pen;
import merge.MergeSortExample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate localDate = LocalDate.from(f.parse("January 13, 2012"));
    }
}
