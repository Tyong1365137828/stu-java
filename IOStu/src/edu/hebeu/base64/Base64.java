package edu.hebeu.base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Encoder;
 
public class Base64 {
 
	/**
     * ������ͼƬת����Base64�����ַ���
     *
     * @param imgFile ͼƬĿ¼·��
     * @return
     */
    public static String getImgFileToBase64(String imgFile) {
        //��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
        InputStream inputStream = null;
        byte[] buffer = null;
        //��ȡͼƬ�ֽ�����
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
                    // �ر�inputStream��
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // ���ֽ�����Base64����
        return new BASE64Encoder().encode(buffer);
    }
    
    public static void main(String[] args) {
    	System.out.println(getImgFileToBase64("D:\\programme\\software\\compiler\\idea\\IDEA��ʹ��\\img\\2-���ñ༭�����������ʹ�ù��ַŴ���С.png"));
    }

}