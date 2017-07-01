package com.cqupt.weigs.deBrujin;

import com.cqupt.weigs.graph.GraphByMatrix;

import java.io.*;

/**
 * @author weigs
 * @date 2017/6/7 0007
 */
public class Function2 {
    public static void main(String[] args) throws IOException {
        //从文件中读取read
        File file = new File("f:/demo/reads.fasta");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        //初始化图
        GraphByMatrix graphByMatrix = new GraphByMatrix(GraphByMatrix.DIRECTED_GRAPH,
                GraphByMatrix.ADJACENCY_MATRIX, GraphByMatrix.MAX_VALUE);

        int key = 39;
        //每次读取一行read
        String tempLine = "";
        //记录读取的是第几行
        int row = 1;
        while ((tempLine = reader.readLine()) != null) {
            char[] tempChar = tempLine.toCharArray();

            //第一行的数据读取
            if (row == 1) {
                //记录第一个k-mer
                String first = "";
                for (int j = 0; j < 39; j++) {
                    first += tempChar[j];
                    //将第一个k-mer存入图中
                    graphByMatrix.addVertex(first);
                }

                //遍历
                for (int i = (row == 1 ? 1 : 0); i < (100 - key + 1); i++) {
                    String tem = "";
                    for (int k = i; k < (i + key); k++) {
                        tem += tempChar[k];
                    }
                }
            }
        }
        row++;
    }
}
