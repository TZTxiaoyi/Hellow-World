
/**     
 * @�ļ�����: Test.java  
 * @��·��: com.achaction  
 * @����: TODO  
 * @���ߣ�TZT  
 * @ʱ�䣺2017-6-24 ����8:12:33  
 * @�汾��V1.0     
 */  
package com.achaction;

import java.util.ArrayList;
import java.util.List;

import com.utils.ListSort;

/**  
 * @�๦��˵����  
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-24 ����8:12:33  
 * @�汾��V1.0  
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
