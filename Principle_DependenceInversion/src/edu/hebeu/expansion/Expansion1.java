package edu.hebeu.expansion;

/**
 * 这个类演示依赖关系传递的三种方式
 * @author 13651
 *
 */
public class Expansion1 {

	public static void main(String[] args) {
		// 测试方式一
		OpenAndClose1 openAndClose1 = new OpenAndClose1();
		openAndClose1.open(new ChangHong());
		
		
		// 测试方式二
		OpenAndClose2 openAndClose2 = new OpenAndClose2(new HaiXin());
		openAndClose2.open();
		
		// 测试方式三
		OpenAndClose3 openAndClose3 = new OpenAndClose3();
		openAndClose3.setTv3(new LianXiang());
		openAndClose3.open();
		
	}
}

// 依赖传递的第一种方式：通过接口实现依赖传递
interface IOpenAndClose1 {
	void open(ITV1 tv); // 接收接口
}

interface ITV1 {
	void play();
}

class ChangHong implements ITV1 {

	@Override
	public void play() {
		System.out.println("长虹正在播放...");
	}	
}

class OpenAndClose1 implements IOpenAndClose1 { // 实现接口

	@Override
	public void open(ITV1 tv) {
		System.out.println("通过遥控器打开了ITV1...");
		tv.play();
	}
}



// 依赖传递的第二种方式，通过构造方法实现依赖传递
interface IOpenAndClose2 {
	void open();
}

interface ITV2 {
	void play();
}

class HaiXin implements ITV2 {

	@Override
	public void play() {
		System.out.println("海信正在播放...");
	}
}

class OpenAndClose2 implements IOpenAndClose2 {
	
	private ITV2 tv2;
	
	public OpenAndClose2(ITV2 tv2) {
		this.tv2 = tv2;
	}

	@Override
	public void open() {
		System.out.println("通过遥控器打开了ITV2...");
		tv2.play();
	}
}



// 依赖传递的第三种方式，通过setter方式实现依赖传递
interface IOpenAndClose3 {
	void open();
	void setTv3(ITV3 tv3);
}

interface ITV3 {
	void play();
}

class LianXiang implements ITV3 {

	@Override
	public void play() {
		System.out.println("联想正在播放...");
	}
}

class OpenAndClose3 implements IOpenAndClose3 {
	private ITV3 tv3;

	@Override
	public void open() {
		System.out.println("通过遥控器打开了ITV3...");
		tv3.play();
	}

	@Override
	public void setTv3(ITV3 tv3) {
		this.tv3 = tv3;
	}
}
