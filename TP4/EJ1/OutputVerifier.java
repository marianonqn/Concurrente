package TP4.EJ1;

import java.util.*;
import java.io.PrintStream;

public class OutputVerifier {
  public static void verifyIgnoreOrder(String className,
    List output, Object[] expected) {
    verifyLength(className, expected.length, output.size(),
      Test.EXACT);
    if (!(expected instanceof String[]))
      throw new RuntimeException("IGNORE_ORDER mode "
          + "only works with String objects");
    String[] out = new String[output.size()];
    Iterator it = output.iterator();
    for (int i = 0; i < out.length; i++)
      out[i] = it.next().toString();
    Arrays.sort(out);
    Arrays.sort(expected);
    int i =0;
    if (!Arrays.equals(expected, out)) {
      while (expected[i].equals(out[i])) {i++;}
      throw new SimpleTestException(className,
        "output: <" + out[i]);
    }
  }
  public static void verify(String className,
    List output, List expected, PrintStream console) {
    verifyLength(className, output.size(), expected.size(),
      Test.EXACT);
    if (!expected.equals(output)) {
      //find the line of mismatch
      ListIterator it1 = expected.listIterator();
      ListIterator it2 = output.listIterator();
      while (it1.hasNext()
        && it2.hasNext()
        && it1.next().equals(it2.next()));
      throw new LineMismatchException(className,
        it1.nextIndex(), it1.previous().toString(),
        it2.previous().toString());
    }
  }
  private static void verifyLength(String className,
    int output, int expected, int compare) {
    if ((compare == Test.EXACT && expected != output)
      || (compare == Test.AT_LEAST && output < expected))
      throw new NumOfLinesException(className,
        expected, output);
  }
  public static void verifyAtLeast(String className,
    List output, List expected) {
    verifyLength(className, output.size(), expected.size(),
      Test.AT_LEAST);
    if (!output.containsAll(expected)) {
      ListIterator it = expected.listIterator();
      while (output.contains(it.next())) {}
      throw new SimpleTestException(className,
        "expected: <" + it.previous().toString() + ">");
    }
  }
} ///:~
