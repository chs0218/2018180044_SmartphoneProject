package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IGameObject;
import com.tukorea.my_crossy_road.framework.interfaces.IRecyclable;

public class Environment implements IGameObject, IRecyclable {
    private TerrainSprite[] sprites = new TerrainSprite[5];

    public Environment(int resource, float environmentY)
    {
        for(int i = 0; i < 5; ++i) {
            sprites[i] = new TerrainSprite(resource, 1.0f + 2.0f * i, environmentY, 2.0f, 2.0f);
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

    @Override
    public void onRecycle() {
    }
}