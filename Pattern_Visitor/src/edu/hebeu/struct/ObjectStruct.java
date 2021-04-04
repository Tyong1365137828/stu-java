package edu.hebeu.struct;

import java.util.LinkedList;
import java.util.List;

import edu.hebeu.element.Person;
import edu.hebeu.visitor.Action;

public class ObjectStruct {
	
	private List<Person> persons = new LinkedList<>();
	
	/**
	 * ��ӹ��ڵ�����
	 * @param person
	 */
	public void addPerson(Person person) {
		persons.add(person);
	}
	
	/**
	 * ɾ�����ڵ�����
	 * @param person
	 */
	public void removePerson(Person person) {
		persons.remove(person);
	}
	
	/**
	 * ͨ�����۵�������ʾ���й��ڵ�����
	 * @param action
	 */
	public void displyAppraise(Action action) {
		for (Person person : persons) {
			person.accept(action);
		}
	}
}
