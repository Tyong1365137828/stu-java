package edu.hebeu.objectstream;

import java.io.Serializable;

/**
 * 学生类
 * 	注意：通过源代码发现，Serializable接口只是一个标志接口，内部什么代码也没有，起到标识符作用，Java虚拟机可能会对这个类特殊待遇；
 * Serializable这个接口是给Java虚拟机参考的，Java虚拟机看到这个接口之后，会为该类自动生成一个序列化版本号；
 * 
 * 如果不希望某个属性序列化，可以给这个属性加关键字transient，表示游离的，不参与序列化操作
 * 
 * 如果没有没有手动写出来序列化版本号，Java默认提供序列化版本号
 * @author 13651
 *
 */
public class ObjStudent implements Serializable{
	private static final long serivalVersionUID = 1L; // 手动生成一个序列化版本号
	
	private String num;
	private transient String name; // 如果不希望这个属性序列化，可以加关键字transient，表示游离的
	private int age;
	
	// 序列化完成之后添加的代码
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
