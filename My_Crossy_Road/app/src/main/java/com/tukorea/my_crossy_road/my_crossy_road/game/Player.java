package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.objects.AnimSprite;

public class Player extends AnimSprite {
    public Player() {
        super(R.mipmap.backward, 2.0f, 3.0f, 2.0f, 2.0f, 8, 1);
    }

    protected static Rect[][] srcRects = {
            new Rect[] {
                    new Rect(0 * 900, 0, 1 * 900, 900),
                    new Rect(1 * 900, 0, 2 * 900, 900),
                    new Rect(2 * 900, 0, 3 * 900, 900),
                    new Rect(3 * 900, 0, 4 * 900, 900)
            }
    };
    protected enum State {
        Idle
    }
    protected State state = State.Idle;
    @Override
    public void draw(Canvas canvas) {
        long now = System.currentTimeMillis();
        float time = (now - createdOn) / 1000.0f;
        Rect[] rects = srcRects[state.ordinal()];
        int frameIndex = Math.round(time * fps) % rects.length;
        canvas.drawBitmap(bitmap, rects[frameIndex], dstRect, null);
    }
}
