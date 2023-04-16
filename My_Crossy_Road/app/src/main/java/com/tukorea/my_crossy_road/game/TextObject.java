package com.tukorea.my_crossy_road.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.tukorea.my_crossy_road.framework.BaseScene;
import com.tukorea.my_crossy_road.framework.IGameObject;

public class TextObject implements IGameObject {
    private String targetString;
    private Paint paint;

    private float tx, ty;

    public TextObject(String string, int color, float textSize, float x, float y){
        targetString = string;

        paint = new Paint();
        paint.setColor(color);
        paint.setTextSize(textSize);

        tx = x;
        ty = y;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(targetString, tx, ty, paint);
    }
}
