package edu.hebeu.aboutpath;

import java.util.ResourceBundle;

/**
 * 这个例子讲解Sun公司提供的ResourceBundle资源绑定器的使用
 * 	ResourceBundle：
 * 		在java.util包下；
 * 		使用这种方式获取资源时的要求:
 * 			1、这个文件必须是以properties结尾的；
 * 			2、这个文件必须在类路径下(src下)；
 * 			3、加载xxx.properties文件时，写路径只能写到 xxx，后缀 properties不能写；
 * 
 * @author 13651
 *
 */
public class ResourceBundleStu {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("info\\classInfo"); // 注意写到文件的名字就行了，不能写后缀
		
		String classInfoOfClassName = bundle.getString("className"); // 通过properties文件的 = 左边的属性值(key)，获取 = 右边的属性值(value)
		System.out.println(classInfoOfClassName);
		
	}
}
