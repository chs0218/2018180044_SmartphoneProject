package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;
import android.util.Log;

import com.tukorea.my_crossy_road.framework.interfaces.IGameObject;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.util.CollisionHelper;

import java.util.ArrayList;

public class CollisionChecker implements IGameObject {
    private static final String TAG = Environment.class.getSimpleName();

    private Player player;

    public CollisionChecker(Player player) { this.player = player; }
    @Override
    public void update() {
        MainScene scene = (MainScene) BaseScene.getTopScene();
        ArrayList<IGameObject> obstacles = scene.getObjectsAt(MainScene.Layer.obstacle);

        for(int i = obstacles.size() - 1; i >= 0; i--){
            Obstacle obstacle = (Obstacle) obstacles.get(i);
            if(CollisionHelper.collides(player, obstacle)){
                player.setbDead(true);
                break;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
    }
}
