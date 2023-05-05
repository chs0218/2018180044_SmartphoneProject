package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IGameObject;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

import java.util.Random;

public class MapLoader implements IGameObject {
    private static final String TAG = MapLoader.class.getSimpleName();
    private Random random = new Random();
    private float environMentY;

    MapLoader()
    {
        environMentY = -1.0f;
    }

    @Override
    public void update() {
        MainScene scene = (MainScene) BaseScene.getTopScene();

        while(environMentY <= 17.0f)
        {
            int seed = random.nextInt(2);
            for(int i = 0; i < 5; ++i) {
                if (seed == 0) {
                    scene.add(MainScene.Layer.environment, new Sprite(R.mipmap.grass, 1.0f + 2.0f * i, environMentY, 2.0f, 2.0f));
                }
                else {
                    scene.add(MainScene.Layer.environment, new Sprite(R.mipmap.road, 1.0f + 2.0f * i, environMentY, 2.0f, 2.0f));
                }
            }

            environMentY += 2.0f;
        }
    }

    @Override
    public void draw(Canvas canvas) {}
}
