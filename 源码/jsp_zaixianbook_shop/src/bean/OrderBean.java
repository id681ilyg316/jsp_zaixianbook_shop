package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *订单类
 */
public class OrderBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// 记录集对象
	private ResultSet rs;
	
	// 删除订单
	public int delOrder(int id[]){
		// 实例连接数据库对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{		
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from ordersendingform where ordersendingform_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //捕获异常
			e.printStackTrace();
			// 返回执行失败标记
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 设置已发货
	public int faOrder(int id[]){
		// 实例连接数据库对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{		
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update ordersendingform set ordersendingform_sendok='已经发货' where ordersendingform_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //捕获异常
			e.printStackTrace();
			return this.ERROR;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	// 获取订单信息
	public List getOrder(String bookorderform_formnumber){
		String sql="select bookinformation.book_name,bookorderform.bookorderform_amount,bookinformation.book_price,bookinformation.book_discountok,bookinformation.book_id from bookinformation,bookorderform where bookinformation.book_id=bookorderform.bookorderform_bookid and bookorderform.bookorderform_formnumber='"+bookorderform_formnumber+"'";
		// 数组容器类对象-存放所有订单信息库
		List list=new ArrayList();
		// 实例连接数据库对象
		DBO dbo=new DBO();
		// 打开数据库
		dbo.open();
		// 异常处理
		try{	
			// 执行SQL语句
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// 数组容器类对象-中间对象
				List list2=new ArrayList();
				// 获取此订单信息
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				// 将此订单信息添加到订单信息库
				list.add(list2);
			}
			// 返回所有订单信息库
			return list;
		}catch(Exception e){ // 捕获异常
			e.printStackTrace();
			// 返回所有订单信息库
			return list;
		}finally{ // 最后一定执行代码
			// 关闭数据库
			dbo.close();
		}
	}
	
	public String getBookName(int book_id){
		String book_name="";
		String sql="select book_name from bookinformation where book_id='"+book_id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				book_name = rs.getString(1);
			}
			return book_name;
		}catch(Exception e){
			e.printStackTrace();
			return book_name;
		}finally{
			dbo.close();
		}
	}
	
	// 获取指定ID图书信息
	public List getBookInfo(int book_id){
		String sql="select * from bookinformation where book_id='"+book_id+"'";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
				list.add(rs.getString(9));
				list.add(rs.getString(10));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取与关键字key有关的图书信息-模糊查询
	public List getBookInfo(String key){
		String sql="select * from bookinformation where book_name like'%"+key+"%'";
		System.out.println(sql);
		List list=new ArrayList();
		DBO dbo=new DBO();
		
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
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
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取所有图书类型
	public List getBookType(){
		String sql="select * from bookclassification ";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){				
				list.add(rs.getString(2));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取前3个最新图书信息
	public List get3NewBook(){
		String sql="select book_name,book_picturepath,book_price ,book_id from bookinformation where book_type='最新' order by book_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			System.out.println("OKKKKKKKKKKKKKKKKK");
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取前6个最新图书信息
	public List get6NewBook(){
		String sql="select  book_name,book_picturepath,book_price,book_id from bookinformation where book_type='最新' order by book_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			rs.next();
			rs.next();
			rs.next();
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取所有最新图书信息
	public List getAllNewBook(){
		String sql="select  book_name,book_picturepath,book_price,book_id from bookinformation where book_type='最新' order by book_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取前3个特价图书信息
	public List get3TBook(){
		String sql="select book_name,book_picturepath,book_price ,book_id from bookinformation where book_type='特价'  order by book_id desc  limit 0,3";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			System.out.println("OKKKKKKKKKKKKKKKKK");
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取前6个特价图书信息
	public List get6TBook(){
		String sql="select  book_name,book_picturepath,book_price,book_id from bookinformation where book_type='特价' order by book_id desc  limit 3,3";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			rs.next();
			rs.next();
			rs.next();
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取所有特价图书信息
	public List getAllTBook(){
		String sql="select book_name,book_picturepath,book_price,book_id from bookinformation where book_type='特价' order by book_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 按类别查询图书信息
	public List getTypeTBook(String book_classification){
		String sql="select book_name,book_picturepath,book_price,book_id from bookinformation where book_classification='"+book_classification+"' order by book_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取新闻信息
	public List getNews(){
		String sql="select webnews_title,webnews_content,webnews_sendtime from webnews order by webnews_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 将指定书籍信息加入购物车
	public int addGouWuChe(int shoppingcar_bookid,String shoppingcar_userid){
		String sql="select shoppingcar_amount from shoppingcar where shoppingcar_bookid='"+shoppingcar_bookid+"' and shoppingcar_userid='"+shoppingcar_userid+"'";
		String sql2="insert into shoppingcar (shoppingcar_bookid,shoppingcar_amount,shoppingcar_addtime,shoppingcar_userid) values('"+shoppingcar_bookid+"','1','"+new java.util.Date().toLocaleString()+"','"+shoppingcar_userid+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{	
			// 查询书籍信息
			rs=dbo.executeQuery(sql);

			if(rs.next()){
				int j=rs.getInt(1);
				j+=1;
				// 修改购物车
				int i=dbo.executeUpdate("update shoppingcar set shoppingcar_amount='"+j+"' where shoppingcar_bookid='"+shoppingcar_bookid+"'");
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}
			}
			else{
				// 向2购物车表中添加信息
				int i=dbo.executeUpdate(sql2);
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
	
	// 获取"我的购物车"内容
	public List getMyGouWuChe(String shoppingcar_userid){
		String sql="select bookinformation.book_name,shoppingcar.shoppingcar_amount,bookinformation.book_price,shoppingcar.shoppingcar_addtime,shoppingcar.shoppingcar_bookid from bookinformation,shoppingcar where shoppingcar.shoppingcar_bookid=bookinformation.book_id and shoppingcar.shoppingcar_userid='"+shoppingcar_userid+"' order by shoppingcar.shoppingcar_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	//获得指定用户姓名的订单信息
	public List getMyDD(String ordersendingform_userid){
		String sql="select ordersendingform_id,ordersendingform_formnumber,ordersendingform_sendok,fangshi from  ordersendingform where ordersendingform_userid='"+ordersendingform_userid+"' and zhuangtai='正常' order by ordersendingform_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 获取指定图书ID号的相关评论
	public List getCommont(int bookcomment_id){
		String sql="select bookcomment.bookcomment_content,bookcomment.bookcomment_sender,bookcomment.bookcomment_sendtime,bookinformation.book_name from bookcomment,bookinformation where bookcomment.bookcomment_bookid=bookinformation.book_id and bookcomment.bookcomment_bookid='"+bookcomment_id+"' order by bookcomment.bookcomment_id desc";
		List list=new ArrayList();
		DBO dbo=new DBO();
		dbo.open();
		try{			
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	
	// 删除指定ID的购物车中图书的信息
	public int delGouWu(int shoppingcar_bookid){
		String sql="delete from shoppingcar where shoppingcar_bookid='"+shoppingcar_bookid+"'";
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
	public int upGouWuChe(int id,int shuliang,String name){
		String sql="update  shoppingcar set  shoppingcar_amount='"+shuliang+"' where shoppingcar_bookid='"+id+"' and shoppingcar_userid='"+name+"' ";
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
	//删除订单
	public int delDD(int ordersendingform_id){
		String sql="update ordersendingform set zhuangtai='用户已删除' where ordersendingform_id='"+ordersendingform_id+"'";
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
	
	// 添加订单信息并把数据加到订单明细中
	public int addOrder(long number,String name,String fukuanfangshi){
		String sql="insert into ordersendingform (ordersendingform_formnumber,ordersendingform_userid,ordersendingform_sendok,fangshi,zhuangtai) values('"+number+"','"+name+"','未发货','"+fukuanfangshi+"','正常')";
		DBO dbo=new DBO();
		dbo.open();
		DBO dbo2=new DBO();
		dbo2.open();
		try{			
			int i=dbo.executeUpdate(sql);
			if(i==1){
				ResultSet rs2=dbo2.executeQuery("select shoppingcar_bookid,shoppingcar_amount from shoppingcar where shoppingcar_userid='"+name+"'");
				while(rs2.next()){
					int bookid=rs2.getInt(1);
					int shuliang=rs2.getInt(2);
					dbo.executeUpdate("insert into bookorderform (bookorderform_formnumber,bookorderform_bookid,bookorderform_amount) values('"+number+"','"+bookid+"','"+shuliang+"')");
				}
				dbo.executeUpdate("delete from shoppingcar where shoppingcar_userid='"+name+"'");
				return this.SUCCESS;
				
			}
			else{
				return this.ERROR;
				}
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();dbo2.close();
		}
	}
}
