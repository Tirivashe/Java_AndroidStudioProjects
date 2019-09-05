package com.tirivashe.areacalculator;

public class Area {
    private double height;
    private double width;
    private double result;


    public double computeArea(){
       return result = height * width;
    }

    public double setHeight(double h) {
        height = h;
        return height;
    }

    public double setWidth(double w){
        width = w;
        return width;
    }

    public void setResult(double r){
        result = r;
        computeArea();
    }

    public Double getResult(){
        return result;
    }

}
