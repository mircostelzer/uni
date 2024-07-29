package Prova;

import java.util.Scanner;

public class Prova {

    public static void main(String[] args) {
        A ac = new C();
        C cc = new C();
        System.out.println(ac.a);
        System.out.println(cc.a);
//        ac.meth(2);
        ac.meth();
    }
}

class A {
    public int a;
    public static final int b = 1;

    public A() {
        a = 2;
    }

    void meth() {
        System.out.println(a);
    }
}

class B extends A {

    public B() {}
}

class C extends B {

    public C() {
        super();
    }

    void meth(int x) {
        System.out.println(b);
    }
}