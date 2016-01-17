package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class TurnCommand implements RoverCommand {
private Rover rover;
    private Direction direction;
    public TurnCommand(ProgrammableRover rover, Direction east) {

    }

    public TurnCommand(Rover rover, Direction direction) {

        this.rover=rover;
        this.direction =direction;
    }

    @Override
    public void execute() {
        rover.turnTo(direction);

    }
    @Override
    public String toString()
    {
        return "Heading " +  direction;
    }

}
