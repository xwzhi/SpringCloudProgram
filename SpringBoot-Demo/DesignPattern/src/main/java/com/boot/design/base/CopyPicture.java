package com.boot.design.base;

import org.junit.jupiter.api.Test;

import java.io.*;

public class CopyPicture {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\Google浏览器.zip"));
            fos = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\Google浏览器1.zip"));
            byte[] b = new byte[8192];
            int len = 0;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("文件字节流复制视频花费时间为：" + (endTime - startTime));
    }

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\mayu\\Desktop\\Wildlife.wmv")));
            bos = new BufferedOutputStream(
                    new FileOutputStream(new File("C:\\Users\\mayu\\Desktop\\test\\Wildlife1.wmv")));
            byte[] b = new byte[64];
            int len = 0;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.flush();
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("缓冲字节流复制视频花费时间为：" + (endTime - startTime));
    }
}

