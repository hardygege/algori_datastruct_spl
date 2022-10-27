package org.example;

public class FibonacciTest {


    public void test() {
        //f(n) = f(n-1) + f(n-2)

        int result = fibo(10);
        System.out.println("fibo : " + result);
    }

    public int fibo(int n) {
        return n <= 1 ? n : (fibo(n-1) + fibo(n-2));
    }

}
