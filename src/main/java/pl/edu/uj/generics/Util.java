package pl.edu.uj.generics;

public class Util {

  public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
    return p1.getKey().equals(p2.getKey()) &&
        p1.getValue().equals(p2.getValue());
  }

  public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray) {
      if (e.compareTo(elem) > 0) {
        ++count;
      }
    }
    return count;
  }
}
