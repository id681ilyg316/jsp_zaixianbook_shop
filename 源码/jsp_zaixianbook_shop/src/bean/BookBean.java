package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 书籍信息类
 */
public class BookBean {
	// 成员变量定义
	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// 记录集对象
	private ResultSet rs;
	// 获取书籍分类信息
	public List getFenLei(){
		String sql="select * from bookclassification order by bookclass_id desc";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 数组容器类对象-存放所有书籍分类信息库
		List list=new ArrayList();
		// 异常处理
		try{
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// 数组容器类对象-中间对象
				List list2=new ArrayList();
				// 接收此书籍分类信息
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				// 将此书籍分类信息加入到书籍信息库
				list.add(list2);
			}
			// 返回书籍分类信息库
			return list;
		}catch(Exception e){ //捕获异常
			// 返回书籍分类信息库
			return list;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 添加分类信息
	public int addFenLei(String bookclass_classification){
		String sql="insert into bookclassification (bookclass_classification,bookclass_addtime) values('"+bookclass_classification+"','"+new java.util.Date().toLocaleString()+"')";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{
			// 执行SQL查询语句
			rs=dbo.executeQuery("select * from bookclassification where bookclass_classification='"+bookclass_classification+"'");
			// 查看是否重名
			if(rs.next()){ // 有重名
				// 返回重名标记
				return this.SAME;
			}
			else{ //无重名
				// 执行SQL更新操作-添加
				int i=dbo.executeUpdate(sql);
				if(i==1){ //添加成功
					// 返回执行成功标记
					return this.SUCCESS;
				}
				else{ //添加失败
					// 返回执行失败标记
					return this.ERROR;
				}
			}			
		}catch(Exception e){ //捕获异常
			e.printStackTrace();
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 删除分类信息
	public int delFenLei(int id[]){
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 捕获异常
		try{			
			// 执行SQL语句-删除
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from bookclassification where bookclass_id='"+id[j]+"'");			
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
	
	// 删除书籍信息
	public int delBook(int id[]){
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		try{			
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from bookinformation where book_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //捕获异常
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 设置指定书籍为"最新"分类图书
	public int setNew(int id[]){
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{		
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update bookinformation set book_type='最新' where book_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //异常处理
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 设置指定书籍为"特价"分类图书
	public int setTeJia(int id[]){
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{	
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update bookinformation set book_type='特价' where book_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //捕获异常
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 设置指定书籍为"普通"分类图书
	public int setPT(int id[]){
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{			
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update bookinformation set book_type='普通' where book_id='"+id[j]+"'");			
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
	
	// 获得所有书籍信息
	public List getBook(int book_id){
		String sql="select * from bookinformation where book_id='"+book_id+"'";
		// 建立数据库连接对象
		DBO dbo=new DBO();
		// 数组容器类对象-存放所有书籍信息库
		List list2=new ArrayList();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{			
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			// 添加书籍信息到信息库
			while(rs.next()){
				list2.add(rs.getString(2));
                list2.add(rs.getString(4));
                list2.add(rs.getString(5));
                list2.add(rs.getString(6));
                list2.add(rs.getString(7));
                list2.add(rs.getString(8));
                list2.add(rs.getString(9));
                list2.add(rs.getString(10));
                list2.add(rs.getString(11));
                
			}
			// 返回所有书籍信息
			return list2;
		}catch(Exception e){ // 捕获异常
			// 返回所有书籍信息
			return list2;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 获取所有类型
	public List getAllType(){
		String sql="select bookclass_classification from bookclassification";
		// 创建数据库连接对象
		DBO dbo=new DBO();
		// 数组容器类对象-存放所有类型库
		List list=new ArrayList();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{			
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			// 添加所有类型到类型库
			while(rs.next()){
				list.add(rs.getString(1));
			}
			// 返回所有类型库
			return list;
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 返回所有类型库
			return list;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 更新指定书籍信息
	public int upBook(int book_id,String book_name,String book_author,String book_publisher,String book_price,String book_classification,String book_discountok,String book_discount,String book_recommendlevel,String book_storeamount){
		String sql="update bookinformation set book_name='"+book_name+"',book_author='"+book_author+"',book_publisher='"+book_publisher+"',book_price='"+book_price+"',book_classification='"+book_classification+"',book_discountok='"+book_discountok+"',book_discount='"+book_discount+"',book_recommendlevel='"+book_recommendlevel+"',book_storeamount='"+book_storeamount+"'where book_id='"+book_id+"'";
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
			else{ //执行失败
				// 返回执行失败标记
				return this.ERROR;
				}
		}catch(Exception e){ //捕获异常
			e.printStackTrace();
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
}
