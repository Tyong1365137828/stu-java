package edu.hebeu.ioandproperties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties��IO������ʹ��;
 * 
 * �������
 * 	��ƿ������
 * 		�Ժ󾭳��ı�����ݣ����Ե���д��һ���ļ��У�ʹ�ó���̬��ȡ��
 * 	  �����ڽ����޸�ʱֻҪ�޸��ļ������ݣ����ø���Java���룬����Ҫ���±��룬��������������õ��޸ĺ����Ϣ��
 * 
 * �������������ļ��������ļ������ҵ��ļ������ǣ�
 * 		key1=value1
 * 		key2=value2
 * ��ʱ�����ǳ�Ϊ���������ļ����������������ļ��� properties��β(�����Ǳ����)������Properties Map������ר�Ŵ洢���������ļ����ݵģ�
 * 
 * ���������ļ��У�
 * 		# ��ע�ͣ�
 * 		key�ظ���value���Զ����ǣ�
 * 		�ԵȺ�Ϊ�磬�Ⱥ������key���ұ���value��
 * 		�Ⱥ����߿����ֿո�(��ò�Ҫ�пո�)��
 * @author 13651
 *
 */
public class IOANDProperties {
	public static void main(String[] args) {
		FileReader fr = null;
		
		try {
			fr = new FileReader("data\\properties\\dataBaseInfo");
			
			Properties properties = new Properties(); // ����Properties��Map����
			properties.load(fr); // ����ͨ��Properties��load()�������ص�Properties����
			/**Properties���ϵ�key��value��Ҫ����String���ͣ����Ҵ�������ԵȺ�Ϊ�ָ��ߣ��Ⱥ������key���ұ���value��key�ظ���value���ǣ���*/
			
			String uName = properties.getProperty("username");
			String pwd = properties.getProperty("password");
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			
			System.out.println("�û�����" + uName + "; ���룺" + pwd + "; ������" + driver + "; URL��" + url);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
