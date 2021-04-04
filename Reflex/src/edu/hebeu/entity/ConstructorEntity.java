package edu.hebeu.entity;

import java.util.Date;

/**
 * 这个例子供测试反射构造方法使用
 * @author 13651
 *
 */
public class ConstructorEntity {
	private int num;
	private boolean sex;
	private String name;
	private Date birthday;
	
	public ConstructorEntity() {
		super();
	}
	
	public ConstructorEntity(int num) {
		super();
		this.num = num;
	}

	public ConstructorEntity(int num, boolean sex) {
		super();
		this.num = num;
		this.sex = sex;
	}

	public ConstructorEntity(int num, boolean sex, String name) {
		super();
		this.num = num;
		this.sex = sex;
		this.name = name;
	}

	public ConstructorEntity(int num, boolean sex, String name, Date birthday) {
		super();
		this.num = num;
		this.sex = sex;
		this.name = name;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "ConstructorEntity [num=" + num + ", sex=" + sex + ", name=" + name + ", birthday=" + birthday + "]";
	}
	
}
