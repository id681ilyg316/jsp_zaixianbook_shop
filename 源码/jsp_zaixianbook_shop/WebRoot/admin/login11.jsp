<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书销售系统</title>
    
		
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="keywords" content="scclui框架">
	<meta name="description" content="scclui为轻量级的网站后台管理系统模版。">
	
	<link rel="stylesheet" href="<%=path %>/admin/common/layui/css/layui.css">
	<link rel="stylesheet" href="<%=path %>/admin/common/css/sccl.css">
	

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css">
<!--
body {
	background-color: #99CC99;
}
.STYLE1 {
	color: #99CC99;
	font-weight: bold;
}
-->
  </style></head>
  <script type="text/javascript">
  function check()
  {
  	if(document.form1.name.value==""||document.form1.pwd.value=="")
  	{
  		return false;
  	}
  }
  </script>
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
	request.removeAttribute("message");//从服务器中删除此变量

%>
  <body>
    <br> <br>
    <form action="/zaixianbook_shop/UserLogin.jsp" method=post name=form1 onSubmit="return check()">
    <table align=center width=797 height=555 background=/zaixianbook_shop/img/login-bg.jpg>
    <tr>
    <td width="600" height="549"><input type=hidden name=method value=admin>
     <table align=right width=241 >
    <tr>
    <td width="71" height="28" align=center><span class="STYLE1">登陆名</span></td>
    <td width="158" align=center><input type=text name=name size=20 ></td>
    </tr>
    <tr>
    <td height="27" align=center><span class="STYLE1">密&nbsp;&nbsp;码</span></td>
    <td width="158"align=center><input type=password name=pwd size=21></td>
    </tr>
    <tr>
    <td height="52" colspan=2 align=center><input name="submit" type=submit class="STYLE1" value="提交">      &nbsp;&nbsp;
      <input type=reset class="STYLE1" value="重填"></td>
    </tr>
    </table>
    </td>
    </tr>
    
    </table>
    </form>
  </body>
</html>
