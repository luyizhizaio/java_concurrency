package com.kyrie.algorithm.greed;

import java.util.*;

public class GreedAlgorithm {


    public static void main(String[] args) {


        /*
        实现步骤：
        1）找出需要覆盖的所有地区
        2）遍历所有电台，找到一个最多未覆盖的地区的电台，
        3）从需要覆盖的所有地区中去掉已覆盖的地区
        4）重复2，3步骤，直到覆盖全部地区
         */

        HashMap<String, String[]> map = new HashMap<>();
        map.put("K1", new String[]{"北京", "上海", "天津"});
        map.put("K2",new String[]{"广州","北京","深圳"});
        map.put("K3",new String[]{"成都","上海","杭州"});
        map.put("K4",new String[]{"上海","天津"});
        map.put("K5",new String[]{"杭州","大连"});


        // 1）找出需要覆盖的所有地区
        TreeSet<String> uncoverAreas = new TreeSet<>();

        for (Map.Entry<String,String[]> en: map.entrySet()){
            String[] strs = en.getValue();
            for(String s : strs){
                uncoverAreas.add(s);
            }
        }

        System.out.println(uncoverAreas);


        ArrayList<String> diantai = new ArrayList<>();

        while(uncoverAreas.size() >0){

            Map<String,Integer> coverNumMap = new HashMap<String,Integer>();

            //2）遍历所有电台，找到一个最多未覆盖的地区的电台
            for (Map.Entry<String,String[]> en: map.entrySet()){
                String[] strs = en.getValue();
                for(String s : strs){
                    if(uncoverAreas.contains(s)){
                       Integer num = coverNumMap.get(en.getKey());
                       if(num == null){
                           coverNumMap.put(en.getKey(),1);
                       }else{
                           coverNumMap.put(en.getKey(), num + 1);
                       }
                    }
                }
            }

            String maxKey = "";
            int max =0;
            for (Map.Entry<String,Integer> en: coverNumMap.entrySet()){

                if(en.getValue() >max ){
                    max = en.getValue();
                    maxKey = en.getKey();
                }
            }

            // 3）从需要覆盖的所有地区中去掉已覆盖的地区
            String[] areas = map.get(maxKey);
            for (String area:areas) {
                uncoverAreas.remove(area);
            }

            diantai.add(maxKey);

        }
        System.out.println(diantai.toString());
    }
}
