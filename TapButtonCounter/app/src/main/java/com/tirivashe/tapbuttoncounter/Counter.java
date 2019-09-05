package com.tirivashe.tapbuttoncounter;

class Counter {
    private int mCount;

    public Counter(){
        mCount = 0;
    }

    public void addCount(){
        mCount ++;
    }

    public Integer getCount(){
        return mCount;
    }
}
