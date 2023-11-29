<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>


<HTML><HEAD><TITLE>图书销售系统 </TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK 
href=/zaixianbook_shop/img/ys1.css type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3059" name=GENERATOR>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 18px;
	font-weight: bold;
}
-->
</style>
</HEAD>
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
	
	String name=(String)session.getAttribute("name");
	if(name!=null){
%>
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
<STYLE type=text/css>.style1 {
	COLOR: #ffff00
}
</STYLE>
<%
	String id=request.getParameter("id").trim();
	String shuming=request.getParameter("shuming").trim();
	String danjia=request.getParameter("danjia").trim();
	shuming=new String(shuming.getBytes("UTF-8"));
%><br><br><br><br>
<script type="text/javascript">

function check()
{
	if(document.form1.shuliang.value=="")
	{
		alert("请输入数量！");
		return false;
	}
	if(isNaN(document.form1.shuliang.value))
	{
		alert("数量为数字！");
		return false;
	}
}
</script>
<form action="/zaixianbook_shop/GouWu.jsp" name=form1 onsubmit="return check()">
<TABLE height=5 cellSpacing=0 cellPadding=0 width=500 align=center border=1>
<tr><input type=hidden name=method value="upgouwu"><input type=hidden name=id value="<%=id %>">
<td align=right>书名：</td>
<td align=left><%=shuming %></td>
</tr>
<tr>
<td align=right>单价：</td>
<td align=left><%=danjia %></td>
</tr>
<tr>
<td align=right>数量：</td>
<td align=left><input type=text name=shuliang size=15 value=<%=request.getParameter("shuliang") %>></td>
</tr>
<tr>
<td colspan=2 align=center><input type=submit value="确定">&nbsp;&nbsp;&nbsp;&nbsp;<input type=reset value="重填"></td>
</tr>
</TABLE>

</form>

  </BODY>
      <%}else{response.sendRedirect("index.jsp");} %>
      </HTML>
