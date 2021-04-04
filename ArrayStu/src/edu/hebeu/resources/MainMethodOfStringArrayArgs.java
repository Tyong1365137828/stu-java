package edu.hebeu.resources;

/**
 * 这个例子展示main方法的 String[] args 参数的使用
 * @author tyong
 *
 */
public class MainMethodOfStringArrayArgs {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("请输入用户名和密码，如：root tyong");
			return;
		}
		if(args[0].equals("root") & args[1].equals("tyong")) System.out.println("身份验证成功！欢迎您：username = " + args[0] + ", password = " + args[1]);
		else System.out.println("身份验证失败！");
	}
}
