package edu.hebeu.mediator;

import java.util.HashMap;

import edu.hebeu.colleague.Alarm;
import edu.hebeu.colleague.CoffeeMachine;
import edu.hebeu.colleague.Colleague;
import edu.hebeu.colleague.Curtains;
import edu.hebeu.colleague.TV;

/**
 * 具体的中介者类
 * @author 13651
 *
 */
public class ConcreteMediator extends Mediator {
	
	/**
	 * 该HashMap集合管理所有的Colleague同事类
	 */
	private HashMap<String, Colleague> colleagues;
	private HashMap<String, String> inters;
	
	public ConcreteMediator() {
		colleagues = new HashMap<>();
		inters = new HashMap<>();
	}

	@Override
	public void register(String colleagueName, Colleague colleague) {
		colleagues.put(colleagueName, colleague);
		
		if(colleague instanceof Alarm) {
			inters.put("alarm", colleagueName);
		} else if(colleague instanceof CoffeeMachine) {
			inters.put("coffeeMachine", colleagueName);
		} else if(colleague instanceof TV) {
			inters.put("tv", colleagueName);
		} else if(colleague instanceof Curtains) {
			inters.put("curtains", colleagueName);
		}
	}

	/*具体的中介者类的核心方法：
	 * 作用：
	 * 	1、根据得到的消息，完成对应的任务；
	 * 	2、中介者在这个方法，协调各个具体的同事对象，完成任务
	 */
	@Override
	public void getMessage(int stateChange, String colleagueName) {
		if(colleagues.get(colleagueName) instanceof Alarm) { // 如果接收到闹钟发出的消息
			if(stateChange == 0) {
				((CoffeeMachine) (colleagues.get(inters.get("coffeeMachine")))).startCoffee(); // 咖啡机开启
				((TV) colleagues.get(inters.get("tv"))).startTV(); // 开启电视
			} else if(stateChange == 1) {
				((TV) colleagues.get(inters.get("tv"))).stopTV(); // 关闭电视
			}
		} else if (colleagues.get(colleagueName) instanceof CoffeeMachine) { // 如果接收到咖啡机发出的消息
			((Curtains) (colleagues.get(inters.get("curtains")))).upCurtains(); // 将窗帘挂起
		} else if(colleagues.get(colleagueName) instanceof TV) { // 如果接收到电视机发出的消息
			
		} else if(colleagues.get(colleagueName) instanceof Curtains) { // 如果接收到窗帘发出的消息
			
		}
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}

}
