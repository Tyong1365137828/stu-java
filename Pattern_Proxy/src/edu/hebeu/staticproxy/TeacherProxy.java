package edu.hebeu.staticproxy;

/**
 * 这个例子演示动态代理模式
 * @author 13651
 *
 */
public class TeacherProxy implements ITeacherDao{
	
	private ITeacherDao target; // 被代理的目标对象
	
	public TeacherProxy(ITeacherDao target) {
		this.target = target;
	}

	@Override
	public String teacher() {
		System.out.println("静态代理开始了...");
		
		String s = target.teacher(); // 调用真正操作的方法
		
		System.out.println("静态代理结束");
		return s;
	}
}
