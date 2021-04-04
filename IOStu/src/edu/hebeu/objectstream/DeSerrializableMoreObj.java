package edu.hebeu.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * �����л��������
 * 	ʵ�֣�
 * @author 13651
 *
 */
public class DeSerrializableMoreObj {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("data\\serializable\\students"));
			
			// �����л��������
//			Object obj = ois.readObject();
//			System.out.print("�����л���ķ���ֵ�Ƿ�Ϊ���ϣ�"); System.out.println(obj instanceof List);
			System.out.println("�����л��������Ľ����");
			List<ObjStudent> studentList = (List<ObjStudent>)ois.readObject(); // ������ֵΪObject��������ת��ΪList����
			for(ObjStudent student : studentList) {
				System.out.println(student);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
