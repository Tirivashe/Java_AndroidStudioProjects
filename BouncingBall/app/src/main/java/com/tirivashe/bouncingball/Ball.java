package com.tirivashe.bouncingball;
import android.*;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    private final int RADIUS = 100;
    private final int REVERSE = -1;
    private int x, y, velX, velY;

    public Ball(){
        x = 100;
        y = 100;
        velX = 10;
        velY = 10;
    }

    public void move(int leftWall, int topWall, int rightWall, int bottomWall){
        x += velX;
        y += velX;

        if(y > bottomWall - RADIUS){
            y = bottomWall - RADIUS;
            velY *= REVERSE;
        }else if (y < topWall + RADIUS){
            y = topWall + RADIUS;
            velY *= REVERSE;
        }
        if (x > rightWall - RADIUS){
            x = rightWall - RADIUS;
            velX *= REVERSE;
        }else if (x < leftWall + RADIUS){
            x = leftWall + RADIUS;
            velX *= REVERSE;
        }
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.rgb(211,216,156));
        canvas.drawCircle(x,y,RADIUS,paint);
    }
}
