package com.nalyvaiko.fibonacci;

public class Fibonacci {

  public int makeFibonacciSequence(int fibonacciSequence) {
    if (fibonacciSequence <= 2) {
      return 1;
    } else {
      return makeFibonacciSequence(fibonacciSequence - 2)
          + makeFibonacciSequence(fibonacciSequence - 1);
    }
  }
}
