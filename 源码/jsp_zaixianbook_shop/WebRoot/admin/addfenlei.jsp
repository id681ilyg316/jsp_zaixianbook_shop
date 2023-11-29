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

</script>
<link href="/zaixianbook_shop/css/local.css" rel="stylesheet" type="text/css">
<link href="/zaixianbook_shop/css/text.css" rel="stylesheet" type="text/css">
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
<form action="/zaixianbook_shop/BookManage.jsp" name="form1" onSubmit="return check()">
	 <input type="hidden" name="method" value="add">
    <table width="100%" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="121" align="center" valign="top" bgcolor="#FFFFFF"><div align="left"><br>
            <span class="black14">　<strong>当前位置:</strong>图书分类管理</span><br>
    </div>
        <table width="98%" cellpadding="0" cellspacing="0">
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
                    <table width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="100%" height="20" colspan="2" bgcolor="#009999"><p class="w14"> 　增加分类</p></td>
                        </tr>
                        <tr>
                          <td width="100%" height="100" align="center" bgColor=#ffffff>
                              <table width="35%" height="60" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td width="33%" height="29" align="right" ><strong>分类名:</strong></td>
                                  <td width="67%" align="left" >
                                  <input name="fenlei" type="text" class="input" id="admin_name" style="WIDTH: 160px" onFocus="this.className='inputfs'" onBlur="this.className='input'" value="" size="30"></td>
                                </tr>
                                   <tr>
                                  <td align="right"><input name="Submit32" type="submit" class="black12" value="确认"></td>
                                  <td align="center"><input name="Submit3" type="reset" class="black12" value="重填"></td>
                                </tr>          
                            </table></td>
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
