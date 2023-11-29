package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 新闻信息类
 */
public class NewsBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// 记录集对象
	private ResultSet rs;
	
	// 删除新闻信息
	public int delNews(int id[]){
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{			
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from webnews where webnews_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ // 捕获异常
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 添加新闻信息
	public int addNews(String webnews_title,String webnews_content,String webnews_sender){
		String sql="insert into webnews (webnews_title,webnews_content,webnews_sendtime,webnews_sender) values('"+webnews_title+"','"+webnews_content+"','"+new java.util.Date().toLocaleString()+"','"+webnews_sender+"')";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{			
			// 执行SQL语句
			int i=dbo.executeUpdate(sql);
			if(i==1){ //执行成功
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
	
	// 更新指定ID的新闻信息
	public int upNews(int webnews_id,String webnews_title,String webnews_content){
		String sql="update webnews set webnews_title='"+webnews_title+"',webnews_content='"+webnews_content+"' where webnews_id='"+webnews_id+"'";
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
		}catch(Exception e){ //捕获异常
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 获取数据库中，指定ID的新闻信息
	public List getNews(int webnews_id){
		String sql="select webnews_title ,webnews_content from webnews where webnews_id='"+webnews_id+"'";
        // 创建数据库连接对象
		DBO dbo=new DBO();
		// 数组容器类对象-存放所有新闻信息库
		List list=new ArrayList();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{		
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			rs.next();
			// 获取此新闻信息
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			// 返回新闻信息内容
			return list;
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 执行SQL语句
			return list;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
}
