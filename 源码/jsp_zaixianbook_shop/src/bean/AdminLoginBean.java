package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *管理员登陆通用类
 */
public class AdminLoginBean {
	// 成员变量定义
	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// 记录集对象
	private ResultSet rs;
	//管理员登陆通用类
	public int userLogin(String admin_name,String admin_password){
		String sql="select * from systemadministrator where admin_name ='"+admin_name+"' and admin_password='"+admin_password+"'";
		// 实例连接数据库对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			// 登陆验证
			if(rs.next()){
				// 查找到符合记录,返回查找成功标记
				return this.SUCCESS;
			}
			else{
				// 未查找到符合记录,返回查找失败标记
				return this.ERROR;
			}
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 返回查找失败标记
			return this.ERROR;
		}
		finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	//增加管理员 
	public int addUser(String admin_name,String admin_password){
		String sql="insert into systemadministrator (admin_name,admin_password) values('"+admin_name+"','"+admin_password+"')";
		// 建立数据库对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		//异常处理
		try{
			// 执行SQL语句
			rs=dbo.executeQuery("select * from systemadministrator where admin_name='"+admin_name+"'");
			// 查看是否重名
			if(rs.next()){
				// 返回重名标记
				return this.SAME;
			}
			else{
				// 执行SQL语句
				int i=dbo.executeUpdate(sql);
				if(i==1){ // 执行成功
					return this.SUCCESS;
				}
				else{ // 执行失败
					return this.ERROR;
				}
			}
			
		}catch(Exception e){ // 捕获异常
			// 返回失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 获得用户信息(无参数)-返回所有用户信息
	public List getUser(){
		// 执行SQL语句
		String sql="select admin_id, admin_name from systemadministrator ";
		// 建立数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 数组容器类对象-存放所有用户信息库
		List list=new ArrayList();
		try{
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// 数组容器类对象-中间对象
				List list2=new ArrayList();
				// 将用户ID存入容器类对象
				list2.add(rs.getString(1));
				// 将用户ID存入容器类对象
				list2.add(rs.getString(2));
				// 添加此用户信息到用户信息库
				list.add(list2);
			}
			// 返回用户信息库-数组容器类对象
			return list;
		}catch(Exception e){ // 捕获异常
			// 返回用户信息库-数组容器类对象
			return list;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	// 获得用户信息(有参数)-返回一个指定用户信息
	public List getUser(int admin_id){
		String sql="select admin_id, admin_name,admin_password from systemadministrator where admin_id='"+admin_id+"'";
		// 建立数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 数组容器类对象-存放指定用户信息
		List list=new ArrayList();
		// 异常处理
		try{
			// 执行数据库操作
			rs=dbo.executeQuery(sql);
			rs.next();
			// 接收用户信息
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			// 返回指定用户信息-数组容器类对象
			return list;
		}catch(Exception e){ // 捕获异常
			// 返回指定用户信息-数组容器类对象
			return list;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 删除用户信息
	public int delUser(int admin_id){
		String sql="delete from systemadministrator where admin_id='"+admin_id+"'";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{		
			// 执行SQL语句
			int i=dbo.executeUpdate(sql);
			if(i==1){ // 执行成功
				// 返回执行成功标记
				return this.SUCCESS;
			}
			else{ // 执行失败
				// 返回执行失败标记
				return this.ERROR;
			}
		}catch(Exception e){ // 捕获异常
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 更新指定用户信息
	public int upUser(int admin_id,String admin_name,String admin_password){
		String sql="update systemadministrator set admin_name='"+admin_name+"',admin_password='"+admin_password+"' where admin_id='"+admin_id+"'";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{
			// 执行SQL语句
			int i=dbo.executeUpdate(sql);
			if(i==1){ // 执行成功
				// 返回执行成功标记
				return this.SUCCESS;
			}
			else{ // 执行失败
				// 返回执行失败标记
				return this.ERROR;
			}
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
}


