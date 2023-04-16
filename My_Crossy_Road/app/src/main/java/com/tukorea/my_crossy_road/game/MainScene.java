package com.tukorea.my_crossy_road.game;

import android.view.MotionEvent;

import com.tukorea.my_crossy_road.framework.BaseScene;

public class MainScene extends BaseScene {
    public MainScene(){
        SceneName = new String("MainScene");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        new BaseScene().pushScene(new LobbyScene());
        return super.onTouchEvent(event);
    }
}
