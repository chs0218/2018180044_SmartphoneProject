//package com.tukorea.my_crossy_road.framework.view.my_crossy_road.game;
package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.RectF;
import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IBoxCollidable;
import com.tukorea.my_crossy_road.framework.interfaces.IGameObject;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.view.Metrics;

import java.util.ArrayList;

public class MainScene extends BaseScene {
    public enum Layer {
        bg, environment, obstacle, player, controller, COUNT
    }

    private final Player player;
    private final MapLoader mapLoader;

    public MainScene(){
        Metrics.setGameSize(10.0f, 16.0f);
        initLayers(Layer.COUNT);

        add(Layer.bg, new Sprite(R.mipmap.background, 5.0f, 8.0f, 10.0f, 16.0f));

        mapLoader = new MapLoader();
        add(Layer.controller, mapLoader);

        player = new Player();
        add(Layer.player, player);
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

        mapLoader.PullDownMapLoader(speed);
    }

    @Override
    public void update(long elapsedNanos) {
        PullDown();
        super.update(elapsedNanos);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return player.onTouchEvent(event);
    }
}
