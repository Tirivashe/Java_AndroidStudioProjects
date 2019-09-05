package com.tirivashe.virtualfish;

public class Fish {
    public int x;
    public int y;

    public static final int IsHungry = 1;
    public static final int IsSwimming = 2;
    public static final int IsEating = 3;

    private int mCondition;
    private int mVelocity;
    private int mStomachCapacity;
    private int mFoodInStomach;
    private int mTankWidth;
    private int mTankHeight;
    private int mDirection;

    private int playX, playY, foodX, foodY;

    public Fish(int xPos, int yPos, int condition, int tankWidth, int tankHeight){
        mCondition = condition;
        mVelocity = 3;
        mStomachCapacity = 80;
        mFoodInStomach = mStomachCapacity;
        mTankWidth = tankWidth;
        mTankHeight = tankHeight;
        x = xPos;
        y = yPos;
        mDirection = 1;

        foodY = (int)tankHeight/2 - 100;
        foodX = (int)(Math.ceil(Math.random()*mTankWidth) - mTankWidth/2);

        playY = (int) -(Math.random()*mTankHeight/2)+100;
        playX = (int) (Math.ceil(Math.random()*mTankWidth)-mTankWidth/2);
    }
    public void move(){
        switch (mCondition){
            case IsSwimming:
                swim();
                break;
            case IsHungry:
                findFood();
                break;
            case IsEating:
                eatFood();
        }
    }
    private void swim(){
        mFoodInStomach --;

        int xDistance = playX - x;
        int yDirection = playY - y;
        x += xDistance/mVelocity;
        y += yDirection/mVelocity;
        if (playX < x){
            mDirection = -1;
        }else{
            mDirection = 1;
        }
        if (Math.abs(xDistance) < 5 && Math.abs(yDirection) < 5){
            playX = (int) (Math.ceil(Math.random()*mTankWidth)- mTankWidth / 2);
            playY = (int) -(Math.random()* mTankHeight / 2) + 100;
        }
        if (mFoodInStomach <= 0){
            mCondition = IsHungry;
            foodX = (int) (Math.ceil(Math.random()*mTankWidth) - mTankWidth / 2) - 100;
        }
    }
    private void findFood(){
        int xDistance = foodX - x;
        int yDistance = foodY - y;

        x += xDistance/mVelocity;
        y += yDistance/mVelocity;

        if (foodX < x){
            mDirection = -1;
        }else {
            mDirection = 1;
        }
        if (Math.abs((x - foodX)) <= 10 && Math.abs(y-foodY) <=10){
            mCondition = IsEating
                    ;
        }
    }
    private void eatFood(){
        mFoodInStomach += 4;

        if (mFoodInStomach >= mStomachCapacity){
            mCondition = IsSwimming;
            playY = (int)-(Math.random()*mTankHeight/2) + 100;
            playX = (int) (Math.ceil(Math.random()*mTankWidth)-mTankWidth/2);
        }
    }
    public int getFacingDirection(){
        return mDirection;
    }
}
