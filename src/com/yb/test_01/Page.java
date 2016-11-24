package com.yb.test_01;

/**
 * Created by 杨波 on 2016/11/23.
 */
public class Page {
    private int id = -1;
    private int count;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCount() {
        return count;
    }
    public void inc() {
        count ++;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
