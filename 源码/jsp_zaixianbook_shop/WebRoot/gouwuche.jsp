<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>


<HTML><HEAD><TITLE>图书销售系统</TITLE>
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


	<form action="/zaixianbook_shop/GouWu.jsp" name="form1" >
	<table align=center width=660 border=1 >
	<tr><input type=hidden name=method value=sendorder><input type=hidden name=id value=1>
	<td align="center" colspan="6"><br>
	  <span class="STYLE2">我的购物车</span></td>
	</tr>
	<tr>
	<td align="center" height="30">书名</td>
	<td align="center" height="30">数量</td>
	<td align="center" height="30">单价</td>
	<td align="center" height="30">加入时间</td>
	<td align="center" height="30">修改</td>
	<td align="center" height="30">操作</td>
	</tr>
	<%
	List list=new OrderBean().getMyGouWuChe(name);
	if(!list.isEmpty()){
	float f=0;
	for(int i=0;i<list.size();i++){
		List list2=(List)list.get(i);
		f+=Integer.parseInt(list2.get(1).toString())*Float.parseFloat(list2.get(2).toString());
%>
<tr>
	<td align="center" height="30"><%=list2.get(0).toString() %></td>
	<td align="center" height="30"><%=list2.get(1).toString() %></td>
	<td align="center" height="30"><%=list2.get(2).toString() %></td>
	<td align="center" height="30"><%=list2.get(3).toString() %></td>
	<td align="center" height="30"><a href="/zaixianbook_shop/upgouwu.jsp?id=<%=list2.get(4).toString()%>&shuliang=<%=list2.get(1).toString()%>&shuming=<%=list2.get(0).toString()%>&danjia=<%=list2.get(2).toString()%>">修改</a></td>
	<td align="center" height="30"><a href="GouWu.jsp?method=delgw&id=<%=list2.get(4).toString() %>">删除</a></td>
	</tr>
<%
	}
%>
<tr><td colspan=6 align=right>总金额:人民币<font color=red><%=f %></font>元</td></tr>
<tr>
	<td align="center" colspan="6">付款方式<select name=fukuanfangshi>
	<option value="建设银行">建设银行</option>
	<option value="工商银行">工商银行</option>
	<option value="农业银行">农业银行</option>
	<option value="招商银行">招商银行</option>
	<option value="邮局汇款">邮局汇款</option>
	</select></td>
	</tr>
<tr>
	<td align="center" colspan="6"><input type="submit" value="提交订单"></td>
	</tr>
<%
	}
%>
	
	
	</table>
	
	</form>
	
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
