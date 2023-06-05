package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.util.Log;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IRecyclable;
import com.tukorea.my_crossy_road.framework.objects.Sprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.scene.RecycleBin;

import java.util.Random;

public class Environment extends Sprite implements IRecyclable {
    private static final String TAG = Environment.class.getSimpleName();

    private Type type;

    public enum Type {
        Grass, Road, COUNT;

        int resId() {
            return resIds[this.ordinal()];
        }

        int width() {
            return widths[this.ordinal()];
        }

        int height() {
            return heights[this.ordinal()];
        }

        static int[] resIds = {
                R.mipmap.grass,
                R.mipmap.road
        };
        static int[] widths = {2, 2};
        static int[] heights = {2, 2};
        static Type random(Random random) {
            return Type.values()[random.nextInt(2)];
        }
    }

    public Environment(){
    }

    public static Environment get(Type type, float left, float top) {
        Environment environment = (Environment) RecycleBin.get(Environment.class);
        if (environment == null) {
            environment = new Environment();
//            Log.d(TAG, "Create New Environment");
        }
        environment.init(type, left, top);
        return environment;
    }

    public void init(Type type, float left, float top) {
        this.type = type;
        setBitmapResource(type.resId());
        width = type.width();
        height = type.height();
        dstRect.set(left, top, left + width, top + height);
    }

    @Override
    public void update() {
        if (dstRect.top > 18.0f) {
//            Log.d(TAG, "Removing:" + this);
            BaseScene.getTopScene().remove(getLayer(), this);
        }
    }

    public void PullDownEnvironment(float speed)
    {
        float dy = speed * BaseScene.frameTime;

        y += dy;
        dstRect.offset(0, dy);
    }

    protected MainScene.Layer getLayer() {
        return MainScene.Layer.environment;
    }

    @Override
    public void onRecycle() {}
}