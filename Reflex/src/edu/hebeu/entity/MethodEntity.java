package edu.hebeu.entity;

/**
 * 这个例子供测试反射方法使用
 * @author 13651
 *
 */
public class MethodEntity {
	
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功 ? true : false
	 */
	public boolean login(String username, String password) {
		if("1365137828".equals(username) && "0727316052".equals(password)) return true;
		/**程序执行到此，说明用户名或密码不正确，即登录失败*/
		return false;
	}
	
	/**
	 * 退出方法
	 */
	public void exit() {
		System.out.println("成功退出!");
	}
	
}
