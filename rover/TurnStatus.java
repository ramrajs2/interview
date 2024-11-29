package com.prepare.lld.rover;

public class TurnStatus implements IStatus{

  boolean turnSuccess;

  public TurnStatus(boolean turnSuccess) {
    this.turnSuccess = turnSuccess;
  }

  @Override
  public int getExitStatus() {
    return 0;
  }
}
