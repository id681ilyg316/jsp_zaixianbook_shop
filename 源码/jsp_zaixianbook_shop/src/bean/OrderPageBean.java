package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * ����ҳ����Ϣ��
 */
public class OrderPageBean {

	ResultSet rs = null;
    int EVERYPAGENUM = 2;
    int count = -1;
    public void setEVERYPAGENUM(int EVERYPAGENUM){
    	this.EVERYPAGENUM=EVERYPAGENUM;
    }
    
    // �õ���Ϣ����
    public int getMessageCount(String sql) {
       DBO dbo=new DBO();
       dbo.open();
        try { 
            rs = dbo.executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
            System.out.println("count=" + count);
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        } finally {
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
    	System.out.println(sql);
    	DBO dbo=new DBO();
        dbo.open();
        List list = new ArrayList();
        try {
            rs = dbo.executeQuery(sql);
            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
                rs.next();
            }
            for (int t = 0; t < EVERYPAGENUM; t++) {
                if (rs.next()) {			 		
                    List list2=new ArrayList();
                    list2.add(rs.getString(1));
                    list2.add(rs.getString(2));
                    list2.add(rs.getString(3));
                    list2.add(rs.getString(4));
                    list2.add(rs.getString(5));
                    list2.add(rs.getString(6));
                    list.add(list2);
                } else {
                	// ���ٿ�ѭ����ʱ��
                    break;
                }
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return list;
        } finally {
            dbo.close();
        }
    }
}








