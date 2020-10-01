package TP4.EJ1;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class TestStream extends PrintStream {
  private PrintStream 
    console = System.out,
    err = System.err,
    fout;
  // To store lines sent to System.out or err
  private InputStream stdin;
  private String className;
  public TestStream(String className) {
    super(System.out);
    System.setOut(this);
    System.setErr(this);
    stdin = System.in; // Save to restore in cleanup()
    this.className = className;
    // Replace the default version with one that 
    // automatically produces input on demand:
    System.setIn(new BufferedInputStream(new InputStream(){
      char[] input = ("test" + 
       System.getProperty("line.separator")).toCharArray();
      int index = 0;
      public int read() {
        return (int) input[index = (index + 1) 
          % input.length];
      }
    }));
    openOutputFile();
  }
  public PrintStream getConsole() { return console; }
  public void cleanup() {
    System.setOut(console);
    System.setErr(err);
    System.setIn(stdin);
  }
  // This will write over an old Output.txt file:
  public void openOutputFile() {
    try {
      fout = new PrintStream(new FileOutputStream(
        new File(className + "Output.txt")));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  // Override all possible print/println methods to send
  // intercepted console output to both the console and
  // the Output.txt file:
  public synchronized void print(boolean b) {
    console.print(b);
    fout.print(b);
  }
  public synchronized void print(char c) {
    console.print(c);
    fout.print(c);
  }
  public synchronized void print(int i) {
    console.print(i);
    fout.print(i);
  }
  public synchronized void print(long l) {
    console.print(l);
    fout.print(l);
  }
  public synchronized void print(float f) {
    console.print(f);
    fout.print(f);
  }
  public synchronized void print(double d) {
    console.print(d);
    fout.print(d);
  }
  public synchronized void print(char[] s) {
    console.print(s);
    fout.print(s);
  }
  public synchronized void print(String s) {
    console.print(s);
    fout.print(s);
  }
  public synchronized void print(Object obj) {
    console.print(obj);
    fout.print(obj);
  }
  public synchronized void println() {
    console.println();
    fout.println();
  }
  public synchronized void println(boolean x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(char x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(int x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(long x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(float x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(double x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(char[] x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(String x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void println(Object x) {
    console.println(x);
    fout.println(x);
  }
  public synchronized void write(
    byte[] buf,
    int off,
    int len) {
    console.write(buf, off, len);
    fout.write(buf, off, len);
  }
  public synchronized void write(int b) {
    console.write(b);
    fout.write(b);
  }
} ///:~
