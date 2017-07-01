package com.cqupt.weigs.deBrujin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 生物信息学大实验
 * 1、随机生成正链DNA序列
 * 2、随机从链中各自取出1000条read
 * 3、保存read文件，格式采用fasta格式
 *
 * @author weigs
 * @date 2017/6/6 0006
 */
public class Function1 {

    //随机生成正链DNA序列
    public String RandomDNA() {
        String DNA = "";
        char[] bases = {'A', 'C', 'T', 'G'};
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            int num = random.nextInt(4);
            DNA += bases[num];
        }
        return DNA;
    }


    //随机取出
    public void randomSelect(String DNA) throws IOException {
        char[] dans = DNA.toCharArray();
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(
                new File("f:/demo/reads.fasta"), true);
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(4900);
            String tmp = "";
            for (int j = num; j < num + 100; j++) {
                tmp +=dans[j];
            }
            fileWriter.write(tmp+"\n");

        }

        fileWriter.close();
    }
}
