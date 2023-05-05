package com.tukorea.my_crossy_road.framework.view.my_crossy_road.game;

import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.view.Metrics;

public class MainScene extends BaseScene {
    public enum Layer {
        bg, COUNT
    }
    private Sprite backgroundSprite;
    public MainScene(){
        Metrics.setGameSize(9.0f, 16.0f);
        initLayers(Layer.COUNT);
        backgroundSprite = new Sprite(R.mipmap.background, 4.5f, 8.0f, 9.0f, 16.0f);
        add(Layer.bg, backgroundSprite);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
