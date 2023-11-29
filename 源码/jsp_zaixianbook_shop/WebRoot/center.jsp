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
	
	String name=(String)session.getAttribute("name");//获取name的属性值
	if(name!=null){
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


<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center bgColor=#ffffff 
border=0>
<script language="javascript">
function check()
{
	if(document.form1.login.value==""||document.form1.email.value=="")
	{
		alert("必须填写所有项目！");
		return false;
	}
}
</script>
  <TBODY>
  <TR>
    <TD align=center vAlign=top width=1200 height=400>
	
	<table bgcolor=#99CCCC align=left width=100 border=0 height=400>
	<tr>
	<td align=center bordercolor="#CCFFFF" bgcolor="#99CCCC"><a href="upuser.jsp">个人信息</a></td>
	</tr>
	<tr>
	<td align=center bordercolor="#FFFFFF" bgcolor="#99CCCC"><a href="gouwuche.jsp">我的购物车</a></td> 
	</tr>
	<tr>
	<td align=center bordercolor="#FFFFFF" bgcolor="#99CCCC"><a href="dingdan.jsp">我的订单</a></td>
	</tr>
	<tr>
	<td align=center bordercolor="#FFFFFF" bgcolor="#99CCCC"><a href="/zaixianbook_shop/LoginOut.jsp?method=center">退出登陆</a></td>
	</tr>
	<tr>
	<td bordercolor="#FFFFFF" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	</table>
	<table align=right width=679 border=0 height=400>
	<tr>
	<td align=center vAlign=middle bgcolor="#FFFFFF">欢迎<%=name %>进入用户中心，在这里您可以查看修改个人信息和购物信息！</td>
	</tr>
	</table>
	</TD>
    
  </TR></TBODY></TABLE>


  
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
</BODY>
      <%}else{response.sendRedirect("index.jsp");} %>
      </HTML>
