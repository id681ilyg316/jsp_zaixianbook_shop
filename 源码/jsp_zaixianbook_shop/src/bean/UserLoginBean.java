package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 普通用户登陆通用类
 */
public class UserLoginBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	private ResultSet rs;
	//用户登陆通用类
	public int userLogin(String member_loginname,String member_password){
		String sql="select * from commonmember where member_loginname ='"+member_loginname+"' and member_password='"+member_password+"'";
		// 控制台输出语句-测试
		System.out.println(sql);
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			// 登陆验证
			if(rs.next()){ // 执行成功
				return this.SUCCESS;
			}
			else{ // 执行失败
				return this.ERROR;
			}
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 返回执行失败标记
			return this.ERROR;
		}
		finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	//新用户注册 
	public int regUser(String member_loginname,String member_password,String member_name,String member_sex,String member_email,String member_tel){
		String sql="insert into commonmember (member_loginname,member_password,member_truename,member_sex,member_email,member_tel,member_level) values('"+member_loginname+"','"+member_password+"','"+member_name+"','"+member_sex+"','"+member_email+"','"+member_tel+"','0')";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{
			// 执行SQL语句
			rs=dbo.executeQuery("select * from commonmember where member_loginname='"+member_loginname+"'");
			// 查看是否重名
			if(rs.next()){ // 有重名
				System.out.println("有重名");
				return this.SAME;
			}
			else{ // 无重名
				// 执行SQL语句
				System.out.println("无重名");
				System.out.println(sql);
				int i=dbo.executeUpdate(sql);
				System.out.println("----");
				System.out.println("reg"+i);
				if(i==1){ // 执行成功
					return this.SUCCESS;
				}
				else{ // 执行失败
					return this.ERROR;
				}
			}
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 返回执行失败标记
			return this.ERROR;
		}finally{  // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 获取所有用户信息
	public List getUser(){
		String sql="select * from commonmember ";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 数组容器类对象-存放所有普通用户信息库
		List list=new ArrayList();
		try{
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// 数组容器类对象-中间对象
				List list2=new ArrayList();
				// 获取此普通用户信息
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list2.add(rs.getString(11));
				list2.add(rs.getString(12));
				list2.add(rs.getString(13));
				// 将此普通用户信息添加到信息库
				list.add(list2);
			}
			// 返回所有普通用户信息库
			return list;
		}catch(Exception e){ // 捕获异常
			// 返回所有普通用户信息库
			return list;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 添加管理员
	public int addManager(String admin_name,String admin_password){
		String sql="insert into systemadministrator (admin_name,admin_password,admin_addtime) values('"+admin_name+"','"+admin_password+"','"+new java.util.Date().toLocaleString()+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery("select * from systemadministrator where admin_name='"+admin_name+"'");
			// 查看是否重名
			if(rs.next()){
				return this.SAME;
			}
			else{
				int i=dbo.executeUpdate(sql);
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	
	// 获取指定ID的管理员信息
	public List getManager(int admin_id){
		String sql="select * from systemadministrator where admin_id='"+admin_id+"'";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			list.add(rs.getString(4));
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 修改管理员密码
	public int upManager(int admin_id,String admin_password){
		String sql="update systemadministrator set admin_password='"+admin_password+"' where admin_id='"+admin_id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{		
				int i=dbo.executeUpdate(sql);
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}			
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	
	// 获取所有管理员信息
	public List getAllManager(){
		String sql="select * from systemadministrator ";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 删除指定ID的管理员信息
	public int delManager(int admin_id){
		String sql="delete from systemadministrator where admin_id='"+admin_id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{			
			int i=dbo.executeUpdate(sql);
			if(i==1){
				return this.SUCCESS;
			}
			else{
				return this.ERROR;
				}
		}catch(Exception e){
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	
	// 删除指定ID的普通用户信息
	public int delUser(int id[]){
		
		DBO dbo=new DBO();
		dbo.open();
		try{			
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from  commonmember   where  member_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	
	// 获取指定用户名称的普通用户信息
	public List getUser(String member_loginname){
		String sql="select * from commonmember where member_loginname='"+member_loginname+"'";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			list.add(rs.getString(4));
			list.add(rs.getString(5));
			list.add(rs.getString(6));
			list.add(rs.getString(7));
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 修改指定用户名称的普通用户信息
	public int upUser(String member_loginname,String member_password,String member_truename,String member_sex,String member_email,String member_tel){
		String sql="update commonmember set member_password='"+member_password+"', member_truename='"+member_truename+"',member_sex='"+member_sex+"',member_email='"+member_email+"',member_tel='"+member_tel+"' where member_loginname='"+member_loginname+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			int i=dbo.executeUpdate(sql);
			if(i==1){
				return this.SUCCESS;
			}
			else{
				return this.ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	
	// 获取指定用户名称的普通用户的级别(通过累计消费金额判别)
	public String getJiBie(String member_loginname){
		String sql="select member_level from commonmember where member_loginname='"+member_loginname+"'";
		System.out.println(sql);
		DBO dbo=new DBO();
		dbo.open();
		String str=null;
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			float f=rs.getFloat(1);
			if(f<1000){
				str="普通";
			}
			else if(f>1000&&f<2000){
				str="银卡";
			}
			else if(f>2000){
				str="金卡";
			}
			return str;
		}catch(Exception e){
			e.printStackTrace();
			return "普通";
		}finally{
			dbo.close();
		}
	}
	
	// 通过"用户名称"和"电子邮件"找会普通用户的密码
	public int getMiMa(String member_loginname,String member_email){
		String sql="select * from commonmember where member_loginname='"+member_loginname+"' and member_email='"+member_email+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){//登陆验证
				int i=dbo.executeUpdate("update commonmember set member_password='123456' where member_loginname='"+member_loginname+"'");
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}
			}
			else{
				return this.SAME;
			}
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}
		finally{
			dbo.close();
		}
	}
}



