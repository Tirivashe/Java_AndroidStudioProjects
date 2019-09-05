package com.tirivashe.artinmotions;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Arrays;

public class ArtWorkView extends View {
    private Paint paint;
    private int [][] artPostitions;

    public ArtWorkView(Context context){
        super(context);

        artPostitions = new int[19][2];

        int aquaBlue = Color.argb(255,148,205,204);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15.0f);
        paint.setColor(aquaBlue);
    }
    @Override
    protected void onDraw (Canvas canvas){
        for (int i = 0; i < 19; i++){
            canvas.drawCircle(artPostitions[i][0] + 100, artPostitions[i][1] + 200, 40, paint);
        }
    }

    public void update(int [][] values){
        artPostitions = Arrays.copyOf(values,values.length);
        invalidate();
    }
}
