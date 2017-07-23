package com.cqupt.weigs.deBrujin;

import java.io.*;
import java.util.*;

/**
 *
 * @author weigs
 * @date 2017/6/23 0023
 */

public class Function3 {
    public static void main(String[] args) throws IOException {
        Function3 function3 = new Function3();
        List<String> list = function3.readFile("f:/demo/reads.fasta");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            map = function3.readGraph(map, list.get(i), 39);
        }

        //存取hash键
        List<String> list1 = new ArrayList<>();
        //存取hash值
        List<String> list2 = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list1.add(entry.getKey());
            list2.add(entry.getValue());
        }

        int fla = 0;
        for (String string1 : list1) {
            while (fla < 1) {
                fla += 1;
                result.add(string1.charAt(0));
            }
            //只需要一个，重复则剔除
            int flag = 0;
            for (String string2 : list2) {
                //比较，相同则添加到集合中，不同剔除
                if (string1.substring(0, 37).equals(string2.substring(1, 38))) {
                    while (flag < 1) {
                        flag += 1;
                        result.add(string2.charAt(0));
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : result) {
            stringBuilder.append(c);
        }
        //打印最终结果
        System.out.println(stringBuilder.toString());

        //打印最终拼接个数
        System.out.println(stringBuilder.toString().length());
    }

    //读取文件,将read存入list集合中
    public List<String> readFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(
                new FileReader(file));
        List<String> list = new ArrayList<>();
        String temp = "";
        while ((temp = reader.readLine()) != null) {
            list.add(temp);
        }
        return list;
    }

    //获取read构建图
    public Map<String, String> readGraph(Map<String, String> map, String string, int kmer) {

        String tmp1;
        String tmp2;
        for (int i = 0; i < 100 - kmer; i++) {
            tmp1 = string.substring(i, kmer + i);
            tmp2 = string.substring(i + 1, kmer + i + 1);
            //重复节点不存入图中
            if (tmp1.substring(1, kmer).equals(tmp2.substring(0, kmer - 1))) {
                if (!map.containsKey(tmp1)) {
                    map.put(tmp1, tmp2);
                }
            } else {
                if (!map.containsKey(tmp1)) {
                    map.put(tmp1, "");
                }
            }
        }


        return map;
    }

}

