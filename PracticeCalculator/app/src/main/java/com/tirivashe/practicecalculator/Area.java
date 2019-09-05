package com.tirivashe.practicecalculator;

public class Area {
    private int height;
    private int width;

    public void setHeight(int h){
        height = h;
    }

    public void setWidth(int w){
        width = w;
    }

    public int computeArea(){
        return height*width;
    }
}


