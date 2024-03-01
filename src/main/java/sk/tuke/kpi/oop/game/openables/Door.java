package sk.tuke.kpi.oop.game.openables;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.map.MapTile;
import sk.tuke.kpi.gamelib.map.SceneMap;

import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

import java.util.ArrayList;
import java.util.List;

public class Door extends AbstractActor implements Openable, Usable<Actor> {

    private Animation door_anim;
    public static final Topic<Door> DOOR_OPENED = Topic.create("door opened", Door.class);
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);
    private boolean state;
    private List<MapTile> tiles=null;
    public enum Orientation{
        HORIZONTAL,
        VERTICAL
    }
    public Door(String name, Orientation orientation){
        super(name);
        this.state=false;
        if(orientation==Orientation.VERTICAL) {
            door_anim = new Animation("sprites/vdoor.png", 16, 32, 0.1f, Animation.PlayMode.ONCE);
            setAnimation(door_anim);
        }else {
            door_anim = new Animation("sprites/hdoor.png", 32, 16, 0.1f, Animation.PlayMode.ONCE_REVERSED);
            setAnimation(door_anim);
        }
        }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        SceneMap map = scene.getMap();
        int x = this.getPosX()/16;
        int y = this.getPosY()/16;
        //int tilex= map.getTile(this.getPosX(),this.getPosY()).getGridPosX();
        //int tiley= map.getTile(0,0).getGridPosY();
//        boolean tmp = map.getTile(this.getPosX(),this.getPosY()).isWall();
        //System.out.println("dvere:" +tilex);
        MapTile  type1 = map.getTile(x,y);
     //   MapTile.Type type = isOpen() ? MapTile.Type.CLEAR : MapTile.Type.WALL;
        state=false;
        for(MapTile tile :search()){
            tile.setType(MapTile.Type.WALL);
        }
        type1.setType(MapTile.Type.WALL);


    }

    @Override
    public void useWith(Actor actor) {
       // open();
        if(state) {
            close();
            state=false;
        }
        else {
            open();
            state=true;
        }
    }

    @Override
    public Class<Actor> getUsingActorClass() {

        return Actor.class;
    }

    @Override
    public void open() {
        state=true;
        door_anim.setPlayMode(Animation.PlayMode.ONCE);
      //  List<MapTile> foundTiles = new ArrayList<>();
        Scene scene= this.getScene();
        SceneMap map = scene.getMap();
        int x = this.getPosX()/16;
        int y = this.getPosY()/16;
        MapTile  type1 = map.getTile(x,y);
        for(MapTile tile :search()){
            tile.setType(MapTile.Type.CLEAR);
        }
        type1.setType(MapTile.Type.CLEAR);
        getScene().getMessageBus().publish(DOOR_OPENED,this);
    }

    @Override
    public void close() {
        state=false;
        door_anim.setPlayMode(Animation.PlayMode.ONCE_REVERSED);

        Scene scene= this.getScene();
        SceneMap map = scene.getMap();
        int x = this.getPosX()/16;
        int y = this.getPosY()/16;
        MapTile  type1 = map.getTile(x,y);
        for(MapTile tile :search()){
            tile.setType(MapTile.Type.WALL);
        }
        type1.setType(MapTile.Type.WALL);
        getScene().getMessageBus().publish(DOOR_CLOSED,this);


/*        SceneMap map = getScene().getMap();
        int tilex= map.getTile(this.getPosX(),this.getPosY()).getGridPosX();
        int tiley= map.getTile(0,0).getGridPosY();
        boolean tmp = map.getTile(this.getPosX(),this.getPosY()).isWall();
        System.out.println("dvere:" +tilex);
        //MapTile.Type  = getScene().getMap().getTile(0,0).isWall();
        MapTile.Type type = isOpen() ? MapTile.Type.CLEAR : MapTile.Type.WALL;*/



    }

    @Override
    public boolean isOpen() {
        return state;
    }


    private List<MapTile> search() {
        if (tiles != null) return tiles;
        SceneMap map = getScene().getMap();
        List<MapTile> foundTiles = new ArrayList<>();

        for (int w = 0; w < getAnimation().getWidth() / map.getTileWidth(); w++) {

            for (int h = 0; h < getAnimation().getHeight() / map.getTileHeight(); h++) {
                MapTile tile = map.getTile(
                    getPosX() / map.getTileWidth() + w,
                    getPosY() / map.getTileHeight() + h
                );

                foundTiles.add(tile);
            }

        }
        tiles = foundTiles;

        return tiles;
    }
}
