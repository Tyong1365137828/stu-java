package edu.hebeu.resources;

/**
 * 这个例子展示数组的扩容
 * @author 13651
 *
 */
public class ArrayCopy {
	public static void main(String[] args) {
		int[] srcArray = {1, 5, 1, 8, 9}; // 拷贝源数组
		int[] destArray = new int[10]; // 拷贝目标数组
		/*进行数组的拷贝，
		 * 参数1：拷贝源数组
		 * 参数2：从原数组的第几个下标开始拷贝
		 * 参数3：拷贝目标数组
		 * 参数4：将拷贝元素拷贝至从目标数组的第几个下标
		 * 参数5：拷贝的长度*/
		System.arraycopy(srcArray, 2, destArray, 4, 2);
		
		for(int i = 0; i < destArray.length; i++) {
			System.out.print(destArray[i] + ", ");
		}
	}
}
