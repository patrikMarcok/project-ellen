package sk.tuke.kpi.oop.game.actions;


import org.jetbrains.annotations.Nullable;

import sk.tuke.kpi.gamelib.actions.Action;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;



public class Move<T extends Movable> extends AbstractActor implements Action<Movable> /*KeyboardListener*/ {
    private Movable movable;
    private Actor actor;
    private Direction direction;
    private boolean done;
    private Scene scene;
    private float time, timePassed;
    private float duration;
    private int x,y,speed, x1,y1,dx,dy;
   // private int step;
   // private boolean check = false;
    public Move(Direction direction, float duration) {
        this.direction=direction;
        this.duration=duration;
//
        // implementacia konstruktora akcie
    }


    public Move(Direction direction) {
        this.direction=direction;
        if(actor==null){
            System.out.println("actor null");
        }
        // implementacia konstruktora akcie
    }



    ///////////////////////////////////////////Action////////////////////////////////////////////
    @Nullable
    @Override
    public Movable getActor() {
        return movable;
    }

    @Override
    public void setActor(@Nullable Movable actor) {
        this.movable=actor;
    }



    @Override
    public boolean isDone() {
        return this.done;
    }

    @Override

    public void execute(float deltaTime) {

//        int x,y,speed, x1,y1,dx,dy;
        Animation ripley_anim=new Animation("sprites/player.png", 32, 32, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(ripley_anim);

        time += deltaTime;
//        Scene scene;
        scene=getScene();
        dx=direction.getDx();
        dy=direction.getDy();

        time(deltaTime);






        if(Math.abs(duration-time)>time-1e-5 /*&& !isdone*/){
            //isdone=true;
            this.movable.startedMoving(direction);
            //Scene scene = getScene();
            scene=getScene();
            x1=this.movable.getPosX();
            y1=this.movable.getPosY();

            if(direction!=Direction.EAST || direction != Direction.WEST) {
                dir(direction);
            }
            

            if(direction==Direction.EAST ) {
                x=this.movable.getPosX();
                y=this.movable.getPosY();
                speed=movable.getSpeed();
                this.movable.setPosition(x+speed,y);
             //   ripley_anim.setRotation(90);
                scene=getScene();
            //    System.out.println("east");check=true;
            }

            if(direction==Direction.WEST) {
                x=this.movable.getPosX();
                y=this.movable.getPosY();
                speed=movable.getSpeed();
                this.movable.setPosition(x-speed,y);
               /// ripley_anim.setRotation(180);
             //   System.out.println("west");check=true;
            }
            scene= movable.getScene();
            scene1();
            /*if(scene!=null){
                scene= movable.getScene();
                if(scene.getMap().intersectsWithWall(movable)){

                    this.movable.setPosition(x1,y1);
                }

            }*/



        }else
            this.movable.stoppedMoving();

         //   isdone=true;

    }

    private void time(float deltaTime){
        this.timePassed += deltaTime;
        if ((this.timePassed - this.duration) >= 1e-5) {
            this.done = true;
        }
    }


    private void scene1(){
        if(scene!=null){
            scene= movable.getScene();
            if(scene.getMap().intersectsWithWall(movable)){

                this.movable.setPosition(x1,y1);
            }

        }
    }

    private void dir(Direction direction){
        if(direction==Direction.NORTH || direction==Direction.NORTHEAST || direction==Direction.NORTHWEST) {
            north();
        }

        if(direction==Direction.SOUTH || direction==Direction.SOUTHWEST || direction==Direction.SOUTHEAST) {
            south();
        }
    }
    private void north(){
        if(direction==Direction.NORTH) {
            x=this.movable.getPosX();
            y=this.movable.getPosY();
            speed=movable.getSpeed();
            this.movable.setPosition(x,y+speed);
            //   ripley_anim.setRotation(0)

            // System.out.println("north");
        }

        if(dx==1 && dy==1) {
            x=this.movable.getPosX();
            y=this.movable.getPosY();
            speed=movable.getSpeed();
            this.movable.setPosition(x+speed,y+speed);
            //   ripley_anim.setRotation(0)

            System.out.println("northe");
        }
        if(direction==Direction.NORTHWEST) {
            x=this.movable.getPosX();
            y=this.movable.getPosY();
            speed=movable.getSpeed();
            this.movable.setPosition(x-speed,y+speed);
            //   ripley_anim.setRotation(0)

            //   System.out.println("northw");
        }
    }

    private void south(){
        if(direction==Direction.SOUTH) {
            x=this.movable.getPosX();
            y=this.movable.getPosY();
            speed=movable.getSpeed();
            this.movable.setPosition(x,y-speed);
            //   ripley_anim.setRotation(-90);
            //System.out.println("south");

        }
        if(direction==Direction.SOUTHEAST) {
            x=this.movable.getPosX();
            y=this.movable.getPosY();
            speed=movable.getSpeed();
            this.movable.setPosition(x+speed,y-speed);
            //   ripley_anim.setRotation(-90);
            //System.out.println("south");

        }

        if(direction==Direction.SOUTHWEST) {
            x=this.movable.getPosX();
            y=this.movable.getPosY();
            speed=movable.getSpeed();
            this.movable.setPosition(x-speed,y-speed);
            //   ripley_anim.setRotation(-90);
            //System.out.println("south");

        }
    }

    @Override
    public void reset() {
        done=false;
    }

    public void stop(){
        if(movable!=null) {
            movable.stoppedMoving();
        }
        done=true;
        //check=true;
    }


}
