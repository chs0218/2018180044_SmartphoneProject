package com.tukorea.my_crossy_road.game;

import android.view.MotionEvent;

import com.tukorea.my_crossy_road.framework.BaseScene;

public class LobbyScene extends BaseScene {
    public LobbyScene(){
        SceneName = new String("LobbyScene");
    }
    public boolean onTouchEvent(MotionEvent event) {
        new BaseScene().popScene();
        return super.onTouchEvent(event);
    }
}
