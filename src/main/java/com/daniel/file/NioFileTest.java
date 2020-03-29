package com.daniel.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/28 15:14
 */
public class NioFileTest {

    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        String pathname = "/Users/xiadonghui/Desktop/public.txt";
        int i = 0;
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                i++;
                System.out.println(line);
            }
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
