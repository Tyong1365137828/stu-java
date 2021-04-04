package edu.hebeu;

import edu.hebeu.colleague.Alarm;
import edu.hebeu.colleague.CoffeeMachine;
import edu.hebeu.colleague.Curtains;
import edu.hebeu.colleague.TV;
import edu.hebeu.mediator.ConcreteMediator;
import edu.hebeu.mediator.Mediator;

public class Client {
	public static void main(String[] args) {
		
		// �����н��߶���
		Mediator mediator = new ConcreteMediator();
		
		// ����ͬ�������ע�⣺�ڴ�����Ὣ������뵽�н��߶�����
		Alarm alarm = new Alarm(mediator, "al");
		CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffee");
		Curtains curtains = new Curtains(mediator, "cu");
		TV tv = new TV(mediator, "tv");
		
		alarm.sendAlarm(0); // ���Ӷ��󷢳���Ϣ
		System.out.println("---------------------------------------------------------");
		coffeeMachine.stopCoffee();
		System.out.println("---------------------------------------------------------");
		alarm.sendAlarm(1);
	}
}
