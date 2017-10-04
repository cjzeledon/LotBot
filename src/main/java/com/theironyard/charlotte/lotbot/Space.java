package com.theironyard.charlotte.lotbot;

public class Space{
    private Transaction trans;

    public Space(Transaction trans) {
        this.trans = trans;
    }

    public Space() {
    }

    public Transaction getTrans() {
        return trans;
    }

    public void setTrans(Transaction trans) {
        this.trans = trans;
    }
}
