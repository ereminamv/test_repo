package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class MoveCommand implements RoverCommand {

   private Rover rover;

    public MoveCommand(Rover rover) {
    this.rover = rover;
    }

    public MoveCommand(ProgrammableRover rover) {


    }

    @Override
    public void execute() {
        rover.move();

    }
    @Override
    public String toString()
    {
        return "Rover moved";

    }
}
