package edu.hebeu.struct;

import java.util.LinkedList;
import java.util.List;

import edu.hebeu.element.Person;
import edu.hebeu.visitor.Action;

public class ObjectStruct {
	
	private List<Person> persons = new LinkedList<>();
	
	/**
	 * 添加观众的类型
	 * @param person
	 */
	public void addPerson(Person person) {
		persons.add(person);
	}
	
	/**
	 * 删除观众的类型
	 * @param person
	 */
	public void removePerson(Person person) {
		persons.remove(person);
	}
	
	/**
	 * 通过评论的类型显示所有观众的评论
	 * @param action
	 */
	public void displyAppraise(Action action) {
		for (Person person : persons) {
			person.accept(action);
		}
	}
}
