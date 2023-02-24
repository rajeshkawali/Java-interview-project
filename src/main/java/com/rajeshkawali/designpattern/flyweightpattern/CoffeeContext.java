package com.rajeshkawali.designpattern.flyweightpattern;
// Context object that holds extrinsic state
public class CoffeeContext {
    private int table;

    public CoffeeContext(int table) {
        this.table = table;
    }

    public int getTable() {
        return table;
    }
}