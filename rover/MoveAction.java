package com.prepare.lld.rover;

public class MoveAction implements IAction {

  private Plane plane;
  private Rover rover;

  public MoveAction(Plane plane, Rover rover) {
    this.plane = plane;
    this.rover = rover;
  }

  @Override
  public IStatus execute(IParameter parameter) {
    //  get next position from rover
    rover.currPos = plane.getNextPosition(rover.currPos, rover.direction);
    return new DefaultStatus();
  }
}
