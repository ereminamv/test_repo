package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";

    public Collection<RoverCommand> getCommands() {
        return null;
    }

    public Map <String, Object> getSettings() {
        return null;
    }
}
