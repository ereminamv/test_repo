package netcracker.intensive.rover;


import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import ch.qos.logback.core.util.StringCollectionUtil;

public class Point {

                    int x;
                    int y;

                    public Point(int x, int y) {
                        this.x = x;
                        this.y = y;
                    }
                    public Point(Point another) {
                        this.x = another.x;
                        this.y = another.y;
    }
                     public boolean equalsPoint(Point p) {
                    if(this.x == p.x && this.y == p.y) {
                        return true;
                         } else {
                        return false;
                          }
                             }
                     public String toString() {
                        return "("+x+", "+y+")";
                             }
                    public int hashCode()
                    {
                        return (Integer.toString(x) + "," + Integer.toString(y)).hashCode();
                    }
                }
    //не забудьте реализовать equals, hashCode, toString!

