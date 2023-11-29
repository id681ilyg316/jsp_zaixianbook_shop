package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *����Ա��½ͨ����
 */
public class AdminLoginBean {
	// ��Ա��������
	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// ��¼������
	private ResultSet rs;
	//����Ա��½ͨ����
	public int userLogin(String admin_name,String admin_password){
		String sql="select * from systemadministrator where admin_name ='"+admin_name+"' and admin_password='"+admin_password+"'";
		// ʵ���������ݿ����
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			// ��½��֤
			if(rs.next()){
				// ���ҵ����ϼ�¼,���ز��ҳɹ����
				return this.SUCCESS;
			}
			else{
				// δ���ҵ����ϼ�¼,���ز���ʧ�ܱ��
				return this.ERROR;
			}
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// ���ز���ʧ�ܱ��
			return this.ERROR;
		}
		finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	//���ӹ���Ա 
	public int addUser(String admin_name,String admin_password){
		String sql="insert into systemadministrator (admin_name,admin_password) values('"+admin_name+"','"+admin_password+"')";
		// �������ݿ����
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		//�쳣����
		try{
			// ִ��SQL���
			rs=dbo.executeQuery("select * from systemadministrator where admin_name='"+admin_name+"'");
			// �鿴�Ƿ�����
			if(rs.next()){
				// �����������
				return this.SAME;
			}
			else{
				// ִ��SQL���
				int i=dbo.executeUpdate(sql);
				if(i==1){ // ִ�гɹ�
					return this.SUCCESS;
				}
				else{ // ִ��ʧ��
					return this.ERROR;
				}
			}
			
		}catch(Exception e){ // �����쳣
			// ����ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ����û���Ϣ(�޲���)-���������û���Ϣ
	public List getUser(){
		// ִ��SQL���
		String sql="select admin_id, admin_name from systemadministrator ";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �������������-��������û���Ϣ��
		List list=new ArrayList();
		try{
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				// �������������-�м����
				List list2=new ArrayList();
				// ���û�ID�������������
				list2.add(rs.getString(1));
				// ���û�ID�������������
				list2.add(rs.getString(2));
				// ��Ӵ��û���Ϣ���û���Ϣ��
				list.add(list2);
			}
			// �����û���Ϣ��-�������������
			return list;
		}catch(Exception e){ // �����쳣
			// �����û���Ϣ��-�������������
			return list;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	// ����û���Ϣ(�в���)-����һ��ָ���û���Ϣ
	public List getUser(int admin_id){
		String sql="select admin_id, admin_name,admin_password from systemadministrator where admin_id='"+admin_id+"'";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �������������-���ָ���û���Ϣ
		List list=new ArrayList();
		// �쳣����
		try{
			// ִ�����ݿ����
			rs=dbo.executeQuery(sql);
			rs.next();
			// �����û���Ϣ
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			// ����ָ���û���Ϣ-�������������
			return list;
		}catch(Exception e){ // �����쳣
			// ����ָ���û���Ϣ-�������������
			return list;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ɾ���û���Ϣ
	public int delUser(int admin_id){
		String sql="delete from systemadministrator where admin_id='"+admin_id+"'";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{		
			// ִ��SQL���
			int i=dbo.executeUpdate(sql);
			if(i==1){ // ִ�гɹ�
				// ����ִ�гɹ����
				return this.SUCCESS;
			}
			else{ // ִ��ʧ��
				// ����ִ��ʧ�ܱ��
				return this.ERROR;
			}
		}catch(Exception e){ // �����쳣
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ����ָ���û���Ϣ
	public int upUser(int admin_id,String admin_name,String admin_password){
		String sql="update systemadministrator set admin_name='"+admin_name+"',admin_password='"+admin_password+"' where admin_id='"+admin_id+"'";
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{
			// ִ��SQL���
			int i=dbo.executeUpdate(sql);
			if(i==1){ // ִ�гɹ�
				// ����ִ�гɹ����
				return this.SUCCESS;
			}
			else{ // ִ��ʧ��
				// ����ִ��ʧ�ܱ��
				return this.ERROR;
			}
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
}


