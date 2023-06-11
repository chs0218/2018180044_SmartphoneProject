package com.tukorea.my_crossy_road.my_crossy_road.game;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.objects.Button;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.res.Sound;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

public class PausedScene extends BaseScene {

    public enum Layer {
        bg, touch, COUNT
    }
    public PausedScene() {
        initLayers(Layer.COUNT);
        add(Layer.bg, new Sprite(R.mipmap.background, 5.0f, 8.0f, 9.0f, 16.0f));
        add(Layer.touch, new Button(R.mipmap.btn_resume_n, 5.0f, 8.0f, 5.2f, 2.0f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                if (action == Button.Action.released) {
                    Sound.playEffect(R.raw.button_sound);
                    popScene();
                    return true;
                }
                return false;
            }
        }));
        add(Layer.touch, new Button(R.mipmap.btn_exit_n, 5.0f, 5.5f, 5.2f, 2.0f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                if (action == Button.Action.released) {
                    Sound.playEffect(R.raw.button_sound);
                    finishActivity();
                    return true;
                }
                return false;
            }
        }));
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public void update(long elapsedNanos) {
        super.update(elapsedNanos);
    }

    @Override
    protected int getTouchLayerIndex() {
        return Layer.touch.ordinal();
    }
}
