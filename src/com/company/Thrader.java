package com.company;

public class Thrader implements Runnable{

    private ResultRun resultRun;
    private String expression;

    public Thrader(String expression, ResultRun resultRun){
        this.expression = expression;
        this.resultRun = resultRun;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        Globals.calculate(-100,300,expression);
        resultRun.ResultRun();
    }
}
