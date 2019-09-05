package com.tirivashe.levic_curve;
import android.content.*;
import android.graphics.*;
import android.view.View;

public class FractalView extends View {
    private float x1;
    private float x2;
    private float y1;
    private float y2;
    public int level;

    private Fractal fractal;

    public FractalView (Context context){
        super(context);

        level = 2;
        fractal = new Fractal();
    }

    protected void onDraw(Canvas canvas){
        x1 = canvas.getWidth()/3;
        y1 = canvas.getHeight()/4;
        x2 = canvas.getWidth() - x1;
        y2 = y1;

        canvas.drawRGB(255,255,255);

        fractal.drawCCurve(canvas, x1, y1, x2, y2, level);
    }
}
