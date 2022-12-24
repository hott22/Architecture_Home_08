package ru.geekbrains.lesson8;

import java.util.ArrayList;
import java.util.Collection;

public class test {
    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList<>();
        coll.add(5);
        coll.add(6);
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(coll.iterator().next().compareTo(i));
        }

        for (int i :
                coll) {
            System.out.println(i);
        }
    }

}
