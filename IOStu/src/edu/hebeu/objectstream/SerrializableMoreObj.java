package edu.hebeu.objectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ���л��������
 * 	ʵ�֣�������ŵ������У����л����ϼ���
 * 	�������л��ļ��ϡ��඼��Ҫʵ��Serializable�ӿڣ�����
 * 	
 * 	���л�����ʱ���洢������󣬴洢�ڶ����ᱨ������
 * 
 * 	ע�⣺�������Ѿ�ʵ����Serializable�ӿڣ�����
 * 
 * @author 13651
 *
 */
public class SerrializableMoreObj {
	public static void main(String[] args) {
		List<ObjStudent> studentList = new ArrayList<>(); // ����ObjStudent���͵ļ���
		
		// ��������
		ObjStudent os1 = new ObjStudent("4155", "test01", 21);
		ObjStudent os2 = new ObjStudent("4556", "test02", 20);
		ObjStudent os3 = new ObjStudent("4542", "test03", 20);
		ObjStudent os4 = new ObjStudent("2323", "test04", 22);
		ObjStudent os5 = new ObjStudent("4155", "test05", 21);
		ObjStudent os6 = new ObjStudent("1242", "test06", 24);
		ObjStudent os7 = new ObjStudent("1215", "test07", 19);
		ObjStudent os8 = new ObjStudent("5674", "test08", 20);
		
		// ���������
		studentList.add(os1);
		studentList.add(os2);
		studentList.add(os3);
		studentList.add(os4);
		studentList.add(os5);
		studentList.add(os6);
		studentList.add(os7);
		studentList.add(os8);
				
		ObjectOutputStream oos = null; // ����ObjectOutputStream�����
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data\\serializable\\students")); // ����ObjectOutputStream�����
			
			// ���л�����(���л��������)
			oos.writeObject(studentList);
			
			oos.flush(); // ���������֮��Ҫˢ�£���չܵ�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
