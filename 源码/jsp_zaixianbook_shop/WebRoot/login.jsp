<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>

<HTML><HEAD><TITLE>Untitled Document</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8"><LINK 
href="/zaixianbook_shop/img/ys1.css" type=text/css rel=stylesheet>
<SCRIPT language=javascript>
<!--



function check()
{
	if (document.form_logon.username.value=="")
	{
		alert("不允许输入特殊字符！");
		document.form_logon.username.focus();
		return false;
	}
	if (document.form_logon.password.value=="")
	{
		alert("不允许输入特殊字符！");
		document.form_logon.password.focus();
		return false;
	}
}	
//-->
</SCRIPT>

<STYLE type=text/css>BODY {
	MARGIN-TOP: 0px; MARGIN-LEFT: 0px
}
.style1 {
	COLOR: #680c0c
}
</STYLE>
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
<META content="MSHTML 6.00.2900.3059" name=GENERATOR></HEAD>
<%
	String name=(String)session.getAttribute("name");
	if(name==null){	
%>
<BODY text=#000000 bgColor=#efefef>
 <FORM name=form_logon onSubmit="return check()" 
  action=/zaixianbook_shop/UserLogin.jsp method=post>
<TABLE cellSpacing=0 cellPadding=0 width=515 align=center border=0>
 

  <TR><input type=hidden name=method value=user>
    <TD width=113><IMG height=29 src="/zaixianbook_shop/img/hc_index_13.gif" 
      width=110></TD>
    <TD width=25>
      <DIV align=center>ID</DIV></TD>
    <TD width=101><INPUT onmouseover=this.focus() 
      style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; FONT-SIZE: 9pt; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid; BACKGROUND-COLOR: #f9fcff" 
      onfocus=this.select() size=14 name=username></TD>
    <TD width=29>
      <DIV align=center>PS</DIV></TD>
    <TD width=97><INPUT onmouseover=this.focus() 
      style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; FONT-SIZE: 9pt; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid; BACKGROUND-COLOR: #f9fcff" 
      onfocus=this.select() type=password size=14 name=password></TD>
    <TD width=31>
      <DIV align=center><INPUT type=submit  value="登录"></DIV></TD>
    <TD width=63>
      <DIV align=center><FONT color=#680c0c><A 
      href="/zaixianbook_shop/reg.jsp" 
      target=_blank>注册会员</A></FONT></DIV></TD>
    <TD width=56>
      <DIV align=center><FONT color=#680c0c><A 
      href="/zaixianbook_shop/lost.jsp" 
      target=_blank>忘记密码</A></FONT></TD></TR></TABLE>
      </FORM>
      </BODY>
     <%}else{response.sendRedirect("login2.jsp");} %>
      </HTML>
