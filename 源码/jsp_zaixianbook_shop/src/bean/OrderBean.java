package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *������
 */
public class OrderBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// ��¼������
	private ResultSet rs;
	
	// ɾ������
	public int delOrder(int id[]){
		// ʵ���������ݿ����
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{		
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from ordersendingform where ordersendingform_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //�����쳣
			e.printStackTrace();
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// �����ѷ���
	public int faOrder(int id[]){
		// ʵ���������ݿ����
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{		
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update ordersendingform set ordersendingform_sendok='�Ѿ�����' where ordersendingform_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //�����쳣
			e.printStackTrace();
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ��ȡ������Ϣ
	public List getOrder(String bookorderform_formnumber){
		String sql="select bookinformation.book_name,bookorderform.bookorderform_amount,bookinformation.book_price,bookinformation.book_discountok,bookinformation.book_id from bookinformation,bookorderform where bookinformation.book_id=bookorderform.bookorderform_bookid and bookorderform.bookorderform_formnumber='"+bookorderform_formnumber+"'";
		// �������������-������ж�����Ϣ��
		List list=new ArrayList();
		// ʵ���������ݿ����
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{	
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// �������������-�м����
				List list2=new ArrayList();
				// ��ȡ�˶�����Ϣ
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				// ���˶�����Ϣ��ӵ�������Ϣ��
				list.add(list2);
			}
			// �������ж�����Ϣ��
			return list;
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// �������ж�����Ϣ��
			return list;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
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
	
	// ��ȡָ��IDͼ����Ϣ
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
	
	// ��ȡ��ؼ���key�йص�ͼ����Ϣ-ģ����ѯ
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
	
	// ��ȡ����ͼ������
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
	
	// ��ȡǰ3������ͼ����Ϣ
	public List get3NewBook(){
		String sql="select book_name,book_picturepath,book_price ,book_id from bookinformation where book_type='����' order by book_id desc";
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
	
	// ��ȡǰ6������ͼ����Ϣ
	public List get6NewBook(){
		String sql="select  book_name,book_picturepath,book_price,book_id from bookinformation where book_type='����' order by book_id desc";
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
	
	// ��ȡ��������ͼ����Ϣ
	public List getAllNewBook(){
		String sql="select  book_name,book_picturepath,book_price,book_id from bookinformation where book_type='����' order by book_id desc";
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
	
	// ��ȡǰ3���ؼ�ͼ����Ϣ
	public List get3TBook(){
		String sql="select book_name,book_picturepath,book_price ,book_id from bookinformation where book_type='�ؼ�'  order by book_id desc  limit 0,3";
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
	
	// ��ȡǰ6���ؼ�ͼ����Ϣ
	public List get6TBook(){
		String sql="select  book_name,book_picturepath,book_price,book_id from bookinformation where book_type='�ؼ�' order by book_id desc  limit 3,3";
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
	
	// ��ȡ�����ؼ�ͼ����Ϣ
	public List getAllTBook(){
		String sql="select book_name,book_picturepath,book_price,book_id from bookinformation where book_type='�ؼ�' order by book_id desc";
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
	
	// ������ѯͼ����Ϣ
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
	
	// ��ȡ������Ϣ
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
	
	// ��ָ���鼮��Ϣ���빺�ﳵ
	public int addGouWuChe(int shoppingcar_bookid,String shoppingcar_userid){
		String sql="select shoppingcar_amount from shoppingcar where shoppingcar_bookid='"+shoppingcar_bookid+"' and shoppingcar_userid='"+shoppingcar_userid+"'";
		String sql2="insert into shoppingcar (shoppingcar_bookid,shoppingcar_amount,shoppingcar_addtime,shoppingcar_userid) values('"+shoppingcar_bookid+"','1','"+new java.util.Date().toLocaleString()+"','"+shoppingcar_userid+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{	
			// ��ѯ�鼮��Ϣ
			rs=dbo.executeQuery(sql);

			if(rs.next()){
				int j=rs.getInt(1);
				j+=1;
				// �޸Ĺ��ﳵ
				int i=dbo.executeUpdate("update shoppingcar set shoppingcar_amount='"+j+"' where shoppingcar_bookid='"+shoppingcar_bookid+"'");
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}
			}
			else{
				// ��2���ﳵ���������Ϣ
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
	
	// ��ȡ"�ҵĹ��ﳵ"����
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
	
	//���ָ���û������Ķ�����Ϣ
	public List getMyDD(String ordersendingform_userid){
		String sql="select ordersendingform_id,ordersendingform_formnumber,ordersendingform_sendok,fangshi from  ordersendingform where ordersendingform_userid='"+ordersendingform_userid+"' and zhuangtai='����' order by ordersendingform_id desc";
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
	
	// ��ȡָ��ͼ��ID�ŵ��������
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
	
	// ɾ��ָ��ID�Ĺ��ﳵ��ͼ�����Ϣ
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
	//ɾ������
	public int delDD(int ordersendingform_id){
		String sql="update ordersendingform set zhuangtai='�û���ɾ��' where ordersendingform_id='"+ordersendingform_id+"'";
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
	
	// ��Ӷ�����Ϣ�������ݼӵ�������ϸ��
	public int addOrder(long number,String name,String fukuanfangshi){
		String sql="insert into ordersendingform (ordersendingform_formnumber,ordersendingform_userid,ordersendingform_sendok,fangshi,zhuangtai) values('"+number+"','"+name+"','δ����','"+fukuanfangshi+"','����')";
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
