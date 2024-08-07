package Prova;

import java.util.*;
public class Test {
    static String removeLast(String str) {
        return str.substring(0, str.length() - 1);
    }
public static void main(String[] args) {
        I obj = new B("Scala");
        System.out.println(obj.m());

    }
}

interface I {
    public String m();
}

class A {
    String s;
    public A(String s) {
        this.s = s;
    }
    public String m() {
        return s;
    }
}

class B extends A implements I {
    B(String s) {
        super(s);
    }
    public String m() {
        return Test.removeLast(s);
    }
}