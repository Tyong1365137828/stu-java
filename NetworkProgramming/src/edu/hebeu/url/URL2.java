package edu.hebeu.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ���������ʾ��δӷ�����������Դ
 * @author 13651
 *
 */
public class URL2 {
	private static InputStream is = null;
	private static FileOutputStream fos = null;
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://127.0.0.1:8080/examples/%E7%8B%BC.jpg");
			
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.connect();
			
			is = httpURLConnection.getInputStream();
			fos = new FileOutputStream(new File("data/download/��2.jpg"));
			
			byte[] buffer = new byte[1024];
			int readCount;
			while((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
			System.out.println("���سɹ���");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
