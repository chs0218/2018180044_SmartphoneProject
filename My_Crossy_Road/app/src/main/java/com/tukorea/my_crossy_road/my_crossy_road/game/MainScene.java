//package com.tukorea.my_crossy_road.framework.view.my_crossy_road.game;
package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.view.Metrics;

public class MainScene extends BaseScene {
    public enum Layer {
        bg, player, COUNT
    }

    private final Player player;

    public MainScene(){
        Metrics.setGameSize(10.0f, 16.0f);
        initLayers(Layer.COUNT);

        add(Layer.bg, new Sprite(R.mipmap.background, 5.0f, 8.0f, 10.0f, 16.0f));

        player = new Player();
        add(Layer.player, player);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return player.onTouchEvent(event);
    }
}
