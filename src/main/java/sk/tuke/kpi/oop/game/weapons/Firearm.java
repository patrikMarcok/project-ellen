package sk.tuke.kpi.oop.game.weapons;



public abstract class  Firearm {
    private int maxammo,currammo;
    public Firearm(int maxammo,int currammo){
        this.currammo=currammo;
        this.maxammo=maxammo;
    }

    public Firearm(int currammo){
        this.currammo=currammo;
        this.maxammo=currammo;
    }

    public int getAmmo() {
        return currammo;
    }

    public void reload(int newAmmo){
        this.currammo=currammo+newAmmo;
        if(this.currammo>this.maxammo){
            this.currammo=this.maxammo;
        }
    }

    protected abstract Fireable createBullet();

    public Fireable fire(){
        if(getAmmo()>0){
            currammo--;
            return createBullet();

        }else return null;
    }



}
