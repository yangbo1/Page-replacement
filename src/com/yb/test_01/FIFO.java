package com.yb.test_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 先进先出算法
 * Created by 杨波 on 2016/11/23.
 */
public class FIFO {
    private static final int PRO_MEMORY = 4;//系统分配的内存块数
    private static Page[] pages = new Page[PRO_MEMORY];
    private static int countOldPoint ;//纪录最久的页面下标
    private static int count ;//纪录当前在使用的总页面数
    private static int lackTime;//缺页次数
    private List<Integer> usePageNumList = new ArrayList<Integer>();//页面使用列表


    /**初始化*/
    public  void init(){
        for(int i=0;i<pages.length;i++){
            pages[i] = new Page();
        }
    }

    /**接受传过来的list集合*/
    public void input(List<Integer> lists){
        /*System.out.println("传进去的list");
        for (Integer integer:lists){
            System.out.print(integer+" ");
        }
        System.out.println();*/
        for(int i=0;i<200;i++){
            usePageNumList.add(i,lists.get(i));
        }
        System.out.println("接受到的指令,总共"+usePageNumList.size()+"个指令");
        for (Integer integer:usePageNumList){
            System.out.print(integer+" ");
        }
        System.out.println();
    }


    /**系统运行*/
    public void running(){
        Iterator<Integer> it = usePageNumList.iterator();
        //列表置入替换
        while(it.hasNext()){
            countOldPoint = countOldPoint % PRO_MEMORY;
            int inPageId = it.next();
            //查找内存中是否有该页面
            if(search(inPageId)){
                System.out.println("内存中有"+inPageId+" ,不置换");
            }
            else if(count<PRO_MEMORY){//有空闲内存页
                pages[count].setId( (Integer)inPageId);
                System.out.println("页面"+pages[count].getId()+" 进入内存");
                count ++;
            }
            else{//替换
                replace(inPageId);
                lackTime ++;
                countOldPoint ++;
            }
            display();
        }
        System.out.println("缺页次数为:"+lackTime+",缺页率是:"+(float)lackTime/usePageNumList.size());
    }

    /**查找内存中是否有该页面*/
    public boolean search(int pageId){
        for(int i=0;i<pages.length;i++){
            if(pages[i].getId() == pageId){
                return true;
            }
        }
        return false;
    }

    /**置换算法*/
    public void replace(int pageId){
        //置换最久的页面
        int outPageId = -1;
        outPageId = pages[countOldPoint].getId();
        pages[countOldPoint].setId(pageId);
        System.out.println("页面"+pageId+" 进入内存, "+outPageId+"被置换出去");
    }

    /**显示当前内存页*/
    public void display(){
        System.out.print("当前内存的页面:");
        for(Page page : pages){
            System.out.print(page.getId()+" ");
        }
        System.out.println();
    }

}
