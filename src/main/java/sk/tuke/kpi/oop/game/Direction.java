package sk.tuke.kpi.oop.game;



public enum Direction {

    NORTH(0,1),
    SOUTH(0,-1),
    EAST(1,0),
    WEST(-1,0),
    NORTHEAST(1,1),
    SOUTHEAST(1,-1),
    SOUTHWEST(-1,-1),
    NORTHWEST(-1,1),


    NONE(0,0);


    private final int dx;
    private final int dy;



    Direction(int dx,int dy) {
        this.dx = dx;
        this.dy = dy;
    }

   public  float getAngle(){

        if(dx==0) return nula(dx,dy);
        if(dx==1) return jedna(dx,dy);
       if(dx==-1) return minjedna(dx,dy);

    /*  if(dx==0 && dy==0) return 0;
      if(dx==0 && dy==-1) return 180;
      if(dx==1 && dy==0) return 270;
      if(dx==-1 && dy==0) return 90;
      if(dx==1 && dy ==1)  return 315;// NORTHEAST:
       if(dx==1 && dy==-1) return 225;
       if(dx==-1 && dy==-1) return 135;
       if(dx==-1 && dy==1) return 45;
*/
        return 0;
    }

    private float nula (int dx,int dy){
        if(dx==0 && dy==0) return 0;
        if(dx==0 && dy==-1) return 180;
        return 0;
    }

    private float jedna(int dx, int dy){
        if(dx==1 && dy==0) return 270;
        if(dx==1 && dy ==1)  return 315;// NORTHEAST:
        if(dx==1 && dy==-1) return 225;
        return 0;
    }

    private float minjedna(int dx, int dy) {
        if(dx==-1 && dy==0) return 90;
        if(dx==-1 && dy==-1) return 135;
        if(dx==-1 && dy==1) return 45;
        return 0;
    }

    public static Direction fromAngle(float angle){
        if(angle==0) return NORTH;
        if(angle==180) return SOUTH;
        if(angle==90) return WEST;
        if(angle==270 ) return  EAST;
        if(angle==315 ) return  NORTHEAST;
        if(angle==225 ) return  SOUTHEAST;
        if(angle==135 ) return  SOUTHWEST;
        if(angle==45 ) return  NORTHWEST;

        return NONE;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public Direction combine(Direction other){
        int newDx = other.getDx()+ this.getDx();
        int newDy = other.getDy()+this.getDy();

        if (newDx != 0) {
            newDx = newDx / Math.abs(newDx);
        }
        if (newDy != 0) {
            newDy = newDy / Math.abs(newDy);
        }
        return funkcia(newDx,newDy);
    }


    private Direction funkcia(int dx, int dy){
        if(dx == -1)
            return this.negative(dy);
        else if(dx == 0)
            return this.zero(dy);
        else if(dx == 1)
            return this.positive(dy);
        else
            return Direction.NONE;


    }

    private Direction negative(int dy) {
        if(dy == -1)
            return Direction.SOUTHWEST;
        else if(dy == 0)
            return Direction.WEST;
        else if(dy == 1)
            return Direction.NORTHWEST;
        else
            return Direction.NONE;
    }

    private Direction zero(int dy) {
        if(dy == -1)
            return Direction.SOUTH;
        else if(dy == 1)
            return Direction.NORTH;
        else
            return Direction.NONE;
    }

    private Direction positive(int dy) {
        if(dy == -1)
            return Direction.SOUTHEAST;
        else if(dy == 0)
            return Direction.EAST;
        else if(dy == 1)
            return Direction.NORTHEAST;
        else
            return Direction.NONE;

    }


}
