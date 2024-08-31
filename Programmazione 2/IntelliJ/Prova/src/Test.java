package Prova;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Test {
    static Collection<Test> s = new HashSet<>();
    int k, j;
    Test(int k, int j) {
        this.k = k;
        this.j = j;
    }
    public boolean equals(Object d) {
        return k-j == ((Test) d).j-((Test) d).k;
    }
    public int hashCode() { return 1; }
    public static void main(String[] args) {
       s.add(new Test(1, 2)); s.add(new Test(0, 1));
       s.add(new Test(2, 1)); s.add(new Test(1, 0));
       for (Test t: s) { System.out.println(t.k + " " + t.j); }
    }

}














