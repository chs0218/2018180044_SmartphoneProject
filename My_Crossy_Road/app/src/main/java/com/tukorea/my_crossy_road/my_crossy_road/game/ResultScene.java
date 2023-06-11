package com.tukorea.my_crossy_road.my_crossy_road.game;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.objects.Button;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.res.Sound;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

public class ResultScene extends BaseScene {
    private final MainScene m_MainScene;

    public enum Layer {
        bg, result, touch, COUNT
    }
    public ResultScene(MainScene scene) {
        m_MainScene = scene;

        initLayers(ResultScene.Layer.COUNT);
        add(ResultScene.Layer.bg, new Sprite(R.mipmap.background, 5.0f, 8.0f, 9.0f, 16.0f));

        int mainSceneScore = m_MainScene.getScore();
        int digit = 0;

        if(mainSceneScore == 0)
            digit = 1;

        while(mainSceneScore > 0){
            digit += 1;
            mainSceneScore /= 10;
        }

        float fScoreCorrection = 2.25f + digit * 0.95f;
        float resultTextX = 4.2f - digit * 0.25f;

        add(ResultScene.Layer.result, new Sprite(R.mipmap.resulttext, resultTextX, 3.5f, 5.0f, 1.0f));

        Score score = new Score(resultTextX + fScoreCorrection, 2.75f);
        score.setScore(m_MainScene.getScore());
        add(ResultScene.Layer.result, score);

        add(ResultScene.Layer.touch, new Button(R.mipmap.btn_restart_n, 5.0f, 8.0f, 5.2f, 2.0f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                if (action == Button.Action.released) {
                    m_MainScene.restartGame();
                    Sound.playEffect(R.raw.button_sound);
                    popScene();
                    return true;
                }
                return false;
            }
        }));
        add(ResultScene.Layer.touch, new Button(R.mipmap.btn_exit_n, 5.0f, 5.5f, 5.2f, 2.0f, new Button.Callback() {
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
        return ResultScene.Layer.touch.ordinal();
    }
}
