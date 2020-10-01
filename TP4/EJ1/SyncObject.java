package TP4.EJ1;


public class SyncObject {
    
    public static void main(String[] args) throws InterruptedException {
      final DualSynch ds = new DualSynch();
      threadDual t1 = new threadDual(ds);    
      t1.start();
      t1.join();      
      ds.g();     
    }
  }
