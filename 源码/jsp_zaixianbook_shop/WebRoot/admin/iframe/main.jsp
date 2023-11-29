<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"   pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head lang="zh">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<META content=map,it2288,pic,pc,com,computer name=Keywords>
<title></title>


<link href="//css/local.css" rel="stylesheet" type="text/css">
<link href="//css/text.css" rel="stylesheet" type="text/css">

<style type="text/css">
<!--
.STYLE1 {font-size: 24px}
-->
</style>
</head>
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

<%
	String name=(String)session.getAttribute("name");
	if(name==null){
		response.sendRedirect("/zaixianbook_shop/admin/login.jsp");
	}
	else{

 %>
<body  >
<table width="95%" height="95%" cellpadding="0" cellspacing="0"  background="/zaixianbook_shop/img/houtai.jpg">
  <tr>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td height="100%" align="center" valign="top" ><br>
        <br>
        <table width="712" cellpadding="0" cellspacing="0" >
          <tr>
            <td width="710" height="169" colspan="4" align="center" vAlign=middle class="o06  STYLE4 STYLE1">欢迎登陆后台管理中心<br>
                  <br>            </td>
          </tr>
         
                  
           
          <tr>
            <td height="30" colspan="4" align="center" class="black14"><span class="STYLE17 p12"></span></td>
          </tr>
      </table>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
    </td>
  </tr>
</table>
</body>
<%} %>
</html>
