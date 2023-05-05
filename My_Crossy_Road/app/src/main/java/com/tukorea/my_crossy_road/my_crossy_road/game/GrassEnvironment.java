package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IGameObject;
import com.tukorea.my_crossy_road.framework.objects.Sprite;

public class GrassEnvironment implements IGameObject {
    private TerrainSprite[] sprites = new TerrainSprite[5];

    public GrassEnvironment(float environmentY)
    {
        for(int i = 0; i < 5; ++i) {
                sprites[i] = new TerrainSprite(R.mipmap.grass, 1.0f + 2.0f * i, environmentY, 2.0f, 2.0f);
        }
    }
    @Override
    public void update() {
        for(int i = 0; i < 5; ++i) {
            sprites[i].update();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for(int i = 0; i < 5; ++i) {
            sprites[i].draw(canvas);
        }
    }
}
