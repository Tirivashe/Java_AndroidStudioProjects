package com.tirivashe.mazechase;


public class MazeCell {
    public int x;
    public int y;
    public int id;
    public boolean visited;
    public boolean north;
    public boolean south;
    public boolean east;
    public boolean west;

    public MazeCell (int xPos, int yPos, int cellId){
        x = xPos;
        y = yPos;
        visited = false;
        north = true;
        south = true;
        east = true;
        west = true;
    }
}
