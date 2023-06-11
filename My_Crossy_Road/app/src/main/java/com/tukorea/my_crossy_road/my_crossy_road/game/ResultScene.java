package com.tukorea.my_crossy_road.my_crossy_road.game;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.objects.Button;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

public class ResultScene extends BaseScene {
    private final MainScene m_MainScene;

    public enum Layer {
        bg, touch, COUNT
    }
    public ResultScene(MainScene scene) {
        m_MainScene = scene;

        initLayers(PausedScene.Layer.COUNT);
        add(PausedScene.Layer.bg, new Sprite(R.mipmap.background, 5.0f, 8.0f, 9.0f, 16.0f));
        add(PausedScene.Layer.touch, new Button(R.mipmap.btn_restart_n, 5.0f, 8.0f, 5.2f, 2.0f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                if (action == Button.Action.released) {
                    m_MainScene.restartGame();
                    popScene();
                    return true;
                }
                return false;
            }
        }));
        add(PausedScene.Layer.touch, new Button(R.mipmap.btn_exit_n, 5.0f, 5.5f, 5.2f, 2.0f, new Button.Callback() {
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
        return PausedScene.Layer.touch.ordinal();
    }
}
