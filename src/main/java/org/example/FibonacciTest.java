package org.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FibonacciTest {


    public void test() {
        //f(n) = f(n-1) + f(n-2)

        long startTime = new Date().getTime();
        System.out.println("fibo start ... " + startTime);
        int result = fibo2(50);
        long endTime = new Date().getTime();
        System.out.println("fibo : " + result + ", endTime =" + endTime + ", time = " + (endTime - startTime));
    }

    public int fibo(int n) {
        return n <= 1 ? n : (fibo(n-1) + fibo(n-2));
    }

    private Map<String, Integer> caches = new HashMap<>();
    public int fibo2(int n) {
        if(n <= 1) {
            return n;
        }
        int value1;
        int value2;

        {
            int n1 = n-1;
            if(caches.containsKey("n-"+n1)) {
                value1 = caches.get("n-"+n1);
            } else {
                value1 = fibo(n1);
                caches.put("n-"+n1, value1);
            }
        }
        {
            int n2 = n-2;
            if(caches.containsKey("n-"+n2)) {
                value2 = caches.get("n-"+n2);
            } else {
                value2 = fibo(n2);
                caches.put("n-"+n2, value2);
            }
        }
        return value1 + value2;
    }
}
