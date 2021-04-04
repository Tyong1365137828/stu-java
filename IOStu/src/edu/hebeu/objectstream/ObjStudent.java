package edu.hebeu.objectstream;

import java.io.Serializable;

/**
 * ѧ����
 * 	ע�⣺ͨ��Դ���뷢�֣�Serializable�ӿ�ֻ��һ����־�ӿڣ��ڲ�ʲô����Ҳû�У��𵽱�ʶ�����ã�Java��������ܻ����������������
 * Serializable����ӿ��Ǹ�Java������ο��ģ�Java�������������ӿ�֮�󣬻�Ϊ�����Զ�����һ�����л��汾�ţ�
 * 
 * �����ϣ��ĳ���������л������Ը�������Լӹؼ���transient����ʾ����ģ����������л�����
 * 
 * ���û��û���ֶ�д�������л��汾�ţ�JavaĬ���ṩ���л��汾��
 * @author 13651
 *
 */
public class ObjStudent implements Serializable{
	private static final long serivalVersionUID = 1L; // �ֶ�����һ�����л��汾��
	
	private String num;
	private transient String name; // �����ϣ������������л������Լӹؼ���transient����ʾ�����
	private int age;
	
	// ���л����֮����ӵĴ���
	private int sex;
	
	public ObjStudent() {
		super();
	}
	public ObjStudent(String num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ObjStudent [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
