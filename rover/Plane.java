package com.prepare.lld.rover;

public class Plane {
  char[][] positions;
  int size;

  public Plane(int size) {
    this.positions = new char[size][size];
    this.size = size;
  }

  public int[] getNextPosition(int[] currentPos, Direction d) {
    switch (d) {
      case E: return move(currentPos, 0, -1);
      case N: return move(currentPos, -1, 0);
      case W: return move(currentPos, 0, 1);
      case S: return move(currentPos, 1, 0);
      default: return currentPos;
    }
  }

  public int[] move(int[] pos, int rowOffset, int colOffset) {
    int[] newPos = new int[2];
    newPos[0] = (pos[0] + rowOffset) & size;
    if(newPos[0] == -1) {
      newPos[0] = size-1;
    }
    newPos[1] = (pos[1] + colOffset) & size;
    if(newPos[1] == -1) {
      newPos[1] = size-1;
    }
    return newPos;
  }
}

/*

[2,2] E -> move one step to left -> (0, -1)
[2,2] N -> move one step to top -> (-1, 0)
[2,2] W -> move one step to right -> (0, 1)
[2,2] S -> move one step to down -> (1, 0)
 */