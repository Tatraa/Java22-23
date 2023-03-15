package pl.edu.uj.generics;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {

  private static final Logger logger = LoggerFactory.getLogger(Example.class);

  public static void main(String[] args) {
    final OrderedPair<String, Integer> even = new OrderedPair<>("Even", 8);
    final OrderedPair<String, Integer> even2 = new OrderedPair<>("Even", 8);
    final OrderedPair<String, Integer> odd = new OrderedPair<>("Odd", 9);

    logger.info(MessageFormat.format("Util.compare(even, odd) = {0}", Util.compare(even, odd)));
    logger.info(MessageFormat.format("Util.compare(even, even2) = {0}", Util.compare(even, even2)));

    String[] strAr1 = new String[]{"Ani", "Sam", "Joe"};
    String[] strAr2 = {"Tom", "Dick", " Harry"};
    Integer[] strAr3 = new Integer[3]; //Initialization after declaration with specific size
    strAr3[0] = 12;
    strAr3[1] = 14;
    strAr3[2] = 14;

    logger.info(MessageFormat.format("Util.countGreaterThan(strAr1, \"Joe\") = {0}", Util.countGreaterThan(strAr1, "Joe")));
    logger.info(MessageFormat.format("Util.countGreaterThan(strAr2, \"Ani\") = {0}", Util.countGreaterThan(strAr2, "Ani")));
    logger.info(MessageFormat.format("Util.countGreaterThan(strAr3, 13) = {0}", Util.countGreaterThan(strAr3, 13)));

    List<?> stuff = new ArrayList<>();
    // Nie można dodać, ponieważ przy wyjmowaniu nieznany typ.
    // stuff.add("abc");
    // stuff.add(new Object());
    // stuff.add(3);
    logger.info(MessageFormat.format("stuff.size() = {0}", stuff.size()));

    // PECS = Producer Extends, Consumer Super
    Stack<Number> numberStack = new Stack<>();
    Iterable<Integer> integers = Arrays.asList(strAr3);
    // numberStack.pushAll(integers); // Nie kompiluje się : Integer is a subtype of Number, ale Iterable<Integer> nie Iterable<Number>
    numberStack.pushAll2(integers); // Wildcard type for parameter that serves as an E producer - Kompiluje się

    Collection<Object> objects = Arrays.asList(strAr3);
    // numberStack.popAll(objects); // Nie kompiluje się : Collection<Object> is not a subtype of Collection<Number>.
    numberStack.popAll2(objects); // // Wildcard type for parameter that serves as an E consumer - Kompiluje się

  }
}
