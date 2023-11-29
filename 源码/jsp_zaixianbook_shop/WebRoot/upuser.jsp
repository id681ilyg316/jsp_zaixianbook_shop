<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>


<HTML><HEAD><TITLE>图书销售系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href=/zaixianbook_shop/img/ys1.css type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3059" name=GENERATOR>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 16px;
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
     <TD align=center vAlign=top width=1200 height=389>
	
	<table bgcolor=#99CCCC align=left width=100 border=0 height=404>
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
	<td height="58" bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td height="25" bordercolor="#000000" bgcolor="#99CCCC"><a href="">&nbsp;</a></td>
	</tr>
	</table>
	<script language="javascript">
function check()
{
	if(document.form1.login.value==""||document.form1.password.value==""||document.form1.name.value==""||document.form1.email.value==""||document.form1.tel.value=="")
	{
		alert("必须填写所有项目！");
		return false;
	}
}
</script>	
<%
	List list=new UserLoginBean().getUser(name);
%>
	<form action="/zaixianbook_shop/RegUtil.jsp" name="form1" onSubmit="return check()">
	<table align=right width=700 border=0 height=300>
	<tr><input type=hidden name=method value=up><input type=hidden name=login value=<%=list.get(1).toString() %>>
	<td align="center" colspan="2"><p><br>
	    <span class="STYLE2" >用户注册信息</span><br>
	   <br>
	   (以下项目必须填写)</p>
	  </td>
	</tr>
	<tr>
	<td width=300 align="right" height="30">登&nbsp;陆&nbsp;名</td>
	<td align="left" ><%=list.get(1).toString() %></td>
	</tr>
	<tr>
	<td align="right"  height="30">密码(6位)</td>
	<td align="left" ><input type="password" name="password" size="20" maxlength="16" value=<%=list.get(2).toString() %>></td>
	</tr>
	<tr>
	<td align="right" height="30">真实姓名</td>
	<td align="left" ><input type="text" name="name" size="20" maxlength="16" value=<%=list.get(3).toString() %>></td>
	</tr>
	<tr> 
	<td align="right" height="30">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
	<td align="left" ><input type="radio" name="sex"  value="男" checked="checked">
	男   <input type="radio" name="sex" value="女"> 
	女</td>
	</tr>
	<tr>
	<td align="right" height="30">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</td>
	<td align="left" ><input type="text" name="email" size="20" maxlength="16" value=<%=list.get(5).toString() %>></td>
	</tr>
	<tr>
	<td align="right" height="30">电&nbsp;&nbsp;&nbsp;&nbsp;话</td>
	<td align="left" ><input type="text" name="tel" size="20" maxlength="16" value=<%=list.get(6).toString() %>></td>
	</tr>
	<tr>
	<td height="23" colspan="2" align="center"><input type="submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重填"></td>
	</tr>
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
