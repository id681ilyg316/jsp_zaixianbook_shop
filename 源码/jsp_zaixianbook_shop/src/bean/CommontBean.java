package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 评论信息类
 */
public class CommontBean {

	private static int SUCCESS=1;
	private static int DATABASE_ERROR=2;
	// 记录集对象
	private ResultSet rs;
	// 数组容器类对象
	private List list=new ArrayList();
	
	//增加评论信息
	public int addCommon(String bookcomment_content,String bookcomment_sender,int bookcomment_bookid){
		String sql="insert into bookcomment (bookcomment_content,bookcomment_sender,bookcomment_sendtime,bookcomment_bookid) values('"+bookcomment_content+"','"+bookcomment_sender+"','"+new java.util.Date().toLocaleString()+"','"+bookcomment_bookid+"')";
		System.out.println("sql=" +sql);
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
				return this.DATABASE_ERROR;
			}
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 返回执行失败标记
			return this.DATABASE_ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	//删除评论信息
	public int delCommon(int bookcomment_id[]){
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{
			for(int j=0;j<bookcomment_id.length;j++){
				// 执行SQL语句
				dbo.executeUpdate("delete from bookcomment where bookcomment_id='"+bookcomment_id[j]+"'");
			}
			// 返回执行成功
			return this.SUCCESS;
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			return this.DATABASE_ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
}
