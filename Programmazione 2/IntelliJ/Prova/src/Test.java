package Prova;

import java.util.*;

public class Test {
    static Collection ll = new LinkedList();
    int x = 6;
    Test() {}
    Test(int x) {
        ll.add(this);
        ll.add(new E5A());
    }

    public static void main(String[] args) {
       new Test(3);
       Iterator it = ll.iterator();
       while (it.hasNext()) {
           ((Test)(it.next())).f();
       }
    }
    public void f() { System.out.println(x); }
    class E5A extends Test {
        public void f() {
            x++; super.f(); System.out.println(2);
        }
    }
}









