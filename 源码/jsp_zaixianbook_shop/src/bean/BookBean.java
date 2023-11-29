package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * �鼮��Ϣ��
 */
public class BookBean {
	// ��Ա��������
	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// ��¼������
	private ResultSet rs;
	// ��ȡ�鼮������Ϣ
	public List getFenLei(){
		String sql="select * from bookclassification order by bookclass_id desc";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �������������-��������鼮������Ϣ��
		List list=new ArrayList();
		// �쳣����
		try{
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// �������������-�м����
				List list2=new ArrayList();
				// ���մ��鼮������Ϣ
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				// �����鼮������Ϣ���뵽�鼮��Ϣ��
				list.add(list2);
			}
			// �����鼮������Ϣ��
			return list;
		}catch(Exception e){ //�����쳣
			// �����鼮������Ϣ��
			return list;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ��ӷ�����Ϣ
	public int addFenLei(String bookclass_classification){
		String sql="insert into bookclassification (bookclass_classification,bookclass_addtime) values('"+bookclass_classification+"','"+new java.util.Date().toLocaleString()+"')";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{
			// ִ��SQL��ѯ���
			rs=dbo.executeQuery("select * from bookclassification where bookclass_classification='"+bookclass_classification+"'");
			// �鿴�Ƿ�����
			if(rs.next()){ // ������
				// �����������
				return this.SAME;
			}
			else{ //������
				// ִ��SQL���²���-���
				int i=dbo.executeUpdate(sql);
				if(i==1){ //��ӳɹ�
					// ����ִ�гɹ����
					return this.SUCCESS;
				}
				else{ //���ʧ��
					// ����ִ��ʧ�ܱ��
					return this.ERROR;
				}
			}			
		}catch(Exception e){ //�����쳣
			e.printStackTrace();
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ɾ��������Ϣ
	public int delFenLei(int id[]){
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �����쳣
		try{			
			// ִ��SQL���-ɾ��
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from bookclassification where bookclass_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ // �����쳣
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ɾ���鼮��Ϣ
	public int delBook(int id[]){
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		try{			
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from bookinformation where book_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //�����쳣
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ����ָ���鼮Ϊ"����"����ͼ��
	public int setNew(int id[]){
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{		
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update bookinformation set book_type='����' where book_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //�쳣����
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ����ָ���鼮Ϊ"�ؼ�"����ͼ��
	public int setTeJia(int id[]){
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{	
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update bookinformation set book_type='�ؼ�' where book_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ //�����쳣
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ����ָ���鼮Ϊ"��ͨ"����ͼ��
	public int setPT(int id[]){
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{			
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("update bookinformation set book_type='��ͨ' where book_id='"+id[j]+"'");			
			}
			return this.SUCCESS;
		}catch(Exception e){ // �����쳣
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ��������鼮��Ϣ
	public List getBook(int book_id){
		String sql="select * from bookinformation where book_id='"+book_id+"'";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �������������-��������鼮��Ϣ��
		List list2=new ArrayList();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{			
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			// ����鼮��Ϣ����Ϣ��
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
			// ���������鼮��Ϣ
			return list2;
		}catch(Exception e){ // �����쳣
			// ���������鼮��Ϣ
			return list2;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ��ȡ��������
	public List getAllType(){
		String sql="select bookclass_classification from bookclassification";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �������������-����������Ϳ�
		List list=new ArrayList();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{			
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			// ����������͵����Ϳ�
			while(rs.next()){
				list.add(rs.getString(1));
			}
			// �����������Ϳ�
			return list;
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// �����������Ϳ�
			return list;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ����ָ���鼮��Ϣ
	public int upBook(int book_id,String book_name,String book_author,String book_publisher,String book_price,String book_classification,String book_discountok,String book_discount,String book_recommendlevel,String book_storeamount){
		String sql="update bookinformation set book_name='"+book_name+"',book_author='"+book_author+"',book_publisher='"+book_publisher+"',book_price='"+book_price+"',book_classification='"+book_classification+"',book_discountok='"+book_discountok+"',book_discount='"+book_discount+"',book_recommendlevel='"+book_recommendlevel+"',book_storeamount='"+book_storeamount+"'where book_id='"+book_id+"'";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{			
			// ִ��SQL���
			int i=dbo.executeUpdate(sql);
			if(i==1){ //ִ�гɹ�
				// ����ִ�гɹ����
				return this.SUCCESS;
			}
			else{ //ִ��ʧ��
				// ����ִ��ʧ�ܱ��
				return this.ERROR;
				}
		}catch(Exception e){ //�����쳣
			e.printStackTrace();
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
}
