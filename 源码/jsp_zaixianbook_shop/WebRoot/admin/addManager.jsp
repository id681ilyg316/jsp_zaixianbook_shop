<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
<!--
.cd {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	text-align: center;
	padding-top: 5px;
}
.cd1 {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: none;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	padding-top: 5px;
	text-align: center;
}
.cd2 {	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	padding-top: 5px;
	text-align: center;
}
body {
	background-image: url(images/bg-0040.gif);
}
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: none;
	color: #000000;
}
a:active {
	text-decoration: none;
	color: #000000;
}
.h14 {
	font-family: "宋体";
	font-size: 14px;
	line-height: 20px;
	color: #999999;
}
-->
</style>

<link href="/zaixianbook_shop/css/local.css" rel="stylesheet" type="text/css">
<link href="/zaixianbook_shop/css/text.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE19 {border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: solid; border-right-style: solid; border-bottom-style: none; border-left-style: none; border-top-color: #9f9f9f; border-right-color: #9f9f9f; border-bottom-color: #9f9f9f; border-left-color: #9f9f9f; font-family: "宋体"; font-size: 12px; color: #FF0000; padding-top: 5px; text-align: center; }
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

<%String name=(String)session.getAttribute("name");
	if(name==null){
		response.sendRedirect("/zaixianbook_shop/admin/login.jsp");
	}
	else{
 %>
<body >
<form action="/zaixianbook_shop/AddManager.jsp" name="form1" onSubmit="return check()">
	 <input type="hidden" name="method" value="add">
    <table width="100%" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="121" align="center" valign="top" bgcolor="#FFFFFF"><div align="left"><br>
            <span class="black14">　<strong>当前位置:</strong>帐户管理</span><br>
    </div>
        <table width="98%" cellpadding="0" cellspacing="0">
         
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
                    <table width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="100%" height="20" colspan="2" bgcolor="#009999"><p class="w14"> 　新建帐号</p></td>
                        </tr>
                        <tr>
                          <td width="100%" height="100" align="center" bgColor=#ffffff><span class="hb"> <br>
                            </span>
                              <table width="59%" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td align="right"  height="30">登录名（英文字母或数字6-10位，不能有空格）:</td>
                                  <td width="205"><INPUT class=input id=admin_name 
                              onblur="this.className='input'" type="text"
                              style="WIDTH: 160px" 
                              onfocus="this.className='inputfs'" maxLength=10 
                              size=28 name="admin_name" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"  value="<%=request.getParameter("admin_name")==null?"":request.getParameter("admin_name") %>"></td>
                                </tr>
                                <tr>
                                  <td align="right"  height="30">密码（英文字母或数字6-16位，不能有空格）:</td>
                                  <td><INPUT class=input id=admin_password 
                              onblur="this.className='input'"  type="password"
                              style="WIDTH: 160px" 
                              onfocus="this.className='inputfs'" maxLength=16 
                              size=28 name=admin_password onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"  ></td>
                                </tr>
                                <tr>
                                  <td align="right"  height="30">确认密码:</td>
                                  <td><INPUT class=input id=repassword 
                              onblur="this.className='input'"   type="password"
                              style="WIDTH: 160px" 
                              onfocus="this.className='inputfs'" maxLength=16 
                              size=28 name=repassword  onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')" ></td>
                                </tr>                       
                            </table></td>
                        </tr>
                        <tr>
                          <td height="30" colspan="2" align="center" bgColor=#ffffff><br>
                              <table width="200" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td><input name="Submit32" type="submit" class="black12" value="确认"></td>
                                  <td><input name="Submit3" type="reset" class="black12" value="重填"></td>
                                </tr>
                              </table>
                            <br></td>
                        </tr>
              </table>
                        <br>
            </td>
                  </tr>
                  <tr>
                    <td height="4" align="center" bordercolor="#5D8191" class="12txt18">&nbsp;</td>
                  </tr>
                </table>
                <br>
                <br></TD>
          </TR>
      </table>
</form>
</body>
<%} %>
</html>
