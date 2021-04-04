package edu.hebeu.util;

import java.util.List;
/**
* 分页的三个基本属性
* 1.每页几条记录size  可以有默认值5
* 2.当前页号  index   可以有默认值1    [1]  2  3  4    1 [2] 3  4
* 3.记录总数totalCount：不可能有默认值，需要查询数据库获取真正的记录总数
* 
* 下面这几个属性是计算出来的
* 4.一共多少页 ：totalPageCount=totalCount/size+1
* 		5  30  31 32 33 34 35  
* 5.上一页    index-1  当前页1，上一页1
* 6.下一页   index+1  当前页是最后一页  下一页：还是最后一页
* 
* 扩展
* 分页Bean还可以放要查询的数据  protected List<T> list; * 分页Bean还可以放页码列表     [1]  2  3  4  5   private int[] numbers;
* 
*/
//页面的所有内容都在PageBean中，封装度较高。

public class PageBean<T> {//表示泛型
	
	//这两个变量必须要有初值
	private int size = 5;//每页显示记录,默认是5
	private int index = 1;// 当前页号,默认是1
	
	//这四个变量的"初值"是由上述两个初值和总记录数计算出来的
	private int totalCount = 0;// 记录总数,默认是0,并非初值
	private int totalPageCount = 1;// 总页数(由总记录数"totalCount"除以每页显示记录"size",余数再加1得到),默认为1,并非初值
		
	private int[] numbers;//展示页数集合 
	protected List<T> list;//要显示到页面的数据集  
   
	/**
	 * 得到开始记录
	 */
	public int getStartRow() {

		return (index - 1) * size;
	}

	/**
	 * 得到结束记录
	 */
	public int getEndRow() {
		
		return index * size;
	}

	/**
	 * @return Returns the size.
	 */
	public int getSize() {		
		return size;
	}

	/**
	 * @param size
	 * The size to set.
	 */
	public void setSize(int size) {
		if (size > 0) {
			this.size = size;
		}
	}
	/**
	 * @return Returns the currentPageNo.
	 */
	public int getIndex() {
		if (totalPageCount == 0) {
			
			return 0;
		}
		
		return index;
	}

	/**
	 * @param currentPageNo
	 * The currentPageNo to set.
	 */
	public void setIndex(int index) {
		if (index > 0) {
			this.index = index;
		}
	}

	/**
	 * @return Returns the totalCount.
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *  The totalCount to set.
	 *  这是一个起点方法,只要传进去总记录数就连锁反应,把所有值都计算出来
	 */
	public void setTotalCount(int totalCount) {
		if (totalCount >= 0) {
			this.totalCount = totalCount;//获得总记录数
			setTotalPageCountByRs();//根据总记录数计算总页数
		}
	}

	
	public int getTotalPageCount() {
		return this.totalPageCount;
	}

	/**
	 * 根据总记录数计算总页数
	 * 5 	 
	 * 20    4
	 * 23    5
	 */
	private void setTotalPageCountByRs() {
		if (this.size > 0 && this.totalCount > 0 && this.totalCount % this.size == 0) {
			this.totalPageCount = this.totalCount / this.size;
		} else if (this.size > 0 && this.totalCount > 0 && this.totalCount % this.size > 0) {
			this.totalPageCount = (this.totalCount / this.size) + 1;
		} else {
			this.totalPageCount = 0;
		}
		setNumbers(totalPageCount);//获取展示页数集合
	}

	public int[] getNumbers() {
		return numbers;
	}
	
	/**
	 * 设置显示页数集合
	 * 
	 * 默认显示10个页码
	 * 41  42  43  44    [45 ]   46  47  48  49  50
	 * 	 
	 *  1 2  3 [4]  5 6 7 8  9  10
	 *  
	 *  41  42  43  44    45    46  47  [48]  49  50
	 * @param totalPageCount
	 */
	public void setNumbers(int totalPageCount) {
		if(totalPageCount>0){
			//!.当前数组的长度
			int[] numbers = new int[totalPageCount>10?10:totalPageCount];//页面要显示的页数集合
			int k =0;
			//1.数组长度<10   1 2 3 4 ....   7
			//2.数组长度>=10
			//     当前页<=6  1 2 3 4    10
			//     当前页>=总页数-5           ......12 13 14 15  
			//     其他        5  6  7 8   9 当前页(10)  10  11 12  13
			for(int i = 0;i < totalPageCount;i++){
				//保证当前页为集合的中间
				if((i>=index- (numbers.length/2+1) || i >= totalPageCount-numbers.length) && k<numbers.length){
					numbers[k] = i+1;
					k++;
				}else if(k>=numbers.length){
					break;
				}				
			}
			this.numbers = numbers;
		}
	}
	
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
