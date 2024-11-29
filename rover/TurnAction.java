package com.prepare.lld.rover;

public class TurnAction implements IAction{

  Rover rover;

  public TurnAction(Rover rover) {
    this.rover = rover;
  }

  @Override
  public IStatus execute(IParameter parameter) {
    try {
      TurnDirection direction = ((TurnParameter) parameter).d;

      return new TurnStatus(this.rover.turn(direction));
    }
    catch(Exception e) {
      // TODO: handle
    }
    return  null;
  }

  // public IParameter buildParameter(IParameter parameter) {
  //   TurnParameter turnParameter = new TurnParameter(parameter.getDirection());
  // }
}
