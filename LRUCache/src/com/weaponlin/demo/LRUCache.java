package com.weaponlin.demo;

import com.weaponlin.entity.Node;

import java.util.HashMap;

/**
 * Created by Weapon Lin on 2017/3/25.
 */
public class LRUCache {
    /* container */
    private HashMap<Integer,Node> cache;

    /* default capacity */
    private static final int DEFAULT_CAPACITY = 1<<4;
    /* capacity of this container */
    private int capacity;
    /* current size of this container */
    private int size;

    private Node head;
    private Node tail;

    /* default auto clear */
    private static final boolean AUTO_CLEAR = false;
    /* auto clear the most long did not used node. */
    private boolean autoClear;

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    public LRUCache(int capacity){
        this(capacity,AUTO_CLEAR);
    }

    public LRUCache(int capacity,boolean autoClear){
        this.capacity = capacity;
        this.autoClear = autoClear;
        cache = new HashMap<Integer,Node>(capacity);
        head = null;
        tail = null;
    }

    //add new node to cache
    public void add(int val){
        if(size >= capacity){
            if(!autoClear) {
                System.err.println("There is not enough space!");
                return;
            }
            this.clear();
        }

        Node n = new Node(val);
        if(head == null){
            head = n;
            tail = n;
        }else{
            n.next = head;
            head.prev = n;
            head = n;
        }
        cache.put(val,n);
        size++;
    }

    /* get one node,and reset this node as head */
    public Node get(Integer key){
        Node n = cache.get(key);
        if(n == null){
            return null;
        }

        if(n.next == null){
            //the last node
            n.prev.next = null;
            tail = n.prev;
            setHead(n);
        }else if(n != head) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            setHead(n);
        }else{
            //do not change for head
        }

        return n;
    }

    /* set one node as head */
    private void setHead(Node n){
        n.next = head;
        head.prev = n;
        n.prev = null;
        head = n;
    }

    /* clear the most long did not used node */
    private void clear(){
        //empty one space
        cache.remove(tail.val);
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    /* print nodes */
    public void printNodes(){
        if(head == null){
            System.out.println("null");
            return;
        }
        Node t = head;
        while(t != null){
            System.out.print(t.val + "\t");
            t = t.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(4);
        cache.add(5);
        cache.printNodes();
        Node t = cache.get(3);
        System.out.println(t == null ? "null" : t.val);
        cache.printNodes();
    }


}
