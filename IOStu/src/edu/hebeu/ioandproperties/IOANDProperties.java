package edu.hebeu.ioandproperties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties和IO的联合使用;
 * 
 * 引出概念：
 * 	设计开发理念：
 * 		以后经常改变的数据，可以单独写到一个文件中，使用程序动态读取；
 * 	  将来在进行修改时只要修改文件的内容，不用更改Java代码，不需要重新编译，部署服务器即可拿到修改后的信息；
 * 
 * 类似于上述的文件是配置文件，并且当文件内容是：
 * 		key1=value1
 * 		key2=value2
 * 的时候，我们称为属性配置文件，建议属性配置文件以 properties结尾(但不是必须的)，其中Properties Map集合是专门存储属性配置文件内容的；
 * 
 * 属性配置文件中：
 * 		# 是注释；
 * 		key重复，value会自动覆盖；
 * 		以等号为界，等号左边是key，右边是value；
 * 		等号两边可以又空格(最好不要有空格)；
 * @author 13651
 *
 */
public class IOANDProperties {
	public static void main(String[] args) {
		FileReader fr = null;
		
		try {
			fr = new FileReader("data\\properties\\dataBaseInfo");
			
			Properties properties = new Properties(); // 创建Properties的Map集合
			properties.load(fr); // 将流通过Properties的load()方法加载到Properties集合
			/**Properties集合的key和value都要求是String类型，并且传入的流以等号为分割线，等号左边做key，右边做value，key重复，value覆盖！！*/
			
			String uName = properties.getProperty("username");
			String pwd = properties.getProperty("password");
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			
			System.out.println("用户名：" + uName + "; 密码：" + pwd + "; 驱动：" + driver + "; URL：" + url);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
