package com.prepare.lld.rover;

import java.util.HashMap;
import java.util.Map;

public class Controller {

  private Plane plane;
  private Rover rover;

  private Map<String, IAction> actionsMap = new HashMap<>();

  public Controller(Plane plane, Rover rover) {
    this.plane = plane;
    this.rover = rover;
    actionsMap.put("turn", new TurnAction(rover));
    actionsMap.put("move", new MoveAction(plane, rover));
  }

  public IStatus execute(String command) {
    return execute(command, new DefaultParameter());
  }

  public IStatus execute(String command, IParameter parameter) {
    IAction action = getAction(command);
    return action.execute(parameter);
  }

  public IAction getAction(String action)  {
    if(!actionsMap.containsKey(action)) {
      // TODO: throw exception
      throw new RuntimeException("Unknown Action!");
    }
    return actionsMap.get(action);
  }

  public static void main(String[] args) {
    Plane plane = new Plane(10);
    Rover rover = new Rover(new int[] {0,0}, Direction.E);
    Controller controller = new Controller(plane, rover);

    IStatus status = controller.execute("turn", new TurnParameter(TurnDirection.L));
    if(status.getExitStatus() == 0) {
      System.out.println("success");
    }

    controller.execute("move", new MoveParameter());
  }

/*

turn right
move 1
getPos
getDir
 */

}
