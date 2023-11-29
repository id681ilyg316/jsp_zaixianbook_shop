package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * ��ͨ�û���½ͨ����
 */
public class UserLoginBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	private ResultSet rs;
	//�û���½ͨ����
	public int userLogin(String member_loginname,String member_password){
		String sql="select * from commonmember where member_loginname ='"+member_loginname+"' and member_password='"+member_password+"'";
		// ����̨������-����
		System.out.println(sql);
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			// ��½��֤
			if(rs.next()){ // ִ�гɹ�
				return this.SUCCESS;
			}
			else{ // ִ��ʧ��
				return this.ERROR;
			}
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}
		finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	//���û�ע�� 
	public int regUser(String member_loginname,String member_password,String member_name,String member_sex,String member_email,String member_tel){
		String sql="insert into commonmember (member_loginname,member_password,member_truename,member_sex,member_email,member_tel,member_level) values('"+member_loginname+"','"+member_password+"','"+member_name+"','"+member_sex+"','"+member_email+"','"+member_tel+"','0')";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{
			// ִ��SQL���
			rs=dbo.executeQuery("select * from commonmember where member_loginname='"+member_loginname+"'");
			// �鿴�Ƿ�����
			if(rs.next()){ // ������
				System.out.println("������");
				return this.SAME;
			}
			else{ // ������
				// ִ��SQL���
				System.out.println("������");
				System.out.println(sql);
				int i=dbo.executeUpdate(sql);
				System.out.println("----");
				System.out.println("reg"+i);
				if(i==1){ // ִ�гɹ�
					return this.SUCCESS;
				}
				else{ // ִ��ʧ��
					return this.ERROR;
				}
			}
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{  // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ��ȡ�����û���Ϣ
	public List getUser(){
		String sql="select * from commonmember ";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �������������-���������ͨ�û���Ϣ��
		List list=new ArrayList();
		try{
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// �������������-�м����
				List list2=new ArrayList();
				// ��ȡ����ͨ�û���Ϣ
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
				// ������ͨ�û���Ϣ��ӵ���Ϣ��
				list.add(list2);
			}
			// ����������ͨ�û���Ϣ��
			return list;
		}catch(Exception e){ // �����쳣
			// ����������ͨ�û���Ϣ��
			return list;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ��ӹ���Ա
	public int addManager(String admin_name,String admin_password){
		String sql="insert into systemadministrator (admin_name,admin_password,admin_addtime) values('"+admin_name+"','"+admin_password+"','"+new java.util.Date().toLocaleString()+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery("select * from systemadministrator where admin_name='"+admin_name+"'");
			// �鿴�Ƿ�����
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
	
	// ��ȡָ��ID�Ĺ���Ա��Ϣ
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
	
	// �޸Ĺ���Ա����
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
	
	// ��ȡ���й���Ա��Ϣ
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
	
	// ɾ��ָ��ID�Ĺ���Ա��Ϣ
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
	
	// ɾ��ָ��ID����ͨ�û���Ϣ
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
	
	// ��ȡָ���û����Ƶ���ͨ�û���Ϣ
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
	
	// �޸�ָ���û����Ƶ���ͨ�û���Ϣ
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
	
	// ��ȡָ���û����Ƶ���ͨ�û��ļ���(ͨ���ۼ����ѽ���б�)
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
				str="��ͨ";
			}
			else if(f>1000&&f<2000){
				str="����";
			}
			else if(f>2000){
				str="��";
			}
			return str;
		}catch(Exception e){
			e.printStackTrace();
			return "��ͨ";
		}finally{
			dbo.close();
		}
	}
	
	// ͨ��"�û�����"��"�����ʼ�"�һ���ͨ�û�������
	public int getMiMa(String member_loginname,String member_email){
		String sql="select * from commonmember where member_loginname='"+member_loginname+"' and member_email='"+member_email+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){//��½��֤
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



