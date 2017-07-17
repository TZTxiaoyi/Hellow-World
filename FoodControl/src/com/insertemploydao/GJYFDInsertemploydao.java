package com.insertemploydao;

import java.util.List;

import com.entity.GJYFoodCategory;
import com.entity.GJYKIDCategory;
import com.utils.DaoFactory;

public class GJYFDInsertemploydao {
	/*删除菜品*/
	public int delect(GJYKIDCategory KID){
		System.out.println("delect");
		String sql="update kind set kindState=20 where kindId=?";
		System.out.println(KID.getKidID());
		Object[] params=new Object[]{KID.getKidID()};
		return DaoFactory.Updata(sql, params);	
	}
	
	
	
	/*添加菜品*/
	public int insert(GJYKIDCategory KID){
		System.out.println("insert");
		String sql="insert into kind values(?,?)";
		Object[] params=new Object[]{KID.getKidname(),KID.getKidState()};
		return DaoFactory.Updata(sql, params);	
	}
	
	
	/*查询菜品*/
	public List sekKID(String ser) {
		String sql ="select Top(5) kindId,kindName " +
					"from kind where kindId not in"+
					"(select top(0*5)  kindId from kind) and (kindId like '%"+ser+"%'or kindName like '%"+ser+"%')"+"and kindState=19";
		List list = DaoFactory.Query(sql);
		System.out.println(list);
		return list;
	
	}

	/*修改菜品*/
	public int Change(GJYKIDCategory KID){
		String sql="update kind set kindName=? where kindId=?";
		Object[] params=new Object[]{KID.getKidname(),KID.getKidID()};
		return DaoFactory.Updata(sql,params);	
		
	}
	
	
	
	
	/* 返回总页码数*/
	public int getallpage(){
		String sql="select count(*) from kind where kindState=19";
		List list =DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		int li=(Integer) list1.get(0);
		return li;
	}
	
	/*返回该页码的结果*/
	public List pagepage(int startIndex){
	
		
		String sql="select top (2) kindId,kindName from kind  where KindId not in (select top("+startIndex+"*2)k1.kindId from kind k1) and kindState=19 order by kindId asc";
		return DaoFactory.Query(sql);
	}

	
	public List getselect(GJYKIDCategory KID){
		
		String sql="select kindId,kindName from kind where kindState=19 order by kindId asc";
		return DaoFactory.Query(sql);

	}
	
	public List getestiName(GJYKIDCategory KID){
		String sql="select kindName from kind where kindName= '"+KID.getKidname()+"' group by kindName";
		return DaoFactory.Query(sql);
		
	}
}

	


