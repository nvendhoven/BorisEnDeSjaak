package com.hemantithide.borisendesjaak.Visuals;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import com.hemantithide.borisendesjaak.Engine.GameSurfaceView;
import com.hemantithide.borisendesjaak.R;

/**
 * Created by Daniel on 31/05/2017.
 */

public class Background {

    private GameSurfaceView game;

    private Bitmap sprite;

    private int lifespan;
    public int posY;

    public Background(GameSurfaceView game, int posY) {
        this.game = game;
        sprite = BitmapFactory.decodeResource(game.getContext().getResources(), R.drawable.grassloop_plus);
        sprite = Bitmap.createScaledBitmap(sprite, game.metrics.widthPixels, game.metrics.heightPixels, true);

        this.posY = posY;
        lifespan = posY;

        Log.e("Created", "background");
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(sprite, 0, posY, null);
    }

    public void update() {
        lifespan += game.gameSpeed;

        posY = lifespan;

        // resets the background to scroll
        if(lifespan > game.metrics.heightPixels)
            lifespan = 12 - sprite.getHeight();
    }
}