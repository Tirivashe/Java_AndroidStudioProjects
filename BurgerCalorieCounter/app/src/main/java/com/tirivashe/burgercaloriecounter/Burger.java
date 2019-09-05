package com.tirivashe.burgercaloriecounter;
public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCUITTO = 115;

    private int mPattyCal;
    private int mCheeseCal;
    private int mProscuittoCal;
    private int mSauceCal;

    public Burger(){
        mPattyCal = BEEF;
        mCheeseCal = ASIAGO;
        mProscuittoCal = 0;
        mSauceCal = 0;
    }

    public void setPattyCalories(int calories){
        mPattyCal = calories;
    }

    public void setCheeseCalories(int calories){
        mCheeseCal = calories;
    }

    public void setProscuittoCalories(int calories){
        mProscuittoCal = calories;
    }

    public void clearProscuittoCalories(){
        mProscuittoCal = 0;
    }

    public void setSauceCalories(int calories){
        mSauceCal =calories;
    }

    public int getTotalCalories() {
        return mPattyCal + mCheeseCal + mProscuittoCal + mSauceCal ;
    }
}
