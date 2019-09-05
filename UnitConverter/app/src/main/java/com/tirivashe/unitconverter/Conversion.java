package com.tirivashe.unitconverter;

public class Conversion {
    static final int LIGHTYEARS = 1;
    static final int MILES = 2;
    static final double MILES_PER_LIGHT_YEAR = 5.8786e12;
    static final double LIGHT_YEARS_PER_MILE = 1/MILES_PER_LIGHT_YEAR;

    private int isA;
    public String inputLabel;
    public String outputLabel;

    public Double inputValue;
    public Double outputValue;

    public Conversion(){
        isA = LIGHTYEARS;

        inputLabel = "LIGHT YEARS";
        outputLabel = "MILES";
        inputValue= 0.0;
        outputValue = 0.0;
    }

    public void switch_toLightYearsMiles(){
        isA = LIGHTYEARS;
        inputLabel = "LIGHT YEARS";
        outputLabel = "MILES";
        compute();
    }

    public void switch_toMilesLightYears(){
        isA = MILES;
        inputLabel = "MILES";
        outputLabel = "LIGHT YEARS";
        compute();
    }

    public void compute(){
        switch (isA){
            case LIGHTYEARS:
                outputValue = inputValue * MILES_PER_LIGHT_YEAR;
                break;
            case MILES:
                outputValue = inputValue * LIGHT_YEARS_PER_MILE;
        }
    }
}
