package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IGameObject;
import com.tukorea.my_crossy_road.framework.res.BitmapPool;
import com.tukorea.my_crossy_road.framework.view.Metrics;

public class Score implements IGameObject {
    private final Bitmap bitmap;
    private final int srcCharWidth, srcCharHeight;
    private final float right, top;
    private final float dstCharWidth, dstCharHeight;
    private Rect srcRect = new Rect();
    private RectF dstRect = new RectF();
    private int score, displayScore;

    public Score(float fRight, float fTop) {
        this.bitmap = BitmapPool.get(R.mipmap.numbers);
        this.right = fRight;
        this.top = fTop;
        this.dstCharWidth = 1.0f;
        this.srcCharWidth = bitmap.getWidth() / 10;
        this.srcCharHeight = bitmap.getHeight();
        this.dstCharHeight = dstCharWidth * srcCharHeight / srcCharWidth;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    @Override
    public void update() {
        int diff = score - displayScore;
        if (diff == 0) return;
        if (-10 < diff && diff < 0) {
            displayScore--;
        } else if (0 < diff && diff < 10) {
            displayScore++;
        } else {
            displayScore += diff / 10;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        int value = this.displayScore;
        float x = right;

        if(value == 0)
        {
            srcRect.set(0, 0, srcCharWidth, srcCharHeight);
            x -= dstCharWidth;
            dstRect.set(x, top, x + dstCharWidth, top + dstCharHeight);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
        }
        else
        {
            while (value > 0) {
                int digit = value % 10;
                srcRect.set(digit * srcCharWidth, 0, (digit + 1) * srcCharWidth, srcCharHeight);
                x -= dstCharWidth;
                dstRect.set(x, top, x + dstCharWidth, top + dstCharHeight);
                canvas.drawBitmap(bitmap, srcRect, dstRect, null);
                value /= 10;
            }
        }
    }

    public void add(int amount) {
        score += amount;
    }
}
