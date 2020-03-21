package com.liangkuai.lib.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 抽象装饰者
 * 所有具体装饰者的父类
 *
 * @author liukai
 * @date 18-9-19
 */
public class MyFilterInputStream extends InputStream {


    protected volatile InputStream in;


    protected MyFilterInputStream(InputStream in) {
        this.in = in;
    }


    public int read() throws IOException {
        return in.read();
    }

}
