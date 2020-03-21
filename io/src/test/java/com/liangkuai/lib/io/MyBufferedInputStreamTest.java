package com.liangkuai.lib.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author liukai
 * @date 18-9-19
 */
public class MyBufferedInputStreamTest {

    public static void main(String[] args) {

        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("/home/liukai/桌面/基础数据_API对接文档.md"))) {

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}