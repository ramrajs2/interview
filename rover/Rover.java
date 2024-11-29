package com.prepare.lld.rover;


public class Rover {
  int[] currPos;
  Direction direction;

  public Rover(int[] currPos, Direction direction) {
    this.currPos = currPos;
    this.direction = direction;
  }

  public boolean turn(TurnDirection direction) {
    if(direction == TurnDirection.L) {
      int directionVal = this.direction.value;
      directionVal = (directionVal+3)%4;
      this.direction = this.direction.getByValue(directionVal);
    }
    if(direction == TurnDirection.R) {
      int directionVal = this.direction.value;
      directionVal = (directionVal+1)%4;
      this.direction = this.direction.getByValue(directionVal);
    }
    return true;
  }
}

/*

 E(0), S(1), W(2), N(3);
 L -> -1 +4
 R -> +1 %4

L
 E: 0-1 = -1 + 4 = 3 (s)
 W: 2-1 = 1 + 4 = 5%4 = 1

R
 S: 1+1 = 2%4 = 2
 N: 3+1 = 4%4 = 0
 */
