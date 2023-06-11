package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.RectF;
import android.util.Log;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IBoxCollidable;
import com.tukorea.my_crossy_road.framework.interfaces.IRecyclable;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.scene.RecycleBin;

import java.util.Random;

public class Obstacle extends Sprite implements IRecyclable, IBoxCollidable {
    private static final String TAG = Environment.class.getSimpleName();
    private Obstacle.Type type;
    private float fMoveSpeedX = 0.0f;
    private boolean bMoveDirection = false;

    public enum Type {
        EmbulanceL, EmbulanceR, Tree, Rock, COUNT;
        int resId() {
            return resIds[this.ordinal()];
        }

        float width() {
            return widths[this.ordinal()];
        }

        float height() {
            return heights[this.ordinal()];
        }

        static int[] resIds = {
                R.mipmap.embulance_l,
                R.mipmap.embulance_r,
                R.mipmap.tree,
                R.mipmap.grass,
        };
        static float[] widths = {2.0f, 2.0f, 1.5f, 1.5f};
        static float[] heights = {1.0f, 1.0f, 1.5f, 1.5f};
    }

    public static Obstacle get(Environment.Type environmentType, float cx, float cy)
    {
        Obstacle obstacle = (Obstacle) RecycleBin.get(Obstacle.class);
        if(obstacle == null){
            obstacle = new Obstacle();
            Log.d(TAG, "Obstacle Created");
        }
        obstacle.init(environmentType, cx, cy);
        return obstacle;
    }

    private void init(Environment.Type environmentType, float cx, float cy) {
        if(environmentType == Environment.Type.Road)
        {
            Random random = new Random();

            if(random.nextBoolean()) {
                type = Type.EmbulanceR;
                setBitmapResource(R.mipmap.embulance_r);
                fMoveSpeedX = random.nextFloat() + 1.0f;
                this.width = Type.EmbulanceL.width();
                this.height = Type.EmbulanceL.height();
                this.x = cx + 1.0f;
                this.y = cy + 1.0f;
            }
            else {
                type = Type.EmbulanceL;
                setBitmapResource(R.mipmap.embulance_l);
                fMoveSpeedX = -(random.nextFloat() + 1.0f);
                this.width = Type.EmbulanceL.width();
                this.height = Type.EmbulanceL.height();
                this.x = cx + 1.0f;
                this.y = cy + 1.0f;
            }
        }
        else if(environmentType == Environment.Type.Grass)
        {
            Random random = new Random();

            int randInt = random.nextInt(2);

            if(randInt == 0)
            {
                type = Type.Tree;

                this.x = cx + 1.0f;
                this.y = cy + 1.0f;
                this.width = Type.Tree.width();
                this.height = Type.Tree.height();
                setBitmapResource(R.mipmap.tree);
            }
            else
            {
                type = Type.Rock;

                this.x = cx + 1.0f;
                this.y = cy + 1.0f;
                this.width = Type.Rock.width();
                this.height = Type.Rock.height();
                setBitmapResource(R.mipmap.rock);
            }
        }
        fixDstRect();
    }

    @Override
    public void update() {
        switch(type){
            case EmbulanceL:
            case EmbulanceR:
            {
                float dx = fMoveSpeedX * BaseScene.frameTime;

                x += dx;
                dstRect.offset(dx, 0);
            }
                break;
            case Tree:
                break;
            case Rock:
                break;
        }

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
    @Override
    public RectF getCollisionRect() {
        return dstRect;
    }
    @Override
    public void onRecycle() {
    }
}
