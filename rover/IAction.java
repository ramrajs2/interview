package com.prepare.lld.rover;

public interface IAction {
  public IStatus execute(IParameter parameter);
  // public IParameter buildParameter(IParameter parameter, Plane plane, Rover rover);
}
