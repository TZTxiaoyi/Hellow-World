
/**     
 * @�ļ�����: ListSort.java  
 * @��·��: com.utils  
 * @����: TODO  
 * @���ߣ�TZT  
 * @ʱ�䣺2017-6-24 ����7:57:56  
 * @�汾��V1.0     
 */  
package com.utils;

import java.util.ArrayList;
import java.util.List;

/**  
 * @�๦��˵����  ���������ж�Ӧ�±������Ԫ���滻λ��
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-24 ����7:57:56  
 * @�汾��V1.0  
 */
public class ListSort {
	public static void ListSort(List lista,int a,int b){
		
			if(a>b){
				int c=0;
				c=a;
				a=b;
				b=c;
			}
		//3  5 ��λ   2 ��4����
		lista.add(a,lista.get(b));
		lista.add(b+1,lista.get(a+1));
		lista.remove(a+1);
		lista.remove(b+1);
	}
}
