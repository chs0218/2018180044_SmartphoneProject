package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.util.Log;

import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

public class TerrainSprite extends Sprite {
    public TerrainSprite(int bitmapResId, float cx, float cy, float width, float height) {
       super(bitmapResId, cx, cy, width, height);
    }

    @Override
    public void update() {
        float dy = 0.25f * BaseScene.frameTime;

        y += dy;
        dstRect.offset(0, dy);
    }
}
