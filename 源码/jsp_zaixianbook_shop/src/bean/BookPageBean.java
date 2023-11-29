package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * ҳ����Ϣ��
 */
public class BookPageBean {

	ResultSet rs = null;
    int EVERYPAGENUM = 2;
    int count = -1;
    public void setEVERYPAGENUM(int EVERYPAGENUM){
    	this.EVERYPAGENUM=EVERYPAGENUM;
    }
    
    // �õ���Ϣ����
    public int getMessageCount(String sql) { 
    	// �������ݿ����Ӷ���
    	DBO dbo=new DBO();
       	// �����ݿ�
       	dbo.open();
       	// �쳣����
        try { 
        	// ִ��SQL���
            rs = dbo.executeQuery(sql);
            rs.next();
            // �õ�����
            count = rs.getInt(1);
            // ����̨������-����
            System.out.println("count=" + count);
            // ��������
            return count;
        } catch (SQLException ex) { //�����쳣
            ex.printStackTrace();
            // ������ʾ����
            return -1;
        } finally { // ���һ��ִ�д���
			// �ر����ݿ�
            dbo.close();
        }
    }
    
    // �õ�������ҳ������ÿҳҪ��ʾ������Ϣ��
    public int getPageCount() { 
        if (count % EVERYPAGENUM == 0) {
            System.out.println("count/EVERYPAGENUM=" + (count / EVERYPAGENUM));
            return count / EVERYPAGENUM;
        } else {
            System.out.println("count/EVERYPAGENUM=" + (count / EVERYPAGENUM));
            return count / EVERYPAGENUM + 1;
        }
    }
    
    // �õ�ÿҳҪ��ʾ����Ϣ
    public List getMessage(int page,String sql) { 
    	// ����̨������-����
    	System.out.println(sql);
    	// �������ݿ����Ӷ���
    	DBO dbo=new DBO();
    	// �����ݿ�
        dbo.open();
        // �������������-���������ʾ��Ϣ��
        List list = new ArrayList();
        // �쳣����
        try {
        	// ִ��SQL���
            rs = dbo.executeQuery(sql);
            // ���������ʾ��Ϣ
            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
                rs.next();
            }
            for (int t = 0; t < EVERYPAGENUM; t++) {
                if (rs.next()) {
                	// �������������-�м����
                    List list2=new ArrayList();
                    // ��ȡ����ʾ��Ϣ����
                    list2.add(rs.getString(1));
                    list2.add(rs.getString(2));
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
                    // ��Ӵ���ʾ��Ϣ����Ϣ��
                    list.add(list2);
                } else {
                	// ���ٿ�ѭ����ʱ��
                    break; 
                }
            }
            // ����������ʾ��Ϣ��
            return list;
        } catch (SQLException ex) { // �����쳣
            ex.printStackTrace();
            // ����������ʾ��Ϣ��
            return list;
        } finally { // ���һ��ִ�д���
			// �ر����ݿ�
            dbo.close();
        }
    }
}






