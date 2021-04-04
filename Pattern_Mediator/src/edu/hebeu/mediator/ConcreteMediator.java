package edu.hebeu.mediator;

import java.util.HashMap;

import edu.hebeu.colleague.Alarm;
import edu.hebeu.colleague.CoffeeMachine;
import edu.hebeu.colleague.Colleague;
import edu.hebeu.colleague.Curtains;
import edu.hebeu.colleague.TV;

/**
 * ������н�����
 * @author 13651
 *
 */
public class ConcreteMediator extends Mediator {
	
	/**
	 * ��HashMap���Ϲ������е�Colleagueͬ����
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

	/*������н�����ĺ��ķ�����
	 * ���ã�
	 * 	1�����ݵõ�����Ϣ����ɶ�Ӧ������
	 * 	2���н��������������Э�����������ͬ�¶����������
	 */
	@Override
	public void getMessage(int stateChange, String colleagueName) {
		if(colleagues.get(colleagueName) instanceof Alarm) { // ������յ����ӷ�������Ϣ
			if(stateChange == 0) {
				((CoffeeMachine) (colleagues.get(inters.get("coffeeMachine")))).startCoffee(); // ���Ȼ�����
				((TV) colleagues.get(inters.get("tv"))).startTV(); // ��������
			} else if(stateChange == 1) {
				((TV) colleagues.get(inters.get("tv"))).stopTV(); // �رյ���
			}
		} else if (colleagues.get(colleagueName) instanceof CoffeeMachine) { // ������յ����Ȼ���������Ϣ
			((Curtains) (colleagues.get(inters.get("curtains")))).upCurtains(); // ����������
		} else if(colleagues.get(colleagueName) instanceof TV) { // ������յ����ӻ���������Ϣ
			
		} else if(colleagues.get(colleagueName) instanceof Curtains) { // ������յ�������������Ϣ
			
		}
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}

}
