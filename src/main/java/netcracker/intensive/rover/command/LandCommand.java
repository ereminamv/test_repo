package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class LandCommand implements RoverCommand {
private Rover rover;
    private Direction direction;
    private Point location;
    public LandCommand(ProgrammableRover rover, Point point, Direction west) {

    }

    public LandCommand(Rover rover, Point position, Direction direction) {
        this.rover = rover;
        this.direction = direction;
        this.location = position;
    }

    @Override
    public void execute() {
        rover.land(location,direction);

    }
    @Override
    public String toString()
    {return "Land at " +  location + " heading " + direction;}
}
