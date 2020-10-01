package TP4.EJ1;

public class threadDual extends Thread  {

    DualSynch ds;

    public threadDual(DualSynch ds) {
    }

    public void run() {
        ds.f();
    }
    
}
