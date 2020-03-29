package com.daniel.concurrentTest;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/27 21:05
 */
public class TestMap2 {
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("device1");
            list1.add("device2");

            List<String> oldList = map.putIfAbsent("topic1", list1);
            if(oldList != null){
                oldList.addAll(list1);
            }
            System.out.println(JSON.toJSONString(map));
        });

        Thread threadTwo = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("device11");
            list1.add("device22");

            List<String> oldList = map.putIfAbsent("topic1", list1);
            if(oldList != null){
                oldList.addAll(list1);
            }
            System.out.println(JSON.toJSONString(map));
        });

        Thread threadThree = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("device111");
            list1.add("device222");

            List<String> oldList = map.put("topic2", list1);
            if(oldList != null){
                oldList.addAll(list1);
            }
            System.out.println(JSON.toJSONString(map));
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
