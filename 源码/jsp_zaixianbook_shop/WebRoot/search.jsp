<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>


<HTML><HEAD><TITLE>图书销售系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK 
href=/zaixianbook_shop/img/ys1.css type=text/css rel=stylesheet>


<STYLE type=text/css>.STYLE2 {
	COLOR: #ff0000
}
</STYLE>

<META content="MSHTML 6.00.2900.3059" name=GENERATOR></HEAD>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
			message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");

%>
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
<STYLE type=text/css>.style1 {
	COLOR: #ffff00
}
</STYLE>

<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD width=1200 >
     <img src="/zaixianbook_shop/img/top.jpg" width="1200">
	 </TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD class=k bgColor=#66cccc height=30>
       <DIV align=center><A 
      href="/zaixianbook_shop/index.jsp"><FONT 
      color=#ffffff>首页</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/moregood.jsp"><FONT 
      color=#ffffff>最新图书</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/fenlei.jsp"><FONT 
      color=#ffffff>图书分类</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/moretuijian.jsp"><FONT 
      color=#ffffff>特价图书</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/news.jsp"><FONT 
      color=#ffffff>图书新闻</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/admin/login.jsp" 
      target=_blank><FONT color=#ffffff>管理入口</FONT></A></DIV></TD></TR></TBODY></TABLE>


<TABLE cellSpacing=0 border=1 cellPadding=0 width=1200 align=center bgColor=#ffffff >
  <TR>
    <TD align=center >书名</td>
    <TD align=center >作者</td>
    <TD align=center >出版社</td>
    <TD align=center >价格</td>
    <TD align=center >分类</td>
    </tr>
<%
	String key=null;
	String id=null;
	List list=new ArrayList();
	try{
	key=request.getParameter("key").trim();
	key=new String(key.getBytes("UTF-8"));	
	list=new OrderBean().getBookInfo(key);
	}catch(Exception e){
	id=(String)request.getAttribute("id");
	list=new OrderBean().getBookInfo(Integer.parseInt(id)); 
	}
	if(!list.isEmpty()){
	for(int i=0;i<list.size();i++){
	List list2=(List)list.get(i);
%>	
<tr>
<td align=center><a href="/zaixianbook_shop/admin/bookinfo.jsp?id=<%=list2.get(0).toString()%>"><%=list2.get(1).toString() %></a></td>
<td align=center><%=list2.get(3).toString() %></td>
<td align=center><%=list2.get(4).toString() %></td>
<td align=center><%=list2.get(5).toString() %></td>
<td align=center><%=list2.get(6).toString() %></td>
</tr>	
	
<%}}else{ %>	
<br><br>
没有符合条件的信息！
<br><br>
<%} %>	
</TABLE><br><br>

<TABLE height=5 cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD bgColor=#66CCCC height=20></TD>
  </TR>
   <TR>
  <TD bgColor=#66CCCC height=13  align=center ><a  href="/zaixianbook_shop/admin/login.jsp" target=_blank>管理员登录</a> </TD>
    
  </TR>
   <TR>
    <TD bgColor=#66CCCC height=20></TD>
  </TR>
  </TBODY></TABLE>
  </BODY></HTML>
