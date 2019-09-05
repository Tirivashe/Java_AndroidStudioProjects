package com.tirivashe.paintcalculator;

public class InteriorRoom {
    static final int WINDOW_AREA = 16;
    static final int DOOR_AREA = 21;
    static final int SQR_FEET_PER_GAL = 275;

    private double mLength;
    private double mWidth;
    private double mHeight;

    private int mDoors;
    private int mWindows;

    public void setWidth(double width){
        mWidth = width;
    }
    public void setHeight(double height){
        mHeight = height;
    }
    public void setLength(double length){
        mLength = length;
    }
    public  void setDoors(int doors){
        mDoors = doors;
    }
    public void setWindows(int windows){
        mWindows = windows;
    }
    public double wallSurface(){
        return 2*mLength*mHeight + 2*mWidth*mHeight + mLength*mWidth;
    }
    public int windowsArea(){
        return mDoors*DOOR_AREA + mWindows*WINDOW_AREA;
    }
    public double surfaceArea(){
        return wallSurface() - windowsArea();
    }
    public int gallons(){
        return (int) Math.ceil(surfaceArea())/SQR_FEET_PER_GAL;
    }
}