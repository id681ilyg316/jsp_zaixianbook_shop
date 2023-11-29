package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * ������Ϣ��
 */
public class NewsBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	// ��¼������
	private ResultSet rs;
	
	// ɾ��������Ϣ
	public int delNews(int id[]){
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{			
			for(int j=0;j<id.length;j++){
				dbo.executeUpdate("delete from webnews where webnews_id='"+id[j]+"'");			
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
	
	// ���������Ϣ
	public int addNews(String webnews_title,String webnews_content,String webnews_sender){
		String sql="insert into webnews (webnews_title,webnews_content,webnews_sendtime,webnews_sender) values('"+webnews_title+"','"+webnews_content+"','"+new java.util.Date().toLocaleString()+"','"+webnews_sender+"')";
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
	
	// ����ָ��ID��������Ϣ
	public int upNews(int webnews_id,String webnews_title,String webnews_content){
		String sql="update webnews set webnews_title='"+webnews_title+"',webnews_content='"+webnews_content+"' where webnews_id='"+webnews_id+"'";
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
		}catch(Exception e){ //�����쳣
			// ����ִ��ʧ�ܱ��
			return this.ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	// ��ȡ���ݿ��У�ָ��ID��������Ϣ
	public List getNews(int webnews_id){
		String sql="select webnews_title ,webnews_content from webnews where webnews_id='"+webnews_id+"'";
        // �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �������������-�������������Ϣ��
		List list=new ArrayList();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{		
			// ִ��SQL���
			rs=dbo.executeQuery(sql);
			rs.next();
			// ��ȡ��������Ϣ
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			// ����������Ϣ����
			return list;
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// ִ��SQL���
			return list;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
}
