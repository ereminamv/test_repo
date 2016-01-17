package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class LiftCommand implements RoverCommand {
private Rover rover;
    public LiftCommand(ProgrammableRover rover) {

    }

    public LiftCommand(Rover rover) {
this.rover=rover;
    }

    @Override
    public void execute() {
        rover.lift();

    }
    @Override
    public String toString(){
        return "Rover lifted";
    }
}
