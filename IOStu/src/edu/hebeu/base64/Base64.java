package edu.hebeu.base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Encoder;
 
public class Base64 {
 
	/**
     * 将本地图片转换成Base64编码字符串
     *
     * @param imgFile 图片目录路径
     * @return
     */
    public static String getImgFileToBase64(String imgFile) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream inputStream = null;
        byte[] buffer = null;
        //读取图片字节数组
        try {
            inputStream = new FileInputStream(imgFile);
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            buffer = new byte[count];
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭inputStream流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 对字节数组Base64编码
        return new BASE64Encoder().encode(buffer);
    }
    
    public static void main(String[] args) {
    	System.out.println(getImgFileToBase64("D:\\programme\\software\\compiler\\idea\\IDEA的使用\\img\\2-设置编辑区的字体可以使用滚轮放大缩小.png"));
    }

}