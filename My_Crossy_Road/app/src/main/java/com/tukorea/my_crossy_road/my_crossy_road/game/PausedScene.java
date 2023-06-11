package com.tukorea.my_crossy_road.my_crossy_road.game;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.objects.Button;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

public class PausedScene extends BaseScene {

    public enum Layer {
       touch, COUNT
    }
    public PausedScene() {
        initLayers(Layer.COUNT);
        add(Layer.touch, new Button(R.mipmap.btn_resume_n, 8f, 3.5f, 2.667f, 1f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                if (action == Button.Action.released) {
                    popScene();
                    return true;
                }
                return false;
            }
        }));
        add(Layer.touch, new Button(R.mipmap.btn_exit_n, 8f, 5.5f, 2.667f, 1f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                if (action == Button.Action.released) {
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
