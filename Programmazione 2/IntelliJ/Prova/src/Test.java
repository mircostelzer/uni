package Prova;

import java.util.*;

public class Test {
    static int x = 1;
    class String5 {
        String s;
        String5() {this.s = ""+(++x);}
        public void finalize() {System.out.println(s);}
    }
    String5 a  = new String5();
    void f() {
        String5 a = new String5();
    }
    public void finalize() {System.out.println("A");}
public static void main(String[] args) {
        Test a5 = new Test(); a5.f();
        a5 = new Test(); a5.f();
        System.gc(); System.runFinalization();
    }
}





