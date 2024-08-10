package Prova;

import java.util.*;

public class Test {

public static void main(String[] args) {
        A a = new B(3);
        a = null;
        System.gc();
        System.runFinalization();

    }
}

class A {
    A(int x) { System.out.println("X"); }
    A() { System.out.println("Y"); }
    public void finalize() { System.out.println("Z"); }
}

class B extends A {
    B(int x) { System.out.println("A"); }
    B() { System.out.println("B"); }
    public void finalize() { System.out.println("C"); }
}



