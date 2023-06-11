package com.tukorea.my_crossy_road.my_crossy_road.game;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintSet;

import com.tukorea.my_crossy_road.R;
import com.tukorea.my_crossy_road.framework.interfaces.IBoxCollidable;
import com.tukorea.my_crossy_road.framework.objects.AnimSprite;
import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.view.Metrics;

public class Player extends AnimSprite implements IBoxCollidable {

    private static final String TAG = Player.class.getSimpleName();
    private float touchDownX;
    private float previousX, previousY;
    private float totalDx, totalDy;
    public boolean m_bDead = false;

    public Player() {
        super(R.mipmap.character_animation_sheet, 5.0f, 15.0f, 1.0f, 1.0f, 8, 1);
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

    @Override
    public RectF getCollisionRect() {
        return dstRect;
    }

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
        MainScene scene = (MainScene) BaseScene.getTopScene();
        switch (state) {
            case Move_Forward:
                float dy = -4.f * BaseScene.frameTime;

                totalDy += dy;

                if(totalDy > -2.0f) {
                    y += dy;
                    dstRect.offset(0, dy);
                } else {
                    scene.addScore();
                    state = State.Idle;
                }
                break;
            case Move_Right:
                {
                    float dx = 4.f * BaseScene.frameTime;

                    totalDx += dx;

                    if (totalDx < 2.0f) {
                        x += dx;
                        dstRect.offset(dx, 0);
                    } else {
                        state = State.Idle;
                    }
                }
                break;
            case Move_Left:
                {
                    float dx = -4.f * BaseScene.frameTime;

                    totalDx += dx;

                    if (totalDx > -2.0f) {
                        x += dx;
                        dstRect.offset(dx, 0);
                    } else {
                        state = State.Idle;
                    }
                }
                break;
        }


    }


    float GetY()
    {
        return y;
    }

    public void PullDownCharacter(float speed)
    {
        float dy = speed * BaseScene.frameTime;

        y += dy;
        dstRect.offset(0, dy);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            touchDownX = Metrics.toGameX(event.getX());
            return true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            float touchUpX = Metrics.toGameX(event.getX());

            if(Math.abs(touchUpX - touchDownX) < 0.1f && state == State.Idle)
            {
                state = State.Move_Forward;
                previousY = y;
                totalDy = 0;
            }
            else if (state == State.Idle) {
                if(touchUpX - touchDownX < 0.f)
                {
                    if(x > 1.5f) {
                        state = State.Move_Left;
                        previousX = x;
                        totalDx = 0;
                    }
                }
                else
                {
                    if(x < 7.5f) {
                        state = State.Move_Right;
                        previousX = x;
                        totalDx = 0;
                    }
                }
            }
            return true;
        }

        return false;
    }

    public void setbDead(boolean bDead){ m_bDead = bDead; }
}
