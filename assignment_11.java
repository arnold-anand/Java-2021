package com.arnold;

import java.util.Scanner;

class calculators extends Thread {
    int x;
    int y;

    calculators(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public synchronized void add() {
        System.out.println("Result add:" + (x + y));
    }

    public synchronized void sub() {
        System.out.println("Result subtract:" + (x - y));
    }

    public synchronized void mul() {
        System.out.println("Result multiply:" + (x * y));
    }

    public synchronized void div() {
        System.out.println("Result divide:" + (x / y));
    }
}

public class assignment_11 {
    public static void main(String[] args) throws Exception {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter any two numbers: ");
        int a = s1.nextInt();
        int b = s1.nextInt();
        calculators calc = new calculators(a, b);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 result...");
                calc.add();
                calc.sub();
                calc.mul();
                calc.div();
                System.out.println("\n");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 result...");
                calc.add();
                calc.sub();
                calc.mul();
                calc.div();
                System.out.println("\n");
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
    }
}

