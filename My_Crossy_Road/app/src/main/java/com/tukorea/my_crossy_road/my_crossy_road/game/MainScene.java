package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.objects.Sprite;

public class MainScene extends BaseScene {
    private Sprite backgroundSprite;
    public MainScene(){
        backgroundSprite = new Sprite(R.mipmap.background, 4.5f, 8.0f, 9.0f, 16.0f);
        add(backgroundSprite);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        new BaseScene().pushScene(new LobbyScene());
        return super.onTouchEvent(event);
    }
}
