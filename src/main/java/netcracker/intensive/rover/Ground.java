package netcracker.intensive.rover;

public class Ground {

    private int width;
    private int length;
    private GroundCell[][] Array;
    public Ground(int width, int length) {
        this.width=width;
        this.length=length;
        Array = new GroundCell[width][length];

    }

    public GroundCell getCell(int x, int y) throws OutOfGroundException {
        if (!isReachableCell(x, y)) {
            throw new OutOfGroundException();
        }
        else
            return Array[x][y];
    }
    public void initialize(GroundCell... cells) throws IllegalArgumentException {
       int size= width*length;
        int y=0;
        int x=-1;
            if((cells.length)<size)
        { throw new  IllegalArgumentException();}
            else{
        for(int i=0 ; i< size; i++){
            if(i%length==0)
             x++;
           y= i%length;
            Array[y][x]=cells[i];
        }}

    }
    protected boolean isReachableCell(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < length)
            return true;
        else
            return false;

    }
}
