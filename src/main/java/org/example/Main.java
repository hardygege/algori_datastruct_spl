package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        BasicAlgorithm algorithm = new BasicAlgorithm();
        algorithm.changeVariable();

        new FibonacciTest().test();

    }


}



class BasicAlgorithm {

    public void changeVariable() {
        int a = 5;
        int b = 10;

        //方法一
//        a = a + b;
//        b = a - b;
//        a = a - b;

        //方法二
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("  a: " + a + ", b: " + b);
    }



}