package edu.hebeu.tang.mouse;

			//这是主人类，它将用不同的老鼠来试酒
public class Master {

	/* 
	 * 
	 * 试酒的方法，该方法接受Mouse类的参数，并调用Mouse的drink
	 *  mouse  试酒的老鼠
	 **/
	public void feedingVino(Mouse mouse) {
		System.out.println("主人倒满一杯酒");
		mouse.drink();
		
	}
}
