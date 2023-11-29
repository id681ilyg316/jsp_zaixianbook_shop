package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 页面信息类
 */
public class NewsPageBean {

	ResultSet rs = null;
    int EVERYPAGENUM = 2;
    int count = -1;
    public void setEVERYPAGENUM(int EVERYPAGENUM){
    	this.EVERYPAGENUM=EVERYPAGENUM;
    }
    
    // 得到信息总数
    public int getMessageCount(String sql) { 
		// 建立数据库连接对象
    	DBO dbo=new DBO();
		// 打开数据库
    	dbo.open();
		// 异常处理
        try { 
			// 执行数据库操作
            rs = dbo.executeQuery(sql);
            rs.next();
            // 获取信息总数
            count = rs.getInt(1);
            // 控制台输出语句-测试
            System.out.println("count=" + count);
            // 返回信息总数
            return count;
        } catch (SQLException ex) { //捕获异常
            ex.printStackTrace();
            // 返回失败标记
            return -1;
        } finally { // 最后一定执行代码
			// 关闭数据库
            dbo.close();
        }
    }
    public int getPageCount() { //得到共多少页（根据每页要显示几条信息）
        if (count % EVERYPAGENUM == 0) {
            System.out.println("count/EVERYPAGENUM=" + (count / EVERYPAGENUM));
            return count / EVERYPAGENUM;
        } else {
            System.out.println("count/EVERYPAGENUM=" + (count / EVERYPAGENUM));
            return count / EVERYPAGENUM + 1;
        }
    }
    
    // 得到每页要显示的信息
    public List getMessage(int page,String sql) {
        // 控制台输出语句-测试
    	System.out.println(sql);
		// 建立数据库连接对象
    	DBO dbo=new DBO();
		// 打开数据库
        dbo.open();
		// 数组容器类对象-存放每页的信息库
        List list = new ArrayList();
        try {
			// 执行数据库操作
            rs = dbo.executeQuery(sql);
            for (int i = 0; i < (page - 1) * EVERYPAGENUM; i++) {
                rs.next();
            }
            for (int t = 0; t < EVERYPAGENUM; t++) {
                if (rs.next()) {
            		// 数组容器类对象-中间对象
                    List list2=new ArrayList();
                    // 获取此页信息
                    list2.add(rs.getString(1));
                    list2.add(rs.getString(2));
                    list2.add(rs.getString(3));
                    list2.add(rs.getString(4));
                    list2.add(rs.getString(5));
                    // 将此页信息添加到信息库中
                    list.add(list2);
                } else {
                	// 减少空循环的时间
                    break;
                }
            }
            // 返回页的所有信息
            return list;
        } catch (SQLException ex) { // 捕获异常
            ex.printStackTrace();
            // 返回页的所有信息
            return list;
        } finally { // 最后一定执行代码
			// 关闭数据库
            dbo.close();
        }
    }
}







