package TP4.EJ1;

public class NumOfLinesException 
  extends SimpleTestException {
  public NumOfLinesException(String className, 
    int exp, int out) {
      super(className, "num of lines of output and " 
        + "expected output did not match expected: <" + exp
        + "> lines  output: <" + out + "> lines)");
  }
} ///:~