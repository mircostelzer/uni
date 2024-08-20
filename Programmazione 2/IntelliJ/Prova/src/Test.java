package Prova;

import java.util.*;

public class Test {

public static void main(String[] args) {
       Group<A> g = new Group<>();
       g.add(new A());
       g.add(new A());
       g.add(new A());
       g.show();
    }
}

class Group<T> {
    List<T> l = new ArrayList<>();
    void add(T obj) { l.add(obj); }
    void show() {
        for (T t : l) {
            System.out.println(t);
        }
    }
}

class A {
    static int counter = 20;
    int x;
    A() { x = ++counter; }
    public String toString() { return x + ""; }
}






