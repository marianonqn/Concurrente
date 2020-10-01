package TP4.EJ1;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Test {
  // Bit-shifted so they can be added together:
  public static final int 
    DELAY_SHORT = 1,
    DELAY_MEDIUM = 1 << 1,
    DELAY_LONG = 1 << 2,
    DELAY_VERY_LONG = 1 << 3,
    EXACT = 1 << 4, // Lines must match exactly
    AT_LEAST = 1 << 5, // Must be at least these lines
    IGNORE_ORDER = 1 << 6, // Ignore line order
    // To detect if any delay bits are set:
    DELAY_MASK = DELAY_SHORT + DELAY_MEDIUM
      + DELAY_LONG + DELAY_VERY_LONG,
    DELAY_BASE = 1000; // Sleep multiplier
  // Discover the name of the class this
  // object was created within:
  String className = 
    new Throwable().getStackTrace()[1].getClassName();
  private TestStream testStream= new TestStream(className);
  public static List fileToList(String fname) {
    boolean isOutput = fname.endsWith(".txt")? true :false;
    ArrayList list = new ArrayList();
    try {
      BufferedReader in = 
        new BufferedReader(new FileReader(fname));
      try {
        String line;
        while ((line = in.readLine()) != null) {
          if (isOutput) list.add(line);
          else list.add(new TestExpression(line));
        }
      } finally {
        in.close();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return list;
  }
  public static List arrayToList(Object[] array) {
    List l = new ArrayList();
    for (int i = 0; i < array.length; i++) {
      if (array[i] instanceof TestExpression) {
        TestExpression re = (TestExpression) array[i];
        for (int j = 0; j < re.getNumber(); j++) l.add(re);
      } else
        l.add(new TestExpression(array[i].toString()));
    }
    return l;
  }
  public void expect(Object[] exp, int flags) {
    // If any delay bits are set, sleep:
    if ((flags & DELAY_MASK) != 0)
      try {
        Thread.currentThread().sleep(
          (flags & DELAY_MASK) * DELAY_BASE);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    synchronized (this) {
      List output = fileToList(className + "Output.txt");
      if ((flags & IGNORE_ORDER) == IGNORE_ORDER)
        OutputVerifier.verifyIgnoreOrder(className,
          output, exp);
      else if ((flags & AT_LEAST) == AT_LEAST)
        OutputVerifier.verifyAtLeast(className,
          output, arrayToList(exp));
      else
        OutputVerifier.verify(className, output, 
          arrayToList(exp), testStream.getConsole());
    }
    //Clean up the output file - see Detergent.java
    testStream.openOutputFile();
  }
  public void expect(Object[] expected) {
    expect(expected, EXACT);
  }
  public void 
  expect(Object[] expectFirst, String fname, int flags) {
    List expected = fileToList(fname);
    for (int i = 0; i < expectFirst.length; i++)
      expected.add(i, expectFirst[i]);
    expect(expected.toArray(), flags);
  }
  public void expect(Object[] expectFirst, String fname) {
    expect(expectFirst, fname, EXACT);
  }
  public void expect(String fname) {
    expect(new Object[] {}, fname, EXACT);
  }
  public void expect(String fname, int flags) {
    expect(new Object[] {}, fname, flags);
  }
}
