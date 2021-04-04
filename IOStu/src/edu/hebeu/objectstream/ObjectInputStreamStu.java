package edu.hebeu.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * �����л���ObjectInputStream��ʵ��
 * 
 * ���л��汾�ŵ����ã�
 * 	java.io.InvalidClassException: edu.hebeu.objectstream.ObjStudent; local class incompatible: 
 * 	stream classdesc serialVersionUID = -2623336853608940719, // ���ǸĶ�֮��
 * 	local class serialVersionUID = -1160564518340679496 // ���ǸĶ�֮ǰ
 *	�����л���ɺ��ָĶ����룬�ڽ��з����л������������쳣
 *
 * ������Java��ʲô�����ࣿ
 * 	��һ������ͨ�������Ƚϣ����������һ�����϶�����ͬһ���ࣻ
 * 	�ڶ����������һ������ͨ�����л��汾�űȽ����������ǲ���һ���ࣻ
 * 
 *	���л��汾�Ž����ֶ���д������(���Է��ĵ�д��ֻҪ��֤ͬ������������л��汾�Ų�һ���Ϳ���)����Ϊ����������һ�����
 *�������л�֮�󣬸Ķ����룬�ٽ��з����л��������������쳣��
 *
 *	�����ͨ��JVM������Զ����ɵģ������л����֮��Ķ����룬class����֮��JVM�ھͻ������������л��汾�ţ���Ϊ�汾�ŵĲ�
 *ͬJVM�Ͳ���ʶ��֮ǰ���л�֮��Ķ��󣻾ͻ�������ϵ��쳣��Ϣ��
 *
 *	�磺A����Ա��д���� edu.hebeu.test.Test
 *		B����Ա��д���� edu.hebeu.test.Test
 *		��ͬ���˱�д��ͬһ�����ֵ���(��������ȷʵ�ǲ�һ����)����ʱͬ������Ҫ��JVM���֣����л��汾�ž������ó��ˡ�
 *	  ����Java�����JVM��˵�����ǿ���������������ģ���Ϊ�������඼ʵ����Serializable�ӿڣ�����Ĭ�ϵ����л��汾
 *	  �ţ����ǵ����л��汾�Ų�ͬ�������ֿ���(���ɷ��������Զ��������л��汾�ŵĺô�)
 * 	  �����Զ��������л��汾�����ַ�ʽ�ǲ�����ģ���ȱ�ݣ�
 * 		1��һ����������֮��(���л�֮��)�����ܽ��к����ĸ��ģ���ΪֻҪ���ģ���Ȼ�����±��룬��ʱJVM������ȫ�µ����л��汾�ţ�
 * 	  ��ʱJava������ͻὫ����Ϊ��һ��ȫ�µ���(�����Ӳ���)��������������л���JVM����Ϊ�޸ĺ������ȫ�µģ����ܽ��з����л������ˣ�
 * 
 * ���ۣ�
 * 	����һ����ʵ����Serializable�ӿڣ������������ֶ��ṩһ����������л��汾�ţ�������ͨ��JVM�Զ����ɵ����л��汾�ţ�
 * 	����������������л�֮�󣬼�ʹ���Ĵ��룬���ǰ汾�Ų��䣬JVM������Ϊ����ͬһ���࣬��֤�����л��ܹ��ɹ���

 * 
 * @author 13651
 *
 */
public class ObjectInputStreamStu {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("data\\serializable\\student"));
			Object obj = ois.readObject(); // ���з����л�
			System.out.println("�����л�֮��Ľ����" + obj);
			
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
