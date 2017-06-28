
/**     
 * @文件名称: Test.java  
 * @类路径: com.achaction  
 * @描述: TODO  
 * @作者：TZT  
 * @时间：2017-6-24 下午8:12:33  
 * @版本：V1.0     
 */  
package com.achaction;

import java.util.ArrayList;
import java.util.List;

import com.utils.ListSort;

/**  
 * @类功能说明：  
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-24 下午8:12:33  
 * @版本：V1.0  
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		System.out.println(list);
		ListSort.ListSort(list,2,6);
		System.out.println(list);

	}


}
