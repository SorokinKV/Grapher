package com.company;

public class Globals {
    public static int rangeX=1000; // Width
    public static int rangeY=600; // Heigth
    public static double[] valuesarray;
    public static double[] yarray; // map of graph

    public static void calculate(double a, double b, String expression) {
        valuesarray = new double[rangeX];
        yarray = new double[rangeX];

        double K = (b - a) / (rangeX - 1);

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < rangeX; ++i) {
            double x = a + K * i;
            try {
                valuesarray[i] = Espresso.calculus(expression.replace("@x", "(" + String.valueOf(x) + ")"));
                if( valuesarray[minIndex]>valuesarray[i]) minIndex = i ;
                if( valuesarray[maxIndex]<valuesarray[i]) maxIndex = i ;
            } catch (Exception e) {
                e.printStackTrace();
               // return;
            }
        }

        double min = valuesarray[minIndex];
        double max = valuesarray[maxIndex];

        double yconv = (rangeY-1)/(max-min);

        for( int i = 0 ; i < rangeX ; ++i ){
            yarray[i] = (max - valuesarray[i])*yconv;
        }

    }


}
