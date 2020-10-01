package TP4.EJ1;

import java.io.PrintStream;

public class LineMismatchException
  extends SimpleTestException {
  public LineMismatchException(String className, 
   int lineNum, String expected, String output) {
    super(className, "line " + lineNum 
      + " of output did not match " + "expected output"
      + " expected: <" + expected + ">" + " output: <" 
      + output + ">");
  }
} ///:~
