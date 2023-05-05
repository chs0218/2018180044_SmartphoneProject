package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.objects.Sprite;

public class LobbyScene extends BaseScene {
    private Sprite lobbySprite;
    public LobbyScene(){
        lobbySprite = new Sprite(R.mipmap.lobby, 4.5f, 8.0f, 9.0f, 16.0f);
        add(lobbySprite);
    }
    public boolean onTouchEvent(MotionEvent event) {
        new BaseScene().popScene();
        return super.onTouchEvent(event);
    }
}
