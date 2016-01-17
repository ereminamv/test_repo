package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover {

    private  SimpleRoverStatsModule simpleRoverStatsModule;
    private Point currentPosition;
    private AtomicIntegerFieldUpdater<String> settings;
    private RoverProgram roverProgram;

    public ProgrammableRover(GroundVisor groundVisor, SimpleRoverStatsModule simpleRoverStatsModule) {
        super(groundVisor);
        this.simpleRoverStatsModule = simpleRoverStatsModule;
    }

    public ProgrammableRover(GroundVisor groundVisor) {
        super(groundVisor);
    }

    public void executeProgramFile(String file) {
        RoverCommandParser roverCommandParser = new RoverCommandParser(this, file);
        roverProgram = roverCommandParser.getProgram();

        for(RoverCommand command : roverProgram.getCommands()) {
            command.execute();

    }}
    public void move() {
        super.move();
        if ((boolean) this.getSettings().get(RoverProgram.STATS)) {
            simpleRoverStatsModule.registerPosition(getCurrentPosition());
        }
    }
    public void turnTo(Direction direction) {
        super.turnTo(direction);
    }

    public void lift() {
        super.lift();
    }
    public void land(Point position, Direction direction) {
        super.land(position, direction);
    }

    public Point getCurrentPosition() {
        return super.getCurrentPosition();
    }
    public Direction getDirection() {
        return super.getDirection();
    }
    public Map <String,Object> getSettings() {
        return null;
    }
}
