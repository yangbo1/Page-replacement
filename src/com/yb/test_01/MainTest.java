package com.yb.test_01;

import org.junit.Test;

import java.util.List;

/**
 * 测试类
 * Created by 杨波 on 2016/11/23.
 */
public class MainTest {
    private static final List<Integer> lists = new RandList().randList();

    /**测试OPT算法*/
    @Test
    public void testOPT(){
        System.out.println();
        System.out.println();
        System.out.println("**OPT：最佳置换算法**");
        OPT opt = new OPT();
        opt.init();
        opt.input(lists);
        opt.running();
    }

    /**测试FIFO算法*/
    @Test
    public  void  testFIFO(){
        System.out.println();
        System.out.println();
        System.out.println("**FIFO，先进先出置换算法**");
        FIFO fifo = new FIFO();
        fifo.init();
        fifo.input(lists);
        fifo.running();
        }

    /**测试LRU算法*/
    @Test
    public void testLRU(){
        System.out.println();
        System.out.println();
        System.out.println("**LRU，最近最久未使用置换算法**");
        LRU lru = new LRU();
        lru.init();
        lru.input(lists);
        lru.running();
    }

  /*  *//**三个一起测试*//*
    @Test
    public void testAll(){
        System.out.println();
        System.out.println();
        System.out.println("**三种算法一起测试比较**");
        testOPT();
        testFIFO();
        testLRU();
    }*/
    }
