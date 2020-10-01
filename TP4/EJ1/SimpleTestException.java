package TP4.EJ1;

public class SimpleTestException extends RuntimeException {
    public SimpleTestException(String cname, String msg) {
      super("Error testing output of class " + cname
        + ": " + msg);
    }
  } ///:~
