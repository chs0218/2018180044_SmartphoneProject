package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;
import android.util.Log;

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

        while(-5.0f < environMentY)
        {
            Environment.Type randomType = Environment.Type.random(random);

            int randomInt = random.nextInt(5);
            for(int i = 0; i < 5; ++i) {
                Environment environment = Environment.get(randomType, 1.0f * 2.0f * i, 1.0f + environMentY);
                scene.add(MainScene.Layer.environment, environment);

                if(i == randomInt)
                    scene.add(MainScene.Layer.obstacle, new Obstacle(randomType, 1.0f * 2.0f * i, 1.0f + environMentY));
            }

            environMentY -= 2.0f;
        }
    }

    public void PullDownMapLoader(float speed)
    {
        environMentY += speed * BaseScene.frameTime;
    }

    @Override
    public void draw(Canvas canvas) {}
}
