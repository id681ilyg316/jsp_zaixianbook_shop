<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>

<HTML><HEAD><TITLE>图书销售系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK 
href=/zaixianbook_shop/img/ys1.css type=text/css rel=stylesheet>


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
    <TD vAlign=top width=1200>
	
	<form action="/zaixianbook_shop/RegUtil.jsp" name="form1" onSubmit="return check()">
	<table border="0" align="center" width="50%">
	<tr><input type=hidden name=method value=lost>
	<td align="center" colspan="2"><br><h2>找回密码</h2><br>以下项目必须填写</td>
	</tr>
	<tr>
	<td align="center" height="30">登&nbsp;陆&nbsp;名</td>
	<td align="left" ><input type="text" name="login" size="20" maxlength="16" value=<%=(String)request.getAttribute("login")==null?"":(String)request.getAttribute("login") %>></td>
	</tr>
	<tr>
	<td align="center" height="30">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</td>
	<td align="left" ><input type="text" name="email" size="20" maxlength="16" value=<%=(String)request.getAttribute("email")==null?"":(String)request.getAttribute("email") %>></td>
	</tr>
	<tr>
	<td align="center" colspan="2"><input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重填"></td>
	</tr>
	</table>
	
	</form>
	
	</TD>
    
  </TR></TBODY></TABLE><br><br><br><br><br><br><br><br>





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
