package sk.tuke.kpi.oop.game.openables;

public class LockedDoor extends Door{

    private boolean state;
    public LockedDoor(String name, Orientation orientation){
        super(name,orientation);
        this.state=state;



    }

    public  void lock() {
        state=true;
        super.close();
    }
    public void unlock(){
        state=false;
        super.open();
    }
    public boolean isLocked(){return state;}

}
