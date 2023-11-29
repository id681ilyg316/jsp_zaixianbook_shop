package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * ������Ϣ��
 */
public class CommontBean {

	private static int SUCCESS=1;
	private static int DATABASE_ERROR=2;
	// ��¼������
	private ResultSet rs;
	// �������������
	private List list=new ArrayList();
	
	//����������Ϣ
	public int addCommon(String bookcomment_content,String bookcomment_sender,int bookcomment_bookid){
		String sql="insert into bookcomment (bookcomment_content,bookcomment_sender,bookcomment_sendtime,bookcomment_bookid) values('"+bookcomment_content+"','"+bookcomment_sender+"','"+new java.util.Date().toLocaleString()+"','"+bookcomment_bookid+"')";
		System.out.println("sql=" +sql);
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
				return this.DATABASE_ERROR;
			}
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			// ����ִ��ʧ�ܱ��
			return this.DATABASE_ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
	
	//ɾ��������Ϣ
	public int delCommon(int bookcomment_id[]){
		// �������ݿ����Ӷ���
		DBO dbo=new DBO();
		// �����ݿ�
		dbo.open();
		// �쳣����
		try{
			for(int j=0;j<bookcomment_id.length;j++){
				// ִ��SQL���
				dbo.executeUpdate("delete from bookcomment where bookcomment_id='"+bookcomment_id[j]+"'");
			}
			// ����ִ�гɹ�
			return this.SUCCESS;
		}catch(Exception e){ // �����쳣
			e.printStackTrace();
			return this.DATABASE_ERROR;
		}finally{ // ���һ��ִ�д���
			// �ر����ݿ�
			dbo.close();
		}
	}
}
