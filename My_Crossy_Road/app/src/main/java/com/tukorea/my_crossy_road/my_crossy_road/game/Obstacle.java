package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.util.Log;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

public class Obstacle extends Sprite {
    private static final String TAG = Environment.class.getSimpleName();
    Obstacle(Environment.Type environmentType, float cx, float cy){
        if(environmentType == Environment.Type.Road)
        {
            this.x = cx + 1.0f;
            this.y = cy + 1.0f;
            this.width = 2.f;
            this.height = 1.f;
            setBitmapResource(R.mipmap.embulance);
        }
        else if(environmentType == Environment.Type.Grass)
        {
            this.x = cx + 1.0f;
            this.y = cy + 1.0f;
            this.width = 1.5f;
            this.height = 1.5f;
            setBitmapResource(R.mipmap.tree);
        }
        fixDstRect();
    }

    @Override
    public void update() {
        if (dstRect.top > 18.0f) {
            Log.d(TAG, "Removing:" + this);
            BaseScene.getTopScene().remove(getLayer(), this);
        }
    }

    public void PullDownObstacle(float speed)
    {
        float dy = speed * BaseScene.frameTime;

        y += dy;
        dstRect.offset(0, dy);
    }

    protected MainScene.Layer getLayer() {
        return MainScene.Layer.obstacle;
    }
}
