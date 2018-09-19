package com.liangkuai.lib.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 具体装饰者
 *
 * 缓冲输入字节流
 *
 * @author liukai
 * @date 18-9-19
 */
public class MyBufferedInputStream extends MyFilterInputStream {

    private static int DEFAULT_BUFFER_SIZE = 8192;

    private static int MAX_BUFFER_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 内部缓冲区
     */
    private byte[] buf;

    protected int count;

    protected int pos;


    /**
     * 检查输入流有没有关闭；没有则返回
     */
    private InputStream getInIfOpen() throws IOException {
        InputStream input = in;
        if (input == null)
            throw new IOException("Stream closed");
        return input;
    }

    /**
     * 检查缓冲区有没有因为输入流关闭而成为 null；没有则返回
     */
    private byte[] getBufIfOpen() throws IOException {
        byte[] buffer = buf;
        if (buffer == null)
            throw new IOException("Stream closed");
        return buffer;
    }



    public MyBufferedInputStream(InputStream in) {
        this(in, DEFAULT_BUFFER_SIZE);
    }

    public MyBufferedInputStream(InputStream in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        buf = new byte[size];
    }



    /**
     * 填充缓冲区
     */
    private void fill() throws IOException {
        byte buffer[] = getBufIfOpen();

        int n = getInIfOpen().read(buffer, pos, buffer.length - pos);
        if (n > 0)
            count = pos + n;
    }

}
