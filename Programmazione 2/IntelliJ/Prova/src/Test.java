package Prova;

import java.util.*;
public class Test {
public static void main(String[] args) {
        String[] a = {"limone", "ananas", "mango", "lime"};
        Set<Integer> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for(String i: a) {
            s.add(i.length());
            l.add(i.length());
            }
        System.out.println(s.size() + l.size());
        }
}