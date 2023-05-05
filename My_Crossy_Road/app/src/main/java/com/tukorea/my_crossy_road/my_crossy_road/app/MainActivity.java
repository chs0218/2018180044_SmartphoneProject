package com.tukorea.my_crossy_road.my_crossy_road.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tukorea.my_crossy_road.framework.scene.BaseScene;
import com.tukorea.my_crossy_road.framework.view.GameView;
import com.tukorea.my_crossy_road.my_crossy_road.game.LobbyScene;
import com.tukorea.my_crossy_road.my_crossy_road.game.MainScene;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);

        new BaseScene().pushScene(new MainScene());
        new BaseScene().pushScene(new LobbyScene());
    }
}