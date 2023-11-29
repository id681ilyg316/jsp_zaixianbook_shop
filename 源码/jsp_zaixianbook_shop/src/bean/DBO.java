package bean;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * �������ݿ���
 */
public class DBO {
	// ���Ӷ���
	private Connection conn;
	// ״̬������
	private Statement stmt;
	
	// ���캯��-��
	public DBO()
	{
	}

	/**
	* �����ݿ�
	*/
	public void open() 
	{
		// �쳣����
		try 
		{
			// �������ݿ�����-JDBC��ʽ
			Class.forName("com.mysql.cj.jdbc.Driver");  
			// �������Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://www.icodedock.com/zaixianbook_shop?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8","zaixianbook_shop","zaixianbook_shop");
			// ����״̬��
			
			
			// �������ݿ�����-JDBC��ʽ
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			// �������Ӷ���
			//conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=WSSD","sa","123456");
			// ����״̬��
			
			
			stmt=conn.createStatement();
			// ����̨������-���
			System.out.println("�����ݿ�����");
		} 
		catch (Exception ex) // �����쳣
		{
			// ����̨������-���
			System.err.println("�����ݿ�ʱ����: " + ex.getMessage());
		}
	}

	/**
	*�ر����ݿ⣬�����ӷ��������ӳ�
	*/
	public void close() 
	{
		// �쳣����
		try 
		{	
			// �ر�����
			conn.close();
			// ����̨������-���
			System.out.println ("�ͷ�����");
		} 
		catch (SQLException ex) // �����쳣
		{
			System.err.println("�������ӳس���: " + ex.getMessage());
		}
	}

	/**
	*ִ�в�ѯ
	*/
	public ResultSet executeQuery(String sql) throws SQLException
	{
		// ��¼������
		ResultSet rs = null;
		// ִ�в�ѯ���,��������¼������
		rs = stmt.executeQuery(sql);
		// ����̨������-���
		System.out.println ("ִ�в�ѯ");
		// ���ؼ�¼������
		return rs;
	}

	/**
	*ִ�����ݿ���ɾ�Ĳ���
	*/
	public int executeUpdate(String sql) throws SQLException
	{
		int ret = 0;
		// ִ�����ݿ���ɾ�Ĳ���
		ret = stmt.executeUpdate(sql);
        // ����̨������-���
		System.out.println ("ִ����ɾ��");
		// ����ִ�����Ӱ���¼��
		return ret;
	}

	/**
	*��SQL�����뵽������
	*/
	public void addBatch(String sql) throws SQLException 
    {
		stmt.addBatch(sql);
	}

	/**
	*ִ��������
	*/
	public int [] executeBatch() throws SQLException 
	{
		boolean isAuto=conn.getAutoCommit();
		
		conn.setAutoCommit(false);
		int [] updateCounts = stmt.executeBatch();
		return updateCounts;
	}
	public boolean getAutoCommit() throws SQLException
	{
		return conn.getAutoCommit();
	}
	public void setAutoCommit(boolean auto)  throws SQLException 
	{
		conn.setAutoCommit(auto);
	}
	
	public void commit() throws SQLException 
	{
		conn.commit();
		
	}
	public void rollBack() throws SQLException 
	{
		conn.rollback();
		
	}
	 public static String URLDecoderString(String str) {
	        String result = "";
	        if (null == str) {
	            return "";
	        }
	        try {
	            result = java.net.URLDecoder.decode(str, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
}



