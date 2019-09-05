package com.tirivashe.mazechase;

import android.content.*;
import android.graphics.*;
import android.view.*;
import java.util.*;

public class MazeCanvas extends View {
    public final int COLS = 8;
    public final int ROWS = 8;
    final int N_CELLS = COLS*ROWS;
    final int SIZE = 80;
    final int OFFSET = 50;

    public MazeCell [] board;

    public Paint paint;

    public MazeCanvas (Context context){
        super(context);

        board = new MazeCell[N_CELLS];

        int cellId = 0;
        for(int r = 0; r < ROWS; r++){
            for ( int c = 0; c < COLS; c++){
                int x = c*SIZE + OFFSET;
                int y = r*SIZE + OFFSET;
                MazeCell cell = new MazeCell(x,y,cellId);

                board[cellId] = cell;
                cellId++;
            }
        }

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2.0f);

        backtrackMaze();
    }
    public void onDraw(Canvas canvas){
        canvas.drawRGB(255, 255 ,255);

        for(int i = 0; i < N_CELLS; i++){
            int x = board[i].x;
            int y = board[i].y;

            if(board[i].north)
                canvas.drawLine(x,y,x+SIZE,y,paint);
            if(board[i].south)
                canvas.drawLine(x,y+SIZE,x+SIZE,y+SIZE,paint);
            if(board[i].east)
                canvas.drawLine(x+SIZE,y,x+SIZE,y+SIZE,paint);
            if(board[i].west)
                canvas.drawLine(x,y,x,y+SIZE,paint);
        }
    }
    public void backtrackMaze(){
        Stack<Integer>stack = new Stack<Integer>();
        int top;

        int visitedCells = 1;
        int cellID = 0;
        board[cellID].visited = true;
        stack.push(cellID);

        while (visitedCells < N_CELLS){
            String possibleWalls = "";
            if(board[cellID].north == true && cellID >= COLS){
                if(!board[cellID - COLS].visited){
                    possibleWalls += "N";
                }
            }
            if(board[cellID].west == true && cellID % COLS != 0){
                if(!board[cellID - 1].visited){
                    possibleWalls += "W";
                }
            }
            if(board[cellID].east == true && cellID % COLS != COLS-1){
                if(!board[cellID + 1].visited){
                    possibleWalls += "E";
                }
            }
            if(board[cellID].south == true && cellID < COLS*ROWS - COLS){
                if(!board[cellID + COLS].visited){
                    possibleWalls += "S";
                }
            }
            if (possibleWalls.length() > 0){
                int index = Math.round((int)(Math.random()*possibleWalls.length()));
                char randomWall = possibleWalls.charAt(index);

                switch (randomWall){
                    case 'N':
                        board[cellID].north = false;
                        board[cellID-COLS].south = false;
                        cellID -= COLS;
                        break;
                    case 'S':
                        board[cellID].south = false;
                        board[cellID+COLS].north = false;
                        cellID += COLS;
                        break;

                    case 'E':
                        board[cellID].east = false;
                        board[cellID+1].west = false;
                        cellID ++;
                        break;
                    case 'W':
                        board[cellID].west = false;
                        board[cellID-1].east = false;
                        cellID --;
                        break;
                }
                board[cellID].visited = true;
                stack.push(cellID);
                visitedCells++;
            }
            else {
                top = stack.pop();
                if(top == cellID){
                    cellID = stack.pop();
                    stack.push(cellID);
                }
            }
        }
    }
}
