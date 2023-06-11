//package com.tukorea.my_crossy_road.framework.view.my_crossy_road.game;
package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IBoxCollidable;
import com.tukorea.my_crossy_road.framework.interfaces.IGameObject;
import com.tukorea.my_crossy_road.framework.interfaces.ITouchable;
import com.tukorea.my_crossy_road.framework.objects.Button;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.view.Metrics;

import java.util.ArrayList;

public class MainScene extends BaseScene {
    public enum Layer {
        bg, environment, obstacle, player, ui, touch, controller, COUNT
    }

    private final Player player;
    private Score score;
    private final MapLoader mapLoader;

    public MainScene(){
        Metrics.setGameSize(10.0f, 16.0f);
        initLayers(Layer.COUNT);

        add(Layer.bg, new Sprite(R.mipmap.background, 5.0f, 8.0f, 10.0f, 16.0f));

        mapLoader = new MapLoader();
        add(Layer.controller, mapLoader);

        player = new Player();
        add(Layer.player, player);

        score = new Score(Metrics.game_width - 0.5f, 1.0f);
        add(Layer.ui, score);

        add(Layer.touch, new Button(R.mipmap.btn_pause, 9.0f, 0.0f, 1.0f, 1.0f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                if (action == Button.Action.pressed) {
                    new PausedScene().pushScene();
                }
                return true;
            }
        }));

        add(Layer.controller, new CollisionChecker(player));
    }

    public void PullDown()
    {
        float speed = (16.0f - player.GetY()) / 16.0f * 4.0f;
        player.PullDownCharacter(speed);
        PullDownEnvironments(speed);
    }

    public void PullDownEnvironments(float speed) {
        ArrayList<IGameObject> environmentArray = getObjectsAt(Layer.environment);
        for (IGameObject gobj : environmentArray) {
            if (gobj instanceof Environment) {
                ((Environment) gobj).PullDownEnvironment(speed);
            }
        }
        ArrayList<IGameObject> obstacleArray = getObjectsAt(Layer.obstacle);
        for (IGameObject gobj : obstacleArray) {
            if (gobj instanceof Obstacle) {
                ((Obstacle) gobj).PullDownObstacle(speed);
            }
        }
        mapLoader.PullDownMapLoader(speed);
    }

    @Override
    public void update(long elapsedNanos) {
        if (player.m_bDead) {
            new ResultScene(this).pushScene();
            player.m_bDead = false;
        } else {
            PullDown();
            super.update(elapsedNanos);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ArrayList<IGameObject> gameObjects = layers.get(Layer.touch.ordinal());
        for (IGameObject gobj : gameObjects) {
            if (!(gobj instanceof ITouchable)) {
                continue;
            }
            boolean processed = ((ITouchable) gobj).onTouchEvent(event);
            if (processed) return true;
        }

        return player.onTouchEvent(event);
    }

    public void addScore() {
        score.add(1);
    }
    public int getScore() {
        return score.getScore();
    }

    public void restartGame(){;
        layers.get(Layer.environment.ordinal()).clear();
        layers.get(Layer.obstacle.ordinal()).clear();
        mapLoader.reset();
        score.reset();
        player.reset();
    }
}
