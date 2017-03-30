package com.weaponlin.test;

import java.util.HashMap;

/**
 * Created by Weapon Lin on 2017/3/25.
 */
public class Test {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        String i1 = new String("1");
        String i2 = new String("1");
        map.put(i1,1);
        System.out.println(map.get(i1));
        map.put(i2,2);
        System.out.println(i1.hashCode() == i2.hashCode());
        System.out.println(map.get(i2));
        System.out.println(map.get(i1));
    }
}
