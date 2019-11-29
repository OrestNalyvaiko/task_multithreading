package com.nalyvaiko.pingpong;

public class PingPong {

  private int loopEnd;

  public PingPong(int loopEnd) {
    this.loopEnd = loopEnd;
  }

  public synchronized void ping() {
    for (int i = 0; i < loopEnd; i++) {
      System.out.println("Ping");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      notify();
    }
  }

  public synchronized void pong() {
    for (int i = 0; i < loopEnd; i++) {
      System.out.println("Pong");
      notify();
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
