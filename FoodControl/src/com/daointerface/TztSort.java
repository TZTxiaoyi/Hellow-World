
/**     
 * @�ļ�����: TztSort.java  
 * @��·��: com.daointerface  
 * @����: TODO  
 * @���ߣ�TZT  
 * @ʱ�䣺2017-6-22 ����3:05:59  
 * @�汾��V1.0     
 */  
package com.daointerface;

import java.util.List;

/**  
 * @�๦��˵����  
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-22 ����3:05:59  
 * @�汾��V1.0  
 */
public interface TztSort {
	public List queryMade();
	public List queryMading();
	public List made(int dishId);
	public List mading(int dishId);
}
