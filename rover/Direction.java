package com.prepare.lld.rover;

public enum Direction {
  E(0), S(1), W(2), N(3);
  public final int value;

  private Direction(int value) {
    this.value = value;
  };

  public Direction getByValue(int val) {
    // iterate and return;
    return Direction.E;
  }
}
