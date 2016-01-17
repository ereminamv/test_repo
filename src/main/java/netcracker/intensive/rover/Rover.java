package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;

public class Rover implements Turnable, Liftable, Moveable, Landable {
    private Point  current_position;
    private Direction current_direction;
    private boolean airborne;
    private GroundVisor visor;

    public Rover(GroundVisor groundVisor) {
        current_position = new Point(0,0);
        current_direction= Direction.SOUTH;
        airborne=false;
        this.visor=groundVisor;
    }
    public void turnTo(Direction newDirection) {
        current_direction = newDirection;
    }

    public void move() {
       Point  tempPosition =  new Point(current_position);
        if(current_direction != null||current_position!=null)
        {
            switch (current_direction) {
                case EAST: {
                    tempPosition.x++;
                    break;
                }
                case WEST: {
                    tempPosition.x--;
                    break;
                }
                case NORTH: {
                    tempPosition.y--;
                    break;
                }
                case SOUTH: {
                    tempPosition.y++;
                    break;
                }
            }
            if(tempPosition.x<0 ||tempPosition.y<0)
            { new OutOfGroundException();}

    }
        }


    public void lift() {
        if( isAirborne()==false)
        { airborne=true;
            current_direction=null;
            current_position=null;
        }
    }

    public void land(Point position, Direction direction) {
    }

    public Direction getDirection() {
        return null;
    }

    public boolean isAirborne() {
        return airborne;
    }

    public Point getCurrentPosition() {
        return null;
    }


}