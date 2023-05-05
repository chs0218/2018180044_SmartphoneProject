package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.objects.AnimSprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;

public class Player extends AnimSprite {

    private static final String TAG = Player.class.getSimpleName();
    private float previousY;
    private float totalDy;

    public Player() {
        super(R.mipmap.character_animation_sheet, 5.0f, 15.0f, 2.0f, 2.0f, 8, 1);
    }

    protected static Rect[][] srcRects = {
            new Rect[] {
                    new Rect(0 * 900, 0 * 900, 1 * 900, 1 * 900)
            },

            new Rect[] {
                    new Rect(0 * 900, 0 * 900, 1 * 900, 1 * 900),
                    new Rect(1 * 900, 0 * 900, 2 * 900, 1 * 900),
                    new Rect(2 * 900, 0 * 900, 3 * 900, 1 * 900),
                    new Rect(3 * 900, 0 * 900, 4 * 900, 1 * 900)
            },

            new Rect[] {
                    new Rect(0 * 900, 1 * 900, 1 * 900, 2 * 900),
                    new Rect(1 * 900, 1 * 900, 2 * 900, 2 * 900),
                    new Rect(2 * 900, 1 * 900, 3 * 900, 2 * 900),
                    new Rect(3 * 900, 1 * 900, 4 * 900, 2 * 900)
            },

            new Rect[] {
                    new Rect(0 * 900, 2 * 900, 1 * 900, 3 * 900),
                    new Rect(1 * 900, 2 * 900, 2 * 900, 3 * 900),
                    new Rect(2 * 900, 2 * 900, 3 * 900, 3 * 900),
                    new Rect(3 * 900, 2 * 900, 4 * 900, 3 * 900)
            },

            new Rect[] {
                    new Rect(0 * 900, 3 * 900, 1 * 900, 4 * 900),
                    new Rect(1 * 900, 3 * 900, 2 * 900, 4 * 900),
                    new Rect(2 * 900, 3 * 900, 3 * 900, 4 * 900),
                    new Rect(3 * 900, 3 * 900, 4 * 900, 4 * 900)
            }
    };
    protected enum State {
        Idle, Move_Forward, Move_Right, Move_Left, Move_Backward
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

    @Override
    public void update() {
        switch (state) {
            case Move_Forward:
                float dy = -4.f * BaseScene.frameTime;

                totalDy += dy;

                if(totalDy > -2.0f) {
                    y += dy;
                    dstRect.offset(0, dy);
                }

                else {
                    dy = (previousY - 2.0f) - y;
                    y += dy;
                    dstRect.offset(0, dy);
                    state = State.Idle;
                }
                break;
        }
        Log.d(TAG, "x = " + x + " y = " + y);
    }

    public void onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            state = State.Move_Forward;
            previousY = y;
            totalDy = 0;
        }
    }
}
