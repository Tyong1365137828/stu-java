package edu.hebeu.extend.deepcopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepProtoType implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name; //String �� ��
	public DeepCloneableTarget deepCloneableTarget;// ��������
	
	public DeepProtoType() {
		super();
	}

	// ���ʵ�ֵĵ�һ�ַ�ʽ
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object objClone = null;
		// ������Ƚ� DeepProtoTypeʵ���� �����������ͺ�String���ͽ��п�¡
		objClone = super.clone();
		
		// ���ｫ�������ͽ��п�¡
		DeepProtoType deepProtoTypeClone = (DeepProtoType) objClone;
		deepProtoTypeClone.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
		
		return deepProtoTypeClone;
	}
	
	// �����ʵ�֣�ͨ���ڶ��ַ�ʽ(�Ƽ�ʹ�����ַ�ʽ)����������л��ͷ����л�ʵ�����¡
	public Object deepClone() {
		
		// ������¡�Ķ���
		DeepProtoType deepProtoType = null;
		
		// ����Ҫʹ�õ�������
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		
		try {
			
			// ���л�
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(this);// ���������л�
			
			// �����л�
			bais = new ByteArrayInputStream(baos.toByteArray());
			ois = new ObjectInputStream(bais);
			deepProtoType = (DeepProtoType) ois.readObject(); // �����л��Ķ������л����������������
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bais != null) {
				try {
					bais.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deepProtoType;
	}
	
	
}
