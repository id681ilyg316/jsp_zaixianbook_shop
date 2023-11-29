<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>

<!-- saved from url=(0048)http://www.huachu.com.cn/index/index_logon20.asp -->
<HTML><HEAD><TITLE>U图书销售系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8"><LINK 
href="/zaixianbook_shop/img/ys1.css" type=text/css rel=stylesheet>
<SCRIPT language=javascript>
<!--

function chkstr(a)
{	
	var temp = a.indexOf('法轮');
	var temp1 = a.indexOf('李洪志');
	var temp2 = a.indexOf("'");
	//var temp3 = a.indexOf('/');
	var temp4 = a.indexOf('%');
	//var temp5 = a.indexOf('>');
	if ((temp==-1)&&(temp1==-1)&&(temp2==-1)&&(temp4==-1))
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

function checkform()
{
	if (chkstr(document.form_logon.username.value)==0)
	{
		alert("不允许输入特殊字符！");
		document.form_logon.username.focus();
		return false;
	}
	if (chkstr(document.form_logon.password.value)==0)
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

<META content="MSHTML 6.00.2900.3059" name=GENERATOR></HEAD>
<%
	String name=(String)session.getAttribute("name");
	if(name!=null){	
	String jibie=new UserLoginBean().getJiBie(name).trim();
	int f=0;
	if(jibie.equals("普通")){
		f=9;
	}
	else if(jibie.equals("银卡")){
		f=8;
	}
	else if(jibie.equals("金卡")){
		f=7;
	}System.out.println(f+"ffffffffffffff");
%>
<BODY text=#000000 bgColor=#efefef>
<TABLE cellSpacing=0 cellPadding=0 width=515 align=center border=0>
  <TBODY>
  <TR>
    <TD width=515 align=center><br>欢迎您，尊敬的会员<%=name %>&nbsp;&nbsp;<%=jibie %>级会员，可享受<%=f %>折优惠&nbsp;&nbsp;<a href="center.jsp" target="_parent">会员中心</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=/zaixianbook_shop/LoginOut.jsp?method=user>退出登陆</a></TD>
   </TR></TBODY></TABLE></BODY>
<%}else{
	response.sendRedirect("loign.jsp");
} %>   
</HTML>
