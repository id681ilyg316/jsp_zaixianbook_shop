package util;

import java.sql.ResultSet;

import bean.DBO;

public class CommontBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	private ResultSet rs;
	public int addCommont(String content,String sender,int bookid){
		String sql="insert into commont values('"+content+"','"+sender+"','"+new java.util.Date().toLocaleString()+"','"+bookid+"')";
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
	public int delCommont(int id){
		String sql="delete from commont where id='"+id+"'";
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
}
