package edu.hebeu.bridging;

import edu.hebeu.bridging.abstraction.ButtonPhone;
import edu.hebeu.bridging.abstraction.PhoneBridge;
import edu.hebeu.bridging.abstraction.SildePhone;
import edu.hebeu.bridging.abstraction.SmartPhone;
import edu.hebeu.bridging.implementor.HuaWei;
import edu.hebeu.bridging.implementor.IPhone;
import edu.hebeu.bridging.implementor.XiaoMi;

public class Client {
	public static void main(String[] args) {
		PhoneBridge phone = null;
		
		phone = new ButtonPhone(new XiaoMi()); // ʹ�ð�����С���ֻ�
		phone.open();
		phone.call();
		phone.internet();
		phone.close();
		
		System.out.println("-----------------------------------------------------");
		
		phone = new SmartPhone(new HuaWei()); // ʹ�����ܵĻ�Ϊ�ֻ�
		phone.open();
		phone.call();
		phone.internet();
		phone.close();
		
		System.out.println("-----------------------------------------------------");
		
		phone = new SildePhone(new IPhone()); // ʹ�û��ǵ�IPhone�ֻ�
		phone.open();
		phone.call();
		phone.internet();
		phone.close();
		
	}
}
