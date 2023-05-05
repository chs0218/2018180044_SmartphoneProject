//package com.tukorea.my_crossy_road.framework.view.my_crossy_road.game;
package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.view.Metrics;

public class MainScene extends BaseScene {
    public enum Layer {
        bg, environment, obstacle, player, COUNT
    }

    private final Player player;

    public MainScene(){
        Metrics.setGameSize(10.0f, 16.0f);
        initLayers(Layer.COUNT);

        add(Layer.bg, new Sprite(R.mipmap.background, 5.0f, 8.0f, 10.0f, 16.0f));

        add(Layer.environment, new Sprite(R.mipmap.grass, 1.0f, 15.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 3.0f, 15.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 5.0f, 15.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 7.0f, 15.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 9.0f, 15.0f, 2.0f, 2.0f));

        add(Layer.obstacle, new Sprite(R.mipmap.rock, 1.0f, 15.0f, 1.0f, 1.0f));
        add(Layer.obstacle, new Sprite(R.mipmap.rock, 7.0f, 15.0f, 1.0f, 1.0f));

        add(Layer.environment, new Sprite(R.mipmap.road, 1.0f, 13.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 3.0f, 13.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 5.0f, 13.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 7.0f, 13.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 9.0f, 13.0f, 2.0f, 2.0f));

        add(Layer.environment, new Sprite(R.mipmap.road, 1.0f, 11.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 3.0f, 11.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 5.0f, 11.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 7.0f, 11.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 9.0f, 11.0f, 2.0f, 2.0f));

        add(Layer.environment, new Sprite(R.mipmap.road, 1.0f, 9.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 3.0f, 9.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 5.0f, 9.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 7.0f, 9.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 9.0f, 9.0f, 2.0f, 2.0f));

        add(Layer.environment, new Sprite(R.mipmap.grass, 1.0f, 7.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 3.0f, 7.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 5.0f, 7.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 7.0f, 7.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 9.0f, 7.0f, 2.0f, 2.0f));

        add(Layer.environment, new Sprite(R.mipmap.road, 1.0f, 5.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 3.0f, 5.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 5.0f, 5.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 7.0f, 5.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.road, 9.0f, 5.0f, 2.0f, 2.0f));

        add(Layer.environment, new Sprite(R.mipmap.grass, 1.0f, 3.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 3.0f, 3.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 5.0f, 3.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 7.0f, 3.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 9.0f, 3.0f, 2.0f, 2.0f));

        add(Layer.environment, new Sprite(R.mipmap.grass, 1.0f, 1.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 3.0f, 1.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 5.0f, 1.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 7.0f, 1.0f, 2.0f, 2.0f));
        add(Layer.environment, new Sprite(R.mipmap.grass, 9.0f, 1.0f, 2.0f, 2.0f));
        player = new Player();
        add(Layer.player, player);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return player.onTouchEvent(event);
    }
}
