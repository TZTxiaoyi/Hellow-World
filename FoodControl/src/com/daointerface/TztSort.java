
/**     
 * @文件名称: TztSort.java  
 * @类路径: com.daointerface  
 * @描述: TODO  
 * @作者：TZT  
 * @时间：2017-6-22 下午3:05:59  
 * @版本：V1.0     
 */  
package com.daointerface;

import java.util.List;

/**  
 * @类功能说明：  
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-22 下午3:05:59  
 * @版本：V1.0  
 */
public interface TztSort {
	public List queryMade();
	public List queryMading();
	public List made(int dishId);
	public List mading(int dishId);
}
