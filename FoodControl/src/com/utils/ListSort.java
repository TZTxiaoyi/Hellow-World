
/**     
 * @文件名称: ListSort.java  
 * @类路径: com.utils  
 * @描述: TODO  
 * @作者：TZT  
 * @时间：2017-6-24 下午7:57:56  
 * @版本：V1.0     
 */  
package com.utils;

import java.util.ArrayList;
import java.util.List;

/**  
 * @类功能说明：  数组链表中对应下标的两个元素替换位置
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-24 下午7:57:56  
 * @版本：V1.0  
 */
public class ListSort {
	public static void ListSort(List lista,int a,int b){
		
			if(a>b){
				int c=0;
				c=a;
				a=b;
				b=c;
			}
		//3  5 换位   2 和4交换
		lista.add(a,lista.get(b));
		lista.add(b+1,lista.get(a+1));
		lista.remove(a+1);
		lista.remove(b+1);
	}
}
