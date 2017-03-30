package com.weaponlin.entity;

/**
 * For Linked List
 * Created by Weapon Lin on 2017/3/25.
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

}
