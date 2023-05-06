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
        environMentY = 17.0f;
    }

    @Override
    public void update() {
        MainScene scene = (MainScene) BaseScene.getTopScene();

        while(-3.0f < environMentY)
        {
            int seed = random.nextInt(2);

            if (seed == 0) {
                scene.add(MainScene.Layer.environment, new Environment(R.mipmap.grass, environMentY));
            }
            else {
                scene.add(MainScene.Layer.environment, new Environment(R.mipmap.road, environMentY));
            }

            environMentY -= 2.0f;
        }

        environMentY += 0.25f * BaseScene.frameTime;
    }

    @Override
    public void draw(Canvas canvas) {}
}
